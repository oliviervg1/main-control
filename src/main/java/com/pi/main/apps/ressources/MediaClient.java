package com.pi.main.apps.ressources;

import com.pi.main.ressources.XMLEditor;

import automation.api.AbstractClient;

public class MediaClient extends AbstractClient {

	private XMLEditor xml = new XMLEditor("/home/pi/FYP/apache-tomcat-7.0.35/webapps/assets/osmplayer/playlist.xml"); 
	
	@Override
	public String getState() {
		return "Media app: coming soon!";
	}

	@Override
	public String homeTile() {
		return "Media app: coming soon!";
	}
	
	public void addTrack() {
		xml.addTrack("Muse Live", "http://www.youtube.com/watch?v=Jiro61UjbB4", "Youtube");
	}
	
	public void addTrack(String title, String location, String type) {
		xml.addTrack(title, location, type);
	}
	
	public void removeTrack() {
		xml.removeTrack("Muse Live");
	}
}
