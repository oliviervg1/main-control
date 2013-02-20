package com.pi.main.ressources;

import java.util.ArrayList;

public class DeviceManager {
	private ArrayList<ConnectedDevice> deviceList;
	private String selectedURL;
	
	public DeviceManager() {
		deviceList = new ArrayList<ConnectedDevice>();
		selectedURL = null;
		addDevice(new ConnectedDevice("Lights", "lights"));
	}
	
	public ArrayList<ConnectedDevice> getDeviceList() {
		return deviceList;
	}
	
	public void setDeviceList(ArrayList<ConnectedDevice> deviceList) {
		this.deviceList = deviceList;
	}
	
	public void addDevice(ConnectedDevice device) {
		deviceList.add(device);
	}
	
	public void removeDevice(ConnectedDevice device) {
		deviceList.remove(device);
	}

	public String getSelectedURL() {
		return selectedURL;
	}

	public void setSelectedURL(String selectedURL) {
		this.selectedURL = selectedURL;
	}
}
