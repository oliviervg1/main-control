package com.pi.main.apps;

import java.io.File;
import java.util.ArrayList;

import automation.api.AbstractClient;

public class DummyClient extends AbstractClient {

	private String test = "false";
	
	@Override
	public String homeTile() {
		if (test.equalsIgnoreCase("true")) {
	    	test = "false";
	    }

	    else if (test.equalsIgnoreCase("false")) {
	    	test = "true";
	    }

	    return "Dummy state is " + test;
	}

	@Override
	public String getState() {
		return "";
	}

	@Override
	public void onStartup() {}

	@Override
	public ArrayList<String> getModels() throws Exception {
		return new ArrayList<String>();
	}

	@Override
	public void uploadFile(String fileName, File fileData)
			throws Exception {}
}
