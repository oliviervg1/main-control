package com.pi.main.ressources;

import java.util.ArrayList;

public class DeviceManager {
	private ArrayList<ConnectedDevice> deviceList;
	
	public DeviceManager() {
		deviceList = new ArrayList<ConnectedDevice>();
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
}
