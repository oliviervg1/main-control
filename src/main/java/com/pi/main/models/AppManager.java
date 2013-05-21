package com.pi.main.models;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import automation.api.interfaces.ConnectedApp;

public class AppManager {
	
	private static ArrayList<App> appList;
	private static ClassLoader classLoader;
	private static final String appDir = "file:///home/pi/FYP/apps/";
	private static AppLoader appLoader;
	
	public AppManager() {
		appList = new ArrayList<App>();
		appLoader = new AppLoader();
		
		//TODO Implement a proper add app function
		try {
			classLoader = new URLClassLoader(new URL[] {new URL(appDir + "lights-app-1.0.0.jar")}, ConnectedApp.class.getClassLoader());
			appLoader.loadAppDetails(new URL(appDir + "lights.xml"));
			addApp(new App.Builder()
				.name(appLoader.getName())
				.pageName(appLoader.getPageName())
				.URL(appLoader.getUrl())
				.description(appLoader.getDescription())
				.icon(appLoader.getIcon())
				.app((ConnectedApp) classLoader.loadClass(appLoader.getClassPackage()).newInstance())
				.methodsAvailable(appLoader.getMethods())
				.build());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			classLoader = new URLClassLoader(new URL[] {new URL(appDir + "media-app-1.0.0.jar")}, ConnectedApp.class.getClassLoader());
			appLoader.loadAppDetails(new URL(appDir + "media.xml"));
			addApp(new App.Builder()
				.name(appLoader.getName())
				.pageName(appLoader.getPageName())
				.URL(appLoader.getUrl())
				.description(appLoader.getDescription())
				.icon(appLoader.getIcon())
				.app((ConnectedApp) classLoader.loadClass(appLoader.getClassPackage()).newInstance())
				.methodsAvailable(appLoader.getMethods())
				.build());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<App> getAppList() {
		return appList;
	}
	
	public void setAppList(ArrayList<App> appList) {
		AppManager.appList = appList;
	}
	
	public void addApp(App app) {
		if (appList.contains(app) == false) {
			appList.add(app);
		}
	}
	
	public void removeApp(App app) {
		appList.remove(app);
	}
	
	public App getApp(String appURL) {
		for (App app : appList) {
			if (app.getURL().equalsIgnoreCase(appURL)) {
				return app;
			}
		}
		return null;
	}
}
