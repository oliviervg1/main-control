package com.pi.main.ressources;

import automation.api.interfaces.ConnectedClient;

public class ConnectedApp {
	private final String name;
	private final String pageName;
	private final String URL;
	private final String description;
	private final ConnectedClient client;
	
	public static class Builder {
		private String name;
		private String pageName;
		private String URL;
		private String description;
		private ConnectedClient client;
		
		//builder methods for setting property
        public Builder name(String name) {
        	this.name = name; 
        	return this; 
        }
        
        public Builder pageName(String pageName) {
        	this.pageName = pageName; 
        	return this; 
        }
        
        public Builder URL(String URL) {
        	this.URL = URL; 
        	return this; 
        }
        
        public Builder description(String description) {
        	this.description = description; 
        	return this; 
        }
        
        public Builder client(ConnectedClient client) {
        	this.client = client; 
        	return this; 
        }
      
        //return fully built object
        public ConnectedApp build() {
            return new ConnectedApp(this);
        }
	}
	
	private ConnectedApp(Builder builder) {
		this.name = builder.name;
		this.pageName = builder.pageName;
		this.URL = builder.URL;
		this.client = builder.client;
		this.description = builder.description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPageName() {
		return pageName;
	}
	
	public String getURL() {
		return URL;
	}
	
	public String getDescription() {
		return description;
	}

	public ConnectedClient getClient() {
		return client;
	}
}
