package com.pi.main.models.twitter;

import com.pi.main.models.apps.App;
import com.pi.main.models.apps.AppManager;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterHandler {

    private AppManager appManager;
    private Twitter twitter;
    private TwitterStream twitterStream;
    private StatusListener listener;

    public TwitterHandler() {
        //Set OAUTH parameters
        ConfigurationBuilder cb = new ConfigurationBuilder();
        Configuration configuration = cb.setDebugEnabled(false)
            .setOAuthConsumerKey(TwitterParameters.CONSUMER_KEY)
            .setOAuthConsumerSecret(TwitterParameters.CONSUMER_SECRET)
            .setOAuthAccessToken(TwitterParameters.ACCESS_TOKEN)
            .setOAuthAccessTokenSecret(TwitterParameters.ACCESS_TOKEN_SECRET)
            .build();

        //Instantiate Twitter and TwitterStream
        twitter = new TwitterFactory(configuration).getInstance();
        twitterStream = new TwitterStreamFactory(configuration).getInstance();

        //Create and add listeners
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
                    // User is authorised
                    if (status.getUser().getScreenName().equalsIgnoreCase(user)) {
                        // Command is valid
                        if (status.getText().contains("House")) {
                            processInput(status);
                            return;
                        } else {
                            updateStatus(
                                "@" + status.getUser().getScreenName() + ", it seems like you forgot the magic word ;)",
                                status.getId()
                            );
                            return;
                        }
                    }
                }
                // Unauthorised user
                updateStatus(
                    "@" + status.getUser().getScreenName() + " INTRUDER ALERT! RAISE THE SHIELDS MR SPOCK!",
                    status.getId()
                );
            }
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
            public void onException(Exception ex) {}
            public void onScrubGeo(long arg0, long arg1) {}
            public void onStallWarning(StallWarning arg0) {}
        };
        return tempListener;
    }

    private void processInput(Status status) {
        // Check if command belongs to a given app
        for (App app : appManager.getAppList()) {
            // App is found
            if (status.getText().contains(app.getName())) {
                for (String key : app.getMethodsAvailable().keySet()) {
                    // Command is valid
                    if (status.getText().contains(key)) {
                        try {
                            app.getApp().invokeMethod(app.getMethodsAvailable().get(key));
                            updateStatus(
                                "@" + status.getUser().getScreenName() + " Status of '" + app.getName() + "' is: " + app.getApp().invokeMethod("getState"),
                                status.getId()
                            );
                        } catch (Exception e) {
                            updateStatus(
                                "@" + status.getUser().getScreenName() + " Oh uh... Seems like something went wrong. Was unable to do: " + status,
                                status.getId()
                            );
                        }
                    }
                }
            }
        }
    }

    private void updateStatus(String tweetBody, long tweetToReplyTo) {
        try {
            twitter.updateStatus(new StatusUpdate(tweetBody).inReplyToStatusId(tweetToReplyTo));
        } catch (TwitterException e) {}
    }
}