package com.pi.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pi.main.models.apps.App;
import com.pi.main.models.apps.AppManager;

@Controller
public class VoiceController {
	
	private AppManager appManager = new AppManager();
	
	@RequestMapping(value = "/voice", method = RequestMethod.GET)
	public String displayPage(ModelMap model) {
		model.addAttribute("pageName", "Voice");
		model.addAttribute("pageDetails", "Control your house with the power of your voice!");
		return "voice";
	}
	
	@RequestMapping(value = "/voice/processVoice", method = RequestMethod.GET)
	public String processVoice(@RequestParam(value="p", required=true) String voiceInput) {
		if (voiceInput.contains("house")) {
			try {
				processInput(voiceInput);
			} catch (Exception e) {
				return "redirect:/error";
			}
		}
		return "redirect:/voice";
	}
	
	private void processInput(String input) throws Exception {
		// Check if command belongs to a given app
		for (App app : appManager.getAppList()) {
			// App is found
			if (input.contains(app.getName().toLowerCase())) {
				for (String key : app.getMethodsAvailable().keySet()) {
					// Command is valid
					if (input.contains(key.toLowerCase())) {
						app.getApp().invokeMethod(app.getMethodsAvailable().get(key));
					}
				}
			}
		}
	}
}
