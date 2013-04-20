package com.pi.main.apps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.pi.main.apps.ressources.XMLEditor;

import automation.api.AbstractClient;

public class MediaClient extends AbstractClient {

	private XMLEditor xml = new XMLEditor("/home/pi/FYP/apache-tomcat-7.0.35/webapps/assets/osmplayer/playlist.xml"); 
	
	@Override
	public void onStartup() {}
	
	@Override
	public String getState() {
		return "Media app: coming soon!";
	}

	@Override
	public String homeTile() {
		return "Media app: coming soon!";
	}
	
	public void addTrack(String title, String location, String type) {
		xml.addTrack(title, location, type);
	}
	
	public void removeTrack(String id) {
		xml.removeTrack(id);
	}
	
	@Override
	public void uploadFile(String fileName, CommonsMultipartFile fileData) throws IOException {
		File file = new File("/home/pi/FYP/apache-tomcat-7.0.35/webapps/media/" + fileData.getOriginalFilename());
		FileUtils.writeByteArrayToFile(file, fileData.getBytes());
		xml.addTrack(fileName, "http://www.stuart-holland.com:8080/media/" + fileData.getOriginalFilename(), "HTML5");
	}
	
	@Override
	public ArrayList<String> getModels() {
		return xml.getTrackList();
	}
}
