package com.pi.main.ressources;

import java.util.HashMap;

import automation.api.interfaces.ConnectedApp;

public class App {
	private final String name;
	private final String pageName;
	private final String URL;
	private final String description;
	private final String icon;
	private final ConnectedApp app;
	private final HashMap<String, String> methodsAvailable;
	
	public static class Builder {
		private String name;
		private String pageName;
		private String URL;
		private String description;
		private String icon;
		private ConnectedApp app;
		private HashMap<String, String> methodsAvailable;
	
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
        
        public Builder icon(String icon) {
        	this.icon = icon;
        	return this;
        }
        
        public Builder app(ConnectedApp app) {
        	this.app = app; 
        	return this; 
        }
        
        public Builder methodsAvailable(HashMap<String,String> methods) {
        	this.methodsAvailable = methods;
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
		this.icon = builder.icon;
		this.description = builder.description;
		this.methodsAvailable = builder.methodsAvailable;
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
	
	public String getIcon() {
		return icon;
	}

	public ConnectedApp getApp() {
		return app;
	}
	
	public HashMap<String, String> getMethodsAvailable() {
		return methodsAvailable;
	}
}
