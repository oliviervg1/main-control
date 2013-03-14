package com.pi.main.apps.ressources;

import javax.xml.namespace.QName;

import automation.api.AbstractClient;

public class LightingClient extends AbstractClient{
 
	public LightingClient() {
		super("http://192.168.0.9:8080/relay-control-1.0.0/SocketController?wsdl", new QName("http://relay.pi.com/", "SocketControllerService"));
	}
	
	public void turnOn() {
		try {
			device.invokeMethod("powerOn");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void turnOff() {
		try {
			device.invokeMethod("powerOff");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getState() {
		String state = "unknown";
		try {
			state = "Power is currently " + (String) device.invokeMethod("getState");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	public String homeTile() {
		String state = "unknown";
		try {
			state = "Power is currently " + (String) device.invokeMethod("getState");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
}