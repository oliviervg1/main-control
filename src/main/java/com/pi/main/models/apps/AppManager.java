package com.pi.main.models.apps;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import automation.api.interfaces.ConnectedApp;

public class AppManager {

    private static final String appDir = "/apps/";
    private static ArrayList<String> xmlList;
    private static ArrayList<App> appList;
    private static ClassLoader classLoader;
    private static AppLoader appLoader;
    private static AppListLoader appListLoader;

    public AppManager() {
        appList = new ArrayList<App>();
        appListLoader = new AppListLoader();
        xmlList = appListLoader.loadAppList();
        appLoader = new AppLoader();
        reloadApps();
    }

    public ArrayList<App> getAppList() {
        return appList;
    }

    public void reloadApps() {
        for (String xmlFile : xmlList) {
            try {
                loadApp(xmlFile);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void loadApp(String xmlFile) throws Exception {
        if (xmlList.contains(xmlFile) == false) {
            xmlList.add(xmlFile);
        }
        appLoader.loadAppDetails(
            this.getClass().getClassLoader().getResource(appDir + xmlFile)
        );
        classLoader = new URLClassLoader(
            new URL[] {
                this.getClass().getClassLoader().getResource(appDir + appLoader.getLocation())
            },
            ConnectedApp.class.getClassLoader()
        );
        addApp(new App.Builder()
            .fileName(appLoader.getLocation())
            .name(appLoader.getName())
            .pageName(appLoader.getPageName())
            .URL(appLoader.getUrl())
            .description(appLoader.getDescription())
            .icon(appLoader.getIcon())
            .app((ConnectedApp) classLoader.loadClass(
                appLoader.getClassPackage()).newInstance()
            )
            .methodsAvailable(appLoader.getMethods())
            .build());
        appListLoader.saveAppList(xmlList);
    }

    public void addApp(App app) {
        if (appList.contains(app) == false) {
            appList.add(app);
        }
    }

    public void removeApp(App app) {
        appList.remove(app);
        xmlList.remove(app.getFileName().replace("jar", "xml"));
        appListLoader.saveAppList(xmlList);
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
