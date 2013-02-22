package com.pi.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirectToHomepage(ModelMap model) {
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String displayHomepage(ModelMap model) {
		model.addAttribute("pageName", "Welcome!");
		model.addAttribute("pageDetails", "Control and monitor your house appliances from a simple and intuitive web interface.");
		return "home";
	}
}
