package com.pi.main.ressources;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;

import automation.api.interfaces.ConnectedApp;

public class AppManager {
	
	private static ArrayList<App> appList;
	private static ClassLoader loader;
	private static final String appDir = "file:///home/pi/FYP/apps/";
	
	@SuppressWarnings("serial")
	public AppManager() {
		appList = new ArrayList<App>();
		
		//TODO Implement a proper add app function
		try {
			loader = new URLClassLoader(new URL[] {new URL(appDir + "lights-app-1.0.0.jar")}, ConnectedApp.class.getClassLoader());
			addApp(new App.Builder()
				.name("Lights")
				.pageName("Let there be lights!")
				.URL("lights")
				.description("The 'Lights' application allows you to remotely monitor the energy consumption of a power socket. You can also turn it on or off!")
				.icon("icon-lightbulb")
				.app((ConnectedApp) loader.loadClass("com.pi.LightsApp").newInstance())
				.methodsAvailable(new HashMap<String,String>() {
					{
						put("On", "turnOn");
						put("Off", "turnOff");
					}
				})
				.build());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			loader = new URLClassLoader(new URL[] {new URL(appDir + "media-app-1.0.0.jar")}, ConnectedApp.class.getClassLoader());
			addApp(new App.Builder()
				.name("Media")
				.pageName("Care to listen to some music?")
				.URL("media")
				.description("The 'Media' application allows you to listen to music or watch videos anywhere in your house!")
				.icon("icon-music")
				.app((ConnectedApp) loader.loadClass("com.pi.MediaApp").newInstance())
				.methodsAvailable(new HashMap<String,String>())
				.build());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | MalformedURLException e) {
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
	
	public App getApp(String appURL) {
		for (App app : appList) {
			if (app.getURL().equalsIgnoreCase(appURL)) {
				return app;
			}
		}
		return null;
	}
}
