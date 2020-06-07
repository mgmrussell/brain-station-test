package com.bs.controllers;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bs.config.SocialMediaUserDetailsService;
import com.bs.data.UserRepository;
import com.bs.domain.User;

@Controller
public class UserController {

	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserRepository userData;

	
	@Autowired
	private SocialMediaUserDetailsService socialMediaUserDetailsService;
	
	@RequestMapping(value = "/newUser.html", method = RequestMethod.GET)
	public ModelAndView renderNewUserForm(Model model) {
		logger.info("Entered renderNewUserForm method");
		User newUser = new User();
		return new ModelAndView("newUser", "user", newUser);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		logger.info("Entered new user registar method");		
		if (result.hasErrors()) {
			logger.info("We are getting validation error: " + result.getAllErrors().toString());
			return "newUser";
		}
		userData.save(user);
		//Not for production use
		logger.info("New user has been created: " + user);
		
		
		// Logged the user in programmatically upon creation of a new profile
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails userDetails = socialMediaUserDetailsService.loadUserByUsername (user.getUsername());
		Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities ());
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		
		return "success";
		//return "redirect:/home.html";
	}
}
