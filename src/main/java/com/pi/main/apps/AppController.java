package com.pi.main.apps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import automation.api.interfaces.ConnectedClient;

import com.pi.main.ressources.AppManager;

@Controller
public class AppController {
	
	private AppManager appManager = new AppManager();
	private ConnectedClient client;
	
	@RequestMapping(value = "/apps/{appURL}", method = RequestMethod.GET)
	public String displayPage(ModelMap model, @PathVariable String appURL) {
		client = appManager.getApp(appURL).getClient();
		
		//TODO fix this
		model.addAttribute("pageName", "Let there be lights!");
		model.addAttribute("pageDetails", "The 'Lights' application allows you to remotely monitor the energy consumption of a power socket. You can also turn it on or off!");
	
		return "apps/" + appManager.getApp(appURL).getURL();
	}
	
	@RequestMapping(value = "/apps/{appURL}/{webMethod}", method = RequestMethod.GET)
	public String turnOn(ModelMap model, @PathVariable String appURL, @PathVariable String webMethod) {
		client = appManager.getApp(appURL).getClient();		
		try {
			client.invokeMethod(webMethod);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/apps/" + appManager.getApp(appURL).getURL();
	}

	@RequestMapping(value = "/apps/{appURL}/getState", method = RequestMethod.GET)
	public @ResponseBody String getState(@PathVariable String appURL) {
		client = appManager.getApp(appURL).getClient();
		String state = "null";
		try {
			state = (String) client.invokeMethod("getState");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return state;
	}
	
	@RequestMapping(value = "/apps/{appURL}/homeTile", method = RequestMethod.GET)
	public @ResponseBody String homeTile(@PathVariable String appURL) {
		client = appManager.getApp(appURL).getClient();
		String state = "null";
		try {
			state = (String) client.invokeMethod("homeTile");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return state;
	}
}
