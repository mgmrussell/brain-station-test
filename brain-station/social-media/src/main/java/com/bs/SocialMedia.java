package com.bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bs.data.LocationRepository;
import com.bs.data.StatusRepository;
import com.bs.data.UserRepository;
import com.bs.domain.Location;
import com.bs.domain.Status;
import com.bs.domain.User;

@SpringBootApplication
public class SocialMedia {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SocialMedia.class, args);
		
		LocationRepository locationData = ctx.getBean(LocationRepository.class);
		UserRepository userData = ctx.getBean(UserRepository.class);
		StatusRepository statusData = ctx.getBean(StatusRepository.class);

		
		//Save the locations during the start of the application alternatively these can be directly in the database;
		
		locationData.save(new Location("Sylhet"));
		locationData.save(new Location("Bandarban"));
		locationData.save(new Location("Khulna"));
		

		//Save some users to the database;
		// These are not to be used in the production code, I am using here for demonstration only
		User u1 = new User("Mr.", "Mohammad", "Mostafa", "username", "password");
		User u2 = new User("Ms.", "Emma", "Starr", "emmas", "zucchini");
		userData.save(u1);
		userData.save(u2);

		
		//Save some status to the database;
		// These are not to be used in the production code, I am using here for demonstration only
		Status s1 = new Status(userData.findOne(new Long(1)),"Having a good day", locationData.findOne(new Long(1)), false);
		Status s2 = new Status(userData.findOne(new Long(1)),"Swimming at Specific", locationData.findOne(new Long(2)), false);
		Status s3 = new Status(userData.findOne(new Long(1)),"Having dinner with family", locationData.findOne(new Long(3)), true);
		Status s4 = new Status(userData.findOne(new Long(2)),"Enjoying nature", locationData.findOne(new Long(1)), false);
		Status s5 = new Status(userData.findOne(new Long(2)),"Writing a new book ", locationData.findOne(new Long(2)), false);
		Status s6 = new Status(userData.findOne(new Long(2)),"Fleeing from mosquitoes", locationData.findOne(new Long(3)), true);
		
		statusData.save(s1);
		statusData.save(s2);
		statusData.save(s3);
		statusData.save(s4);
		statusData.save(s5);
		statusData.save(s6);
		
	}
	
}
