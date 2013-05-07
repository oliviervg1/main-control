package com.pi.main.ressources;

import automation.api.interfaces.ConnectedApp;

public class App {
	private final String name;
	private final String pageName;
	private final String URL;
	private final String description;
	private final ConnectedApp app;
	
	public static class Builder {
		private String name;
		private String pageName;
		private String URL;
		private String description;
		private ConnectedApp app;
		
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
        
        public Builder app(ConnectedApp app) {
        	this.app = app; 
        	return this; 
        }
      
        //return fully built object
        public App build() {
            return new App(this);
        }
	}
	
	private App(Builder builder) {
		this.name = builder.name;
		this.pageName = builder.pageName;
		this.URL = builder.URL;
		this.app = builder.app;
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

	public ConnectedApp getApp() {
		return app;
	}
}
