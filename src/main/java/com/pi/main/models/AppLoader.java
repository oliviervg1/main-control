package com.pi.main.models;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AppLoader {
	private SAXBuilder builder;
	private Document doc;
	
	private String location;
	private String name;
	private String pageName;
	private String url;
	private String description;
	private String icon;
	private String classPackage;
	private HashMap<String, String> methods;

	public AppLoader() {
		builder = new SAXBuilder();
		doc = null;
		methods = new HashMap<String, String>();
	}
	
	public void loadAppDetails(URL file) {		
		try {
			doc = (Document) builder.build(file);
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Get root node
		Element rootNode = doc.getRootElement();
		
		// Populate values
		location = rootNode.getChildText("location");
		name = rootNode.getChildText("name");
		pageName = rootNode.getChildText("pagename");
		url = rootNode.getChildText("url");
		description = rootNode.getChildText("description");
		icon = rootNode.getChildText("icon"); 
		classPackage = rootNode.getChildText("package");
		
		// Populate methods
		if (rootNode.getChild("methods") != null) {
			for (Element method : rootNode.getChild("methods").getChildren()) {
				methods.put(method.getChildText("name"), method.getChildText("action"));
			}
		}
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public String getPageName() {
		return pageName;
	}

	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	public String getClassPackage() {
		return classPackage;
	}

	public HashMap<String, String> getMethods() {
		return methods;
	}
}
