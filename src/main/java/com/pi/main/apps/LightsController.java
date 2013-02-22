package com.pi.main.apps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LightsController {
	
	@RequestMapping(value = "/apps/lights", method = RequestMethod.GET)
	public String displayPage(ModelMap model) {
		model.addAttribute("pageName", "Let there be lights!");
		model.addAttribute("pageDetails", "The 'Lights' application allows you to remotely monitor the energy consumption of a power socket. You can also turn it on or off!");
		return "apps/lights";
	}
}
