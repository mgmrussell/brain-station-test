package com.bs.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bs.data.UserRepository;
@Service
public class SocialMediaUserDetailsService implements UserDetailsService {
    
	Logger logger = Logger.getLogger(SocialMediaUserDetailsService.class);
	
    @Autowired
    private UserRepository userRepository;
    

    public SocialMediaUserDetailsService() {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	List<com.bs.domain.User> users = userRepository.findAll();
    	
        Optional<com.bs.domain.User> user = users.stream()
                                         .filter(u -> u.getUsername().equals(username))
                                         .findAny();
        logger.info("Users has been retived from database are : " + users);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        }
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		// For production code we need to do password conding-possibly BECRYPT
		return new User(user.get().getUsername(), user.get().getPassword(), authorities);
    }
}