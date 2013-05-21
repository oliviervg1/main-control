package com.pi.main.ressources;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;

import automation.api.interfaces.ConnectedApp;

public class AppManager {
	
	private static String selectedURL;
	private static ArrayList<App> appList;
	private static ClassLoader classLoader;
	
	@SuppressWarnings("serial")
	public AppManager() {
		appList = new ArrayList<App>();
		selectedURL = null;
		try {
			classLoader = new URLClassLoader(new URL[] {new URL("file:///home/pi/FYP/apache-tomcat-7.0.35/webapps/ROOT/WEB-INF/classes/")}, ConnectedApp.class.getClassLoader());
		} catch (MalformedURLException e1) {
			System.err.println("Unable to initiate app loader. Check that app folder exists!");
			System.exit(1);
		}
		
		//TODO Implement a proper add app function
		try {
			addApp(new App.Builder()
				.name("Lights")
				.pageName("Let there be lights!")
				.URL("lights")
				.description("The 'Lights' application allows you to remotely monitor the energy consumption of a power socket. You can also turn it on or off!")
				.icon("icon-lightbulb")
				.app((ConnectedApp) classLoader.loadClass("com.pi.main.apps.LightsApp").newInstance())
				.methodsAvailable(new HashMap<String,String>() {
					{
						put("On", "turnOn");
						put("Off", "turnOff");
					}
				})
				.build());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addApp(new App.Builder()
				.name("Media")
				.pageName("Care to listen to some music?")
				.URL("media")
				.description("The 'Media' application allows you to listen to music or watch videos anywhere in your house!")
				.icon("icon-music")
				.app((ConnectedApp) classLoader.loadClass("com.pi.main.apps.MediaApp").newInstance())
				.methodsAvailable(new HashMap<String,String>())
				.build());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DUMMY APPS FOR TESTING PURPOSES
		try {
			addApp(new App.Builder()
				.name("Dummy")
				.pageName("Danger: test zone")
				.URL("dummy")
				.description("This is where I test features before moving them into production.")
				.icon("icon-circle-blank")
				.app((ConnectedApp) classLoader.loadClass("com.pi.main.apps.DummyApp").newInstance())
				.methodsAvailable(new HashMap<String,String>())
				.build());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<App> getAppList() {
		return appList;
	}
	
	public void setAppList(ArrayList<App> appList) {
		AppManager.appList = appList;
	}
	
	public void addApp(App app) {
		if (appList.contains(app) == false) {
			appList.add(app);
		}
	}
	
	public void removeApp(App app) {
		appList.remove(app);
	}

	public String getSelectedURL() {
		return selectedURL;
	}

	public void setSelectedURL(String selectedURL) {
		AppManager.selectedURL = selectedURL;
	}
	
	public App getApp(String appURL) {
		for (App app : appList) {
			if (app.getURL().equalsIgnoreCase(appURL)) {
				return app;
			}
		}
		return null;
	}
}
