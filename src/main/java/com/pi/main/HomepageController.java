package com.pi.main;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	public String displayAppDropdownBox(ModelMap model) {				
		model.addAttribute("appManager", appManager);
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String viewApp(@ModelAttribute("appManager") @Valid AppManager appManager, BindingResult result, ModelMap model){
		if (result.hasErrors()) {
			return "home";
		} else {
			return "redirect:/apps/" + appManager.getSelectedURL();
		}
	}
}