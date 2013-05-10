package com.pi.main;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pi.main.ressources.AppManager;

public class MenuHandler extends HandlerInterceptorAdapter {
	
	private AppManager appManager = new AppManager();
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Principal principal = request.getUserPrincipal();
		if (principal != null) {
			request.setAttribute("loggedUser", principal.getName());
		}
		request.setAttribute("appManager", appManager);
		return super.preHandle(request, response, handler);
	}
}