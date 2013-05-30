package com.pi.main.models.apps;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AppListLoader implements Serializable {
	
	private static final long serialVersionUID = -8359698970028429156L;
	private ArrayList<String> appList;
	private final transient String appDir = "/home/pi/FYP/apps/";
	
	public void saveAppList(ArrayList<String> appList) {
		try {
			this.appList = appList;
			FileOutputStream fileOut = new FileOutputStream(appDir + "appList.ser");
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(this);
	        out.close();
	        fileOut.close();
	    } catch(IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public ArrayList<String> loadAppList() {
		AppListLoader appListLoader = null;
		try {
			FileInputStream fileIn = new FileInputStream(appDir + "appList.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			appListLoader = (AppListLoader) in.readObject();
			in.close();
			fileIn.close();
			return appListLoader.appList;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return new ArrayList<String>();
		} 
	}
}
