package com.pi.main.apps;

import java.io.File;
import java.util.ArrayList;

import javax.xml.namespace.QName;

import automation.api.AbstractClient;

public class LightingClient extends AbstractClient{
		
	@Override
	public void onStartup() {
		connectToRemoteDevice("http://192.168.0.9:8080/relay-control-1.0.0/SocketController?wsdl", new QName("http://relay.pi.com/", "SocketControllerService"));
	}
	
	public void turnOn() throws Exception {
		if (isDeviceAvailable()) {
			device.invokeMethod("powerOn");
		}
	}
	
	public void turnOff() throws Exception {
		if (isDeviceAvailable()) {
			device.invokeMethod("powerOff");
		}
	}
	
	@Override
	public String getState() throws Exception {
		String state = "Device unavailable";
		if (isDeviceAvailable()) {
			state = "Power is currently " + (String) device.invokeMethod("getState");
		}
		return state;
	}
	
	@Override
	public String homeTile() throws Exception {
		String state = "Device unavailable";
		if (isDeviceAvailable()) {
			state = "Power is currently " + (String) device.invokeMethod("getState");
		}
		return state;
	}

	@Override
	public ArrayList<String> getModels() throws Exception {
		return new ArrayList<String>();
	}

	@Override
	public void uploadFile(String fileName, File fileData)
			throws Exception {}
}