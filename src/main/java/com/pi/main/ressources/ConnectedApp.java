package com.pi.main.ressources;

import automation.api.interfaces.ConnectedClient;


public class ConnectedApp {
	private String name;
	private String URL;
	private ConnectedClient client;
	
	public ConnectedApp(String name, String URL, ConnectedClient client) {
		this.name = name;
		this.URL = URL;
		this.client = client;
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

	public ConnectedClient getClient() {
		return client;
	}

	public void setClient(ConnectedClient client) {
		this.client = client;
	}
}
