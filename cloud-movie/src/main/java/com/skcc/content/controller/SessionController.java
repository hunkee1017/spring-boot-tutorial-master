package com.skcc.content.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
	private static Logger logger = LoggerFactory.getLogger(SessionController.class);

	@RequestMapping(value = "/session")
	public String login(HttpServletRequest request, HttpSession session) {

		if (session.getAttribute("username") == null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			if (username == null || password == null) {
				 return "Need username and password. Usage /session?username={username}&password={password}";
			} else {
				session.setAttribute("username", username);
				session.setAttribute("password", password);
			}
		}
		
		logger.info("username:" + session.getAttribute("username") + ", password="
				+ session.getAttribute("password"));
		return "username:" + session.getAttribute("username") + ", password="
				+ session.getAttribute("password");
	}
}
