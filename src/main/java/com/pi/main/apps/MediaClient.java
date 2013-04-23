package com.pi.main.apps;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.namespace.QName;

import com.pi.main.apps.ressources.XMLEditor;

import automation.api.AbstractClient;

public class MediaClient extends AbstractClient {

	private XMLEditor xml = new XMLEditor("/home/pi/FYP/apache-tomcat-7.0.35/webapps/assets/osmplayer/playlist.xml"); 
	
	@Override
	public void onStartup() {
		connectToRemoteDevice("http://192.168.0.4:8080/media-control-1.0.0/MediaPlayer?wsdl", new QName("http://media.pi.com/", "MediaPlayerService"));
	}
	
	@Override
	public String getState() throws Exception {
		if (isDeviceAvailable()) {
			return (String) device.invokeMethod("getPlayingFile");
		} else {
			return "Media device unavailable!";
		}
	}

	@Override
	public String homeTile() throws Exception {
		if (isDeviceAvailable()) {
			return (String) device.invokeMethod("getPlayingFile");
		} else {
			return "Media device unavailable!";
		}
	}
	
	@Override
	public void uploadFile(String fileName, File file) {
		xml.addTrack(fileName, "http://www.stuart-holland.com:8080/uploads/" + file.getName(), "HTML5");
	}
	
	@Override
	public ArrayList<String> getModels() {
		return xml.getTrackList();
	}
	
	public void addTrack(String title, String location, String type) {
		xml.addTrack(title, location, type);
	}
	
	public void removeTrack(String id) {
		URL locationToRemove = xml.removeTrack(id);
		File fileToRemove = new File("/home/pi/FYP/apache-tomcat-7.0.35/webapps" + locationToRemove.getPath());
		if (fileToRemove.isFile()) {
			fileToRemove.delete();
		}
	}
	
	public void playTrack(String id) throws Exception {
		String fileToPlay = xml.getTrackLocation(id);
		fileToPlay = fileToPlay.replace(" ", "%20");
		Object parameters[] = {fileToPlay};
		if (isDeviceAvailable()) {
			device.invokeMethod("playTrack", parameters);
		}
	}
	
	public void togglePlay() throws Exception {
		if (isDeviceAvailable()) {
			device.invokeMethod("togglePlay");
		}
	}
	
	public void setVolume(float volume) throws Exception {
		Object parameters[] = {volume};
		if (isDeviceAvailable()) {
			device.invokeMethod("setVolume", parameters);
		}
	}
	
	public float getVolume() throws Exception {
		if (isDeviceAvailable()) {
			return (float) device.invokeMethod("getVolume");
		} else {
			return 0;
		}
	}
	
	public void setTimePosition(long seconds) throws Exception {
		Object parameters[] = {seconds};
		if (isDeviceAvailable()) {
			device.invokeMethod("setTimePosition", parameters);
		}
	}
	
	public long getTimePosition() throws Exception {
		if (isDeviceAvailable()) {
			return (long) device.invokeMethod("getTimePosition");
		}
		return 0;
	}
	
	public long getTotalTime() throws Exception {
		if (isDeviceAvailable()) {
			return (long) device.invokeMethod("getTotalTime");
		}
		return 0;
	}
	
	public void close() throws Exception {
		if (isDeviceAvailable()) {
			device.invokeMethod("close");
		}
	}
}
