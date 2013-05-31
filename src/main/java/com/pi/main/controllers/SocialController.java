package com.pi.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pi.main.models.twitter.TwitterHandler;
import com.pi.main.models.twitter.TwitterParameters;

@Controller
public class SocialController {
	
	private TwitterHandler twitter;
	
	public SocialController() {
		String[] keywords = {"@AutomatIn"};
		TwitterParameters.addUser("olivier_vg");
		twitter = new TwitterHandler();
		twitter.start(keywords);
	}
	
	@RequestMapping(value = "/social", method = RequestMethod.GET)
	public String displayPage(ModelMap model) {
		model.addAttribute("pageName", "Social");
		model.addAttribute("pageDetails", "View your house's recent Twitter activity here");
		return "social";
	}
}
