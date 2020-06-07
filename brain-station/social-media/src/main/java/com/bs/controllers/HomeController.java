package com.bs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bs.data.StatusRepository;
import com.bs.data.UserRepository;
import com.bs.domain.Status;

@Controller
public class HomeController {

	
	@Autowired
	private StatusRepository statusData;
	
	@Autowired
	private UserRepository userData;
	
	@RequestMapping("/home.html")
	public ModelAndView firstPage()
	{

		List<Status> statuses = statusData.findAll();
		
		return new ModelAndView("welcome", "statuses", statuses);
	}
	
	@ModelAttribute("username")
	public String getUsername() {
		if (getAuthenticated()) {
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
			return username;
		}
		return "";
	}
	
	@ModelAttribute("firstName")
	public String getFirstName() {
		if (getAuthenticated() && !getUsername().isEmpty()) {
			return userData.findByUsername(getUsername()).getFirstName();
		}
		return "";
	}
	
	@ModelAttribute("authenticated")
	public boolean getAuthenticated() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return !(auth instanceof AnonymousAuthenticationToken);
	}
}
