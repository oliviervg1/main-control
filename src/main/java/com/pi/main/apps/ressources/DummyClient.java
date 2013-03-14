package com.pi.main.apps.ressources;

import automation.api.AbstractClient;

public class DummyClient extends AbstractClient {

	private String test;
	
	public DummyClient() {
		super();
		test = "false";
	}
	
	public String homeTile() {
		if (test.equalsIgnoreCase("true")) {
	    	test = "false";
	    }

	    else if (test.equalsIgnoreCase("false")) {
	    	test = "true";
	    }

	    return "Dummy state is " + test;
	}
}
