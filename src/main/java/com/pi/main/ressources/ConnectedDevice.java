package com.pi.main.ressources;

public class ConnectedDevice {
	private String name;
	private String URL;
	
	public ConnectedDevice(String name, String URL) {
		this.name = name;
		this.URL = URL;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String URL) {
		this.URL = URL;
	}
}
