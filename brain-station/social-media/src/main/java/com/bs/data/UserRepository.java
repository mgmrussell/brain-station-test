package com.bs.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs.domain.User;


public interface UserRepository  extends JpaRepository<User, Long> {
	
	
	public User findByUsername(String username);
	

	

}
