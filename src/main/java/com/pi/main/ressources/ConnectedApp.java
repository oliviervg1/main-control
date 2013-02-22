package com.pi.main.ressources;

import com.pi.main.apps.ressources.AbstractClient;

public class ConnectedApp {
	private String name;
	private String URL;
	private AbstractClient client;
	
	public ConnectedApp(String name, String URL, AbstractClient client) {
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

	public AbstractClient getClient() {
		return client;
	}

	public void setClient(AbstractClient client) {
		this.client = client;
	}
}
