package com.pi.main.apps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LightsController {

	@RequestMapping(value="/apps/lights", method = RequestMethod.GET)
	public String displayPage(ModelMap model) {
		return "apps/lights";
	}
}
