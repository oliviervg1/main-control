package com.pi.main.models;

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
	}
	
	public ArrayList<App> getAppList() {
		return appList;
	}
	
	public void setAppList(ArrayList<App> appList) {
		AppManager.appList = appList;
	}
	
	public void loadApp(String xmlFile) throws Exception {
		appLoader.loadAppDetails(new URL(appDir + xmlFile));
		classLoader = new URLClassLoader(new URL[] {new URL(appDir + appLoader.getLocation())}, ConnectedApp.class.getClassLoader());
		addApp(new App.Builder()
			.fileName(appLoader.getLocation())
			.name(appLoader.getName())
			.pageName(appLoader.getPageName())
			.URL(appLoader.getUrl())
			.description(appLoader.getDescription())
			.icon(appLoader.getIcon())
			.app((ConnectedApp) classLoader.loadClass(appLoader.getClassPackage()).newInstance())
			.methodsAvailable(appLoader.getMethods())
			.build());
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
