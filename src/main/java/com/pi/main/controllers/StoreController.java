package com.pi.main.controllers;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.ant.compress.taskdefs.Unzip;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pi.main.models.UploadItem;
import com.pi.main.models.apps.App;
import com.pi.main.models.apps.AppManager;

@Controller
public class StoreController {
	
	private AppManager appManager = new AppManager();
	private final String appDir = "/home/pi/FYP/apps/";
	private final String viewDir = "/home/pi/FYP/apache-tomcat-7.0.35/webapps/ROOT/WEB-INF/pages/apps/";

	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public String displayPage(ModelMap model) {
		model.addAttribute("pageName", "App Store");
		model.addAttribute("pageDetails", "Use this page to add/remove applications from your system");
		model.addAttribute("uploadItem", new UploadItem());		
		return "store";
	}
	
	@RequestMapping(value = "/store/removeApp", method = RequestMethod.GET)
	public String removeApp(ModelMap model, @RequestParam(value="p", required=true) String appURL) {
		// Remove app from app manager
		App appToRemove = appManager.getApp(appURL);
		appManager.removeApp(appToRemove);
		
		// Remove files from hard disk
		File appFile = new File(appDir + appToRemove.getFileName());
		File appXML = new File(appDir + appToRemove.getFileName().replace("jar", "xml"));
		File appView = new File(viewDir + appToRemove.getURL() + ".jsp");
		appFile.delete();
		appXML.delete();
		appView.delete();
		
		//TODO add modal message
		return "redirect:/store";
	}
	
	@RequestMapping(value = "/store/addApp", method = RequestMethod.POST)
	public String uploadFile(@ModelAttribute("uploadItem") UploadItem uploadItem, BindingResult result) {
		if (result.hasErrors()) {
	    	return "redirect:/error";
	    }
		File file = new File(appDir + uploadItem.getFileData().getOriginalFilename());
		try {
			uploadItem.getFileData().transferTo(file);
			addApp(file);
		}  catch (Exception e) {
			return "redirect:/error";
		}
		return "redirect:/dashboard";
	}
	
	private void addApp(File appContainer) {
		Unzip unzipper = new Unzip();
		unzipper.setSrc(appContainer);
		unzipper.setDest(new File(appDir));
		unzipper.execute();
		try {
			appManager.loadApp(appContainer.getName().replace("zip", "xml"));
			installAppViews();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		} finally {
			appContainer.delete();
		}
	}
	
	private void installAppViews() {
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".jsp");
			}	
		};
		File[] fileList = new File(appDir).listFiles(filter);
		if (fileList != null) {
			for (File appView : fileList) {
				appView.renameTo(new File(viewDir + appView.getName()));
			}
		}
	}
}
