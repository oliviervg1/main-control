package com.pi.main.apps.ressources;

public class AbstractClient {
 
	public AbstractClient() {
		//super("http://192.168.0.9:8080/relay-control-1.0.0/SocketController?wsdl", new QName("http://relay.pi.com/", "SocketControllerService"));
	}
	
	public String powerOn() {
//		try {
//			device.invokeMethod("powerOn");
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "ON!";
	}
	
	public String powerOff() {
//		try {
//			device.invokeMethod("powerOff");
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "OFF!";
	}
	
	public String getState() {
//		try {
//			device.invokeMethod("getState");
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "STATE!";
	}
}