package com.pi.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pi.main.ressources.DeviceManager;

@Controller
public class HomepageController {
	
	private static DeviceManager deviceManager = new DeviceManager();
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String home() {
        return "redirect:home";
    }
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {				
		model.addAttribute("message", "Welcome to an alpha version of Oli's shitty Home Automation :)");
		model.addAttribute("deviceManager", deviceManager);
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String viewDevice(@ModelAttribute("deviceManager") DeviceManager deviceManager, ModelMap modelMap){
		return deviceManager.getSelectedURL();
	}
}