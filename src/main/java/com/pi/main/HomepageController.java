package com.pi.main;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pi.main.ressources.AppManager;

@Controller
public class HomepageController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirectToHomepage(ModelMap model) {
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String displayHomepage(ModelMap model) {
		return "home";
	}
	
	@RequestMapping(value = "**/viewApp", method = RequestMethod.POST)
	public String viewApp(@ModelAttribute("appManager") @Valid AppManager appManager, BindingResult result, ModelMap model){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		if (result.hasErrors()) {
			return "home";
		} else {
			if (request.getRequestURI().contains("apps")) {
				return "apps/" + appManager.getSelectedURL();
			}
			else {
				return "redirect:apps/" + appManager.getSelectedURL();
			}
		}
	}
}
