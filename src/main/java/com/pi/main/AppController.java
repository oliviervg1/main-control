package com.pi.main;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import automation.api.interfaces.ConnectedApp;

import com.pi.main.ressources.AppManager;
import com.pi.main.ressources.App;
import com.pi.main.ressources.UploadItem;

@Controller
public class AppController {
	
	private AppManager appManager = new AppManager();
	
	@RequestMapping(value = "/apps/{appURL}", method = RequestMethod.GET)
	public String displayPage(ModelMap model, @PathVariable String appURL) {
		App app = appManager.getApp(appURL);
		try {
			model.addAttribute("pageName", app.getPageName());
			model.addAttribute("pageDetails", app.getDescription());
			model.addAttribute("uploadItem", new UploadItem());
			model.addAttribute("appModels", app.getApp().invokeMethod("getModels"));
		} catch (Exception e) {
			return "redirect:/error";
		}
		return "apps/" + appURL;
	}
	
	@RequestMapping(value = "/apps/{appURL}/{subPage}", method = RequestMethod.GET)
	public String displaySubPage(ModelMap model, @PathVariable String appURL, @PathVariable String subPage) {
		App app = appManager.getApp(appURL);
		try {
			model.addAttribute("pageName", app.getPageName());
			model.addAttribute("pageDetails", app.getDescription());
			model.addAttribute("uploadItem", new UploadItem());
			model.addAttribute("appModels", app.getApp().invokeMethod("getModels"));
		} catch (Exception e) {
 			return "redirect:/error";
		}
		return "apps/" + subPage;
	}
	
	@RequestMapping(value = "/apps/{appURL}/webMethod/{webMethod}", method = RequestMethod.GET)
	public String invokeWebMethod(ModelMap model, @PathVariable String appURL, @PathVariable String webMethod,
					@RequestParam(value="p", required=false) Object[] parameters) {
		
		ConnectedApp client = appManager.getApp(appURL).getApp();		
		try {
			if (parameters == null) {
				client.invokeMethod(webMethod);
			} else {
				client.invokeMethod(webMethod,parameters);
			}
		} catch (Exception e) {
			return "redirect:/error";
		}
		return "redirect:/apps/" + appURL;
	}
	
	@RequestMapping(value = "/apps/{appURL}/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@ModelAttribute("uploadItem") UploadItem uploadItem, @PathVariable String appURL, BindingResult result) {
		if (result.hasErrors()) {
	    	return "redirect:/error";
	    }
		ConnectedApp client = appManager.getApp(appURL).getApp();
		File file = new File("/home/pi/FYP/apache-tomcat-7.0.35/webapps/uploads/" + uploadItem.getFileData().getOriginalFilename());
		try {
			uploadItem.getFileData().transferTo(file);
			Object parameters[] = {uploadItem.getName(), file};
			client.invokeMethod("uploadFile", parameters);
		}  catch (Exception e) {
			return "redirect:/error";
		}
	    return "redirect:/apps/" + appURL;
	}

	@RequestMapping(value = "/apps/{appURL}/getState", method = RequestMethod.GET)
	public @ResponseBody String getState(@PathVariable String appURL) {
		ConnectedApp client = appManager.getApp(appURL).getApp();
		try {
			return (String) client.invokeMethod("getState");
		} catch (Exception e) {
			return "Error Occured";
		}
	}
	
	@RequestMapping(value = "/apps/{appURL}/homeTile", method = RequestMethod.GET)
	public @ResponseBody String homeTile(@PathVariable String appURL) {
		ConnectedApp client = appManager.getApp(appURL).getApp();
		try {
			return (String) client.invokeMethod("homeTile");
		} catch (Exception e) {
			return "Error Occured";
		}
	}
}
