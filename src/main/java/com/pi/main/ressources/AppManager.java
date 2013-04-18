package com.pi.main.ressources;

import java.util.ArrayList;

import com.pi.main.apps.DummyClient;
import com.pi.main.apps.LightingClient;
import com.pi.main.apps.MediaClient;

public class AppManager {
	
	private static String selectedURL;
	private static ArrayList<ConnectedApp> appList;
	
	public AppManager() {
		appList = new ArrayList<ConnectedApp>();
		selectedURL = null;
		
		//TODO Implement a proper add app function
		addApp(new ConnectedApp.Builder()
			.name("Lights")
			.pageName("Let there be lights!")
			.URL("lights")
			.description("The 'Lights' application allows you to remotely monitor the energy consumption of a power socket. You can also turn it on or off!")
			.client(new LightingClient())
			.build());
		
		addApp(new ConnectedApp.Builder()
			.name("Media")
			.pageName("Care to listen to some music?")
			.URL("media")
			.description("The 'Media' application allows you to listen to music or watch videos anywhere in your house!")
			.client(new MediaClient())
			.build());
		
		// DUMMY APPS FOR TESTING PURPOSES
		addApp(new ConnectedApp.Builder()
			.name("Dummy")
			.pageName("This is a DUMMY APP!")
			.URL("dummy")
			.description("LOLOL")
			.client(new DummyClient())
			.build());
	}
	
	public ArrayList<ConnectedApp> getAppList() {
		return appList;
	}
	
	public void setAppList(ArrayList<ConnectedApp> appList) {
		AppManager.appList = appList;
	}
	
	public void addApp(ConnectedApp app) {
		if (appList.contains(app) == false) {
			appList.add(app);
		}
	}
	
	public void removeApp(ConnectedApp app) {
		appList.remove(app);
	}

	public String getSelectedURL() {
		return selectedURL;
	}

	public void setSelectedURL(String selectedURL) {
		AppManager.selectedURL = selectedURL;
	}
	
	public ConnectedApp getApp(String appURL) {
		for (ConnectedApp app : appList) {
			if (app.getURL().equalsIgnoreCase(appURL)) {
				return app;
			}
		}
		return null;
	}
}
