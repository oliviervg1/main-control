package com.pi.main.apps.ressources;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
 
public class XMLEditor {
	
	private String file;
	private String baseDir;
	private SAXBuilder builder;
	private XMLOutputter xmlOutput;
	private Document doc;

	public XMLEditor(String file, String uploadDir) {
		this.file = file;
		this.baseDir = uploadDir;
		builder = new SAXBuilder();
		xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		doc = null;
	}
	
	private void loadXML() {
		File xmlFile = new File(file); 
		try {
			doc = (Document) builder.build(xmlFile);
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void outputXML() {
		try {
			xmlOutput.output(doc, new FileWriter(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getTrackList() {
		loadXML();
		Element rootNode = doc.getRootElement();
		Namespace ns = rootNode.getNamespace();
		Element trackList = rootNode.getChild("trackList", ns);
		
		ArrayList<String> trackNames = new ArrayList<String>();
		for (Element track : trackList.getChildren()) {
			trackNames.add(track.getAttributeValue("id"));
		}
		
		return trackNames;
	}
	
	public String getTrackLocation(String trackId) {
		loadXML();
		Element rootNode = doc.getRootElement();
		Namespace ns = rootNode.getNamespace();
		Element trackList = rootNode.getChild("trackList", ns);
		
		for (Element track : trackList.getChildren()) {
			if (trackId == track.getAttributeValue("id")) {
				return track.getChild("location", ns).getValue();
			}
		}
		
		return null;
	}
	
	public void addTrack(String title, String location, String type) {
		loadXML();
		Element rootNode = doc.getRootElement();
		Namespace ns = rootNode.getNamespace();
		Element trackList = rootNode.getChild("trackList", ns);
		
		Element elementToAdd = new Element("track", ns);
		elementToAdd.setAttribute("id", title);
		elementToAdd.addContent(new Element("title", ns).setText(type + ": " + title));
		elementToAdd.addContent(new Element("location", ns).setText(location));
			
		trackList.addContent(elementToAdd);
		outputXML();
	}
	
	public void removeTrack(String id) {
		loadXML();
		Element rootNode = doc.getRootElement();
		Namespace ns = rootNode.getNamespace();
		Element trackList = rootNode.getChild("trackList", ns);
		
		// Get list of tracks
		List<Element> tracks = trackList.getChildren();
		
		// Removing elements
		Element elementToRemove = null;
			
		for (Element element : tracks) {
			if(element.getAttribute("id").getValue().equalsIgnoreCase(id)) {
				elementToRemove = element;
			}
		}
		
		// Check if the element is hosted locally
		try {
			URL filePath = new URL(elementToRemove.getChild("location", ns).getValue());
			// TODO Make this better!
			File fileToRemove = new File(baseDir + filePath.getPath());
			if (fileToRemove.isFile()) {
				fileToRemove.delete();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		trackList.removeContent(elementToRemove);
		outputXML();
	}
}
