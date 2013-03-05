package com.pi.main.apps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pi.main.apps.ressources.LightingClient;
import com.pi.main.ressources.AppManager;


@Controller
public class LightsController {
	
	private AppManager appManager = new AppManager();
	private LightingClient client = (LightingClient) appManager.getApp("Lights").getClient();
	
	@RequestMapping(value = "/apps/lights", method = RequestMethod.GET)
	public String displayPage(ModelMap model) {
		model.addAttribute("pageName", "Let there be lights!");
		model.addAttribute("pageDetails", "The 'Lights' application allows you to remotely monitor the energy consumption of a power socket. You can also turn it on or off!");
		model.addAttribute("state", client.getState());
		return "apps/lights";
	}
	
	@RequestMapping(value = "/apps/lights/turnOn", method = RequestMethod.GET)
	public String turnOn(ModelMap model) {
		client.powerOn();
		return "redirect:/apps/lights";
	}
	
	@RequestMapping(value = "/apps/lights/turnOff", method = RequestMethod.GET)
	public String turnOff(ModelMap model) {
		client.powerOff();
		return "redirect:/apps/lights";
	}
	
	@RequestMapping(value = "/apps/lights/getState", method = RequestMethod.GET)
	public @ResponseBody String getState() {
	    String state = "Power is currently " + client.getState();
	    return state;
	}
	
	@RequestMapping(value = "/apps/lights/homeTile", method = RequestMethod.GET)
	public @ResponseBody String homeTile() {
	    String state = "Power is currently " + client.getState();
	    return state;
	}
}
