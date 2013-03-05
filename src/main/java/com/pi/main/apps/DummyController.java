package com.pi.main.apps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DummyController {
	String test = "true";
	
	@RequestMapping(value = "/apps/dummy", method = RequestMethod.GET)
	public String displayPage(ModelMap model) {
		model.addAttribute("pageName", "Nothing to see here!");
		model.addAttribute("pageDetails", "Please move along :)");
		return "apps/dummy";
	}
	
	@RequestMapping(value = "/apps/dummy/homeTile", method = RequestMethod.GET)
	public @ResponseBody String homeTile() {
	    if (test.equalsIgnoreCase("true")) {
	    	test = "false";
	    }
	    
	    else if (test.equalsIgnoreCase("false")) {
	    	test = "true";
	    }
	    
	    return "Dummy state is " + test;
	}
}
