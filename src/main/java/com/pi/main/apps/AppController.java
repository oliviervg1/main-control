package com.pi.main.apps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import automation.api.interfaces.ConnectedClient;

import com.pi.main.ressources.AppManager;
import com.pi.main.ressources.ConnectedApp;

@Controller
public class AppController {
	
	private AppManager appManager = new AppManager();
	
	@RequestMapping(value = "/apps/{appURL}", method = RequestMethod.GET)
	public String displayPage(ModelMap model, @PathVariable String appURL) {
		ConnectedApp app = appManager.getApp(appURL);
		model.addAttribute("pageName", app.getPageName());
		model.addAttribute("pageDetails", app.getDescription());
	
		return "apps/" + app.getURL();
	}
	
	@RequestMapping(value = "/apps/{appURL}/{webMethod}", method = RequestMethod.GET)
	public String invokeWebMethod(ModelMap model, @PathVariable String appURL, @PathVariable String webMethod,
					@RequestParam(value="p", required=false) Object[] parameters) {
		
		ConnectedClient client = appManager.getApp(appURL).getClient();
				
		try {
			if (parameters == null) {
				client.invokeMethod(webMethod);
			}
			else {
				client.invokeMethod(webMethod,parameters);
			}
		} catch (NoSuchMethodException e) {
			return "redirect:/error";
		}
		return "redirect:/apps/" + appManager.getApp(appURL).getURL();
	}

	@RequestMapping(value = "/apps/{appURL}/getState", method = RequestMethod.GET)
	public @ResponseBody String getState(@PathVariable String appURL) {
		ConnectedClient client = appManager.getApp(appURL).getClient();
		String state = "null";
		try {
			state = (String) client.invokeMethod("getState");
		} catch (NoSuchMethodException e) {
			return "redirect:/error";
		}
	    return state;
	}
	
	@RequestMapping(value = "/apps/{appURL}/homeTile", method = RequestMethod.GET)
	public @ResponseBody String homeTile(@PathVariable String appURL) {
		ConnectedClient client = appManager.getApp(appURL).getClient();
		String state = "null";
		try {
			state = (String) client.invokeMethod("homeTile");
		} catch (NoSuchMethodException e) {
			return "redirect:/error";
		}
	    return state;
	}
}
