package com.bs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bs.data.LocationRepository;
import com.bs.data.StatusRepository;
import com.bs.data.UserRepository;
import com.bs.domain.Location;
import com.bs.domain.Status;
import com.bs.domain.User;

@Controller
public class StatusController {

	Logger logger = Logger.getLogger(StatusController.class);

	@Autowired
	private LocationRepository locationData;

	@Autowired
	private UserRepository userData;

	@Autowired
	private StatusRepository statusData;
	
	
	private Long statusId;
	

	@RequestMapping(value = "/newStatus.html", method = RequestMethod.GET)
	public ModelAndView renderNewUserForm(ModelMap model) {
		Status status = new Status();
		this.statusId = new Long(0);
		//Set user to class variable
		return new ModelAndView("newStatus", "status", status);
	}

	@RequestMapping(value = "/editStatus", method = RequestMethod.GET)
	public ModelAndView renderNewUserForm(ModelMap model, @RequestParam("id") String id) {
		logger.info("Entered edit method for status id " + id);
		this.statusId = Long.parseLong(id);
		Status status = statusData.getOne(this.statusId);
		return new ModelAndView("newStatus", "status", status);
	}
	
	@RequestMapping(value = "/addStatus", method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("status") Status status, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("We are getting validation error: " + result.getAllErrors().toString());
			return "newStatus";
		}

		// Setting the location database ID to the selected location
		for (Location lcoation : locationData.findAll()) {
			if (lcoation.getLocation().equals(status.getLocation().getLocation())) {
				status.getLocation().setId(lcoation.getId());
				break;
			}
		}
		
		
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User user = userData.findByUsername(username);
		status.setUser(user);
		logger.info(status);
		status.setId(this.statusId);
		this.statusData.save(status);
		
		return "redirect:/home.html";
	}

	@ModelAttribute("locations")
	public List<Location> getLocations() {
		return locationData.findAll();
	}
}
