package com.pi.main.ressources;

import java.util.ArrayList;

import com.pi.main.apps.ressources.LightingClient;

public class AppManager {
	
	private static String selectedURL;
	private static ArrayList<ConnectedApp> appList;
	
	public AppManager() {
		appList = new ArrayList<ConnectedApp>();
		selectedURL = null;
		
		//TODO Implement a proper add app function
		//TODO implement DSL here!
		addApp(new ConnectedApp("Lights", "lights", new LightingClient())); 
		
		// DUMMY APPS FOR TESTING PURPOSES
//		addApp(new ConnectedApp("Dummy", "dummy", null));
//		addApp(new ConnectedApp("Dummy", "dummy", null));
//		addApp(new ConnectedApp("Dummy", "dummy", null));
//		addApp(new ConnectedApp("Dummy", "dummy", null));
//		addApp(new ConnectedApp("Dummy", "dummy", null));
//		addApp(new ConnectedApp("Dummy", "dummy", null));
//		addApp(new ConnectedApp("Dummy", "dummy", null));
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
