package com.pi.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pi.main.ressources.AppManager;

@Controller
public class HomepageController {
	
	private static AppManager appManager = new AppManager();
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String home() {
        return "redirect:home";
    }
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String displayPage(ModelMap model) {				
		model.addAttribute("message", "Welcome to an alpha version of Oli's shitty Home Automation :)");
		model.addAttribute("appManager", appManager);
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String viewApp(@ModelAttribute("appManager") AppManager appManager, ModelMap modelMap){
		return "redirect:/apps/" + appManager.getSelectedURL();
	}
}