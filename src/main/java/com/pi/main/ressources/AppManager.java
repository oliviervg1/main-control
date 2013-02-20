package com.pi.main.ressources;

import java.util.ArrayList;

public class AppManager {
	private ArrayList<ConnectedApp> appList;
	private String selectedURL;
	
	public AppManager() {
		appList = new ArrayList<ConnectedApp>();
		selectedURL = null;
		addDevice(new ConnectedApp("Lights", "lights")); // This is temporary!
	}
	
	public ArrayList<ConnectedApp> getAppList() {
		return appList;
	}
	
	public void setDeviceList(ArrayList<ConnectedApp> appList) {
		this.appList = appList;
	}
	
	public void addDevice(ConnectedApp app) {
		appList.add(app);
	}
	
	public void removeDevice(ConnectedApp app) {
		appList.remove(app);
	}

	public String getSelectedURL() {
		return selectedURL;
	}

	public void setSelectedURL(String selectedURL) {
		this.selectedURL = selectedURL;
	}
}
