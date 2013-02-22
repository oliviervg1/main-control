package com.pi.main.ressources;

import java.util.ArrayList;

import com.pi.main.apps.ressources.AbstractClient;

public class AppManager {
	
	private static String selectedURL;
	private static ArrayList<ConnectedApp> appList;
	
	public AppManager() {
		appList = new ArrayList<ConnectedApp>();
		selectedURL = null;
		addApp(new ConnectedApp("Lights", "lights", new AbstractClient()));
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
	
	public ConnectedApp getApp(String appName) {
		for (ConnectedApp app : appList) {
			if (app.getName().equalsIgnoreCase(appName)) {
				return app;
			}
		}
		return null;
	}
}
