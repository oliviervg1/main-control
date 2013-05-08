package com.pi.main.ressources;

import java.util.ArrayList;

import com.pi.main.apps.DummyApp;
import com.pi.main.apps.LightsApp;
import com.pi.main.apps.MediaApp;

public class AppManager {
	
	private static String selectedURL;
	private static ArrayList<App> appList;
	
	public AppManager() {
		appList = new ArrayList<App>();
		selectedURL = null;
		
		//TODO Implement a proper add app function
		addApp(new App.Builder()
			.name("Lights")
			.pageName("Let there be lights!")
			.URL("lights")
			.description("The 'Lights' application allows you to remotely monitor the energy consumption of a power socket. You can also turn it on or off!")
			.icon("icon-lightbulb")
			.app(new LightsApp())
			.build());
		
		addApp(new App.Builder()
			.name("Media")
			.pageName("Care to listen to some music?")
			.URL("media")
			.description("The 'Media' application allows you to listen to music or watch videos anywhere in your house!")
			.icon("icon-music")
			.app(new MediaApp())
			.build());
		
		// DUMMY APPS FOR TESTING PURPOSES
		addApp(new App.Builder()
			.name("Dummy")
			.pageName("This is a DUMMY APP!")
			.URL("dummy")
			.description("LOLOL")
			.icon("icon-circle-blank")
			.app(new DummyApp())
			.build());
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
