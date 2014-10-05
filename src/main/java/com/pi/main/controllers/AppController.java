package com.pi.main.controllers;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

import com.pi.main.models.UploadItem;
import com.pi.main.models.apps.App;
import com.pi.main.models.apps.AppManager;

@Controller
public class AppController {

    private AppManager appManager = new AppManager();

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/apps/{appURL}", method = RequestMethod.GET)
    public String displayPage(ModelMap model, @PathVariable String appURL) {
        App app = appManager.getApp(appURL);
        try {
            model.addAttribute("pageName", app.getPageName());
            model.addAttribute("pageDetails", app.getDescription());
            model.addAttribute("uploadItem", new UploadItem());
            HashMap<String, Object> models = (HashMap<String, Object>) app.getApp().invokeMethod("getModels");
            for (String modelName : models.keySet()) {
                model.addAttribute(modelName, models.get(modelName));
            }
        } catch (Exception e) {
            return "redirect:/error";
        }
        return "apps/" + appURL;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/apps/{appURL}/{subPage}", method = RequestMethod.GET)
    public String displaySubPage(ModelMap model, @PathVariable String appURL, @PathVariable String subPage) {
        App app = appManager.getApp(appURL);
        try {
            model.addAttribute("pageName", app.getPageName());
            model.addAttribute("pageDetails", app.getDescription());
            model.addAttribute("uploadItem", new UploadItem());
            HashMap<String, Object> models = (HashMap<String, Object>) app.getApp().invokeMethod("getModels");
            for (String modelName : models.keySet()) {
                model.addAttribute(modelName, models.get(modelName));
            }
        } catch (Exception e) {
             return "redirect:/error";
        }
        return "apps/" + subPage;
    }

    @RequestMapping(value = "/apps/{appURL}/{webMethod}", method = RequestMethod.POST)
    public String invokeWebMethod(HttpServletRequest request, ModelMap model, @PathVariable String appURL, @PathVariable String webMethod,
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
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "/apps/{appURL}/upload", method = RequestMethod.POST)
    public String uploadFile(@ModelAttribute("uploadItem") UploadItem uploadItem, @PathVariable String appURL, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/error";
        }
        ConnectedApp client = appManager.getApp(appURL).getApp();
        File file = new File("/static/uploads/" + uploadItem.getFileData().getOriginalFilename());
        try {
            uploadItem.getFileData().transferTo(file);
            Object parameters[] = {uploadItem.getName(), file};
            client.invokeMethod("uploadFile", parameters);
        }  catch (Exception e) {
            return "redirect:/error";
        }
        return "redirect:/apps/" + appURL;
    }

    @RequestMapping(value = "/apps/{appURL}/state", method = RequestMethod.GET)
    public @ResponseBody String getState(@PathVariable String appURL) {
        ConnectedApp client = appManager.getApp(appURL).getApp();
        try {
            return (String) client.invokeMethod("getState");
        } catch (Exception e) {
            return "Error Occured";
        }
    }

    @RequestMapping(value = "/apps/{appURL}/home", method = RequestMethod.GET)
    public @ResponseBody String homeTile(@PathVariable String appURL) {
        ConnectedApp client = appManager.getApp(appURL).getApp();
        try {
            return (String) client.invokeMethod("homeTile");
        } catch (Exception e) {
            return "Error Occured";
        }
    }
}
