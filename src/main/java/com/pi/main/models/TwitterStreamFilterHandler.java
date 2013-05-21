package com.pi.main.models;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterStreamFilterHandler {

	private AppManager appManager;
	private TwitterStream twitterStream;
	private StatusListener listener;
	private String[] filterKeywords;
	private ConfigurationBuilder cb;
	private boolean started;
		
	public TwitterStreamFilterHandler(String[] keywords) {
		//Set OAUTH parameters
		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(false)
			.setOAuthConsumerKey(TwitterParameters.CONSUMER_KEY)
			.setOAuthConsumerSecret(TwitterParameters.CONSUMER_SECRET)
			.setOAuthAccessToken(TwitterParameters.ACCESS_TOKEN)
			.setOAuthAccessTokenSecret(TwitterParameters.ACCESS_TOKEN_SECRET);
		
		//Not running yet
		started = false;
		
		//Instantiate TwitterStream
		twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
		
	    //Create and add stream listener
		listener = createListener();
		twitterStream.addListener(listener);
		
		//Set filterKeywords
		filterKeywords = keywords;
		
		//Get the App Manager
		appManager = new AppManager();
	}
	
	public void changeFilterKeywords(String[] keywords) {
		if (started) {
			stop();
			filterKeywords = keywords;
			start();
		} else {
			filterKeywords = keywords;
		}
	}
	
	public void start() {
		if (filterKeywords != null) {
			twitterStream.filter(new FilterQuery().track(filterKeywords));
			started = true;
		}
	}
	
	public void stop() {
		twitterStream.cleanUp();
		twitterStream.shutdown();
	}
	
	private StatusListener createListener() {
		StatusListener tempListener = new StatusListener() {
			public void onStatus(Status status) {
				for (String user : TwitterParameters.authorisedUsers) {
					if (status.getUser().getScreenName().equalsIgnoreCase(user) && status.getText().contains("House")) {
						processInput(status.getText());
					} 
				}
			}
			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
			public void onException(Exception ex) {}
			public void onScrubGeo(long arg0, long arg1) {}
			public void onStallWarning(StallWarning arg0) {}
		};
		return tempListener;
	}
	
	private void processInput(String text) {
		for (App app : appManager.getAppList()) {
			if (text.contains(app.getName())) {
				for (String key : app.getMethodsAvailable().keySet()) {
					if (text.contains(key)) {
						try {
							app.getApp().invokeMethod(app.getMethodsAvailable().get(key));
						} catch (Exception e) {
							//TODO fix this
						}
					}
				}
			}
		}
	}
}