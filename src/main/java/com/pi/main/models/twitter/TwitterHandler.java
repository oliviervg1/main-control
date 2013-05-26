package com.pi.main.models.twitter;

import com.pi.main.models.apps.App;
import com.pi.main.models.apps.AppManager;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterHandler {

	private AppManager appManager;
	private TwitterListener asyncListener;
	private AsyncTwitter twitter;
	private TwitterStream twitterStream;
	private StatusListener listener;	
	private ConfigurationBuilder cb;
		
	public TwitterHandler() {
		//Set OAUTH parameters
		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(false)
			.setOAuthConsumerKey(TwitterParameters.CONSUMER_KEY)
			.setOAuthConsumerSecret(TwitterParameters.CONSUMER_SECRET)
			.setOAuthAccessToken(TwitterParameters.ACCESS_TOKEN)
			.setOAuthAccessTokenSecret(TwitterParameters.ACCESS_TOKEN_SECRET);
		
		//Instantiate Twitter and TwitterStream
		twitter = new AsyncTwitterFactory(cb.build()).getInstance();
		twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
		
	    //Create and add listeners
		asyncListener = new TwitterAdapter();
		twitter.addListener(asyncListener);
		listener = createListener();
		twitterStream.addListener(listener);
		
		//Get the App Manager
		appManager = new AppManager();
	}
	
	public void start(String[] keywords) {
		twitterStream.filter(new FilterQuery().track(keywords));
	}
	
	public void stop() {
		twitterStream.cleanUp();
		twitterStream.shutdown();
	}
	
	private StatusListener createListener() {
		StatusListener tempListener = new StatusListener() {
			public void onStatus(Status status) {
				for (String user : TwitterParameters.authorisedUsers) {
					if (status.getUser().getScreenName().equalsIgnoreCase(user)) {
						if (status.getText().contains("House")) {
							processInput(status.getText());
						} else {
							twitter.updateStatus("@" + status.getUser().getScreenName() + " , it seems like you forgot the magic word ;)");
						}
					} else {
						twitter.updateStatus("@" + status.getUser().getScreenName() + " INTRUDER ALERT! RAISE THE SHIELDS MR SPOCK!");
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
							twitter.updateStatus("Status for '" + app.getName() + "' is now: " + app.getApp().invokeMethod("getStatus"));
						} catch (Exception e) {
							twitter.updateStatus("Oh uh... Seems like something went wrong. Was unable to do: "+ text);
						}
					}
				}
			}
		}
	}
}