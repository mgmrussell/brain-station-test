package com.bs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.bs.validation.Username;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	
	@Length(min = 1, max= 20, message = "Must be between minimum 1 and maximum 20 characters")
	private String firstName;
	
	@Length(min = 1, max= 20, message = "Must be between minimum 1 and maximum 20 characters")
	private String lastName;
	
	@NotEmpty(message = "Username can not be empty")
	@Column(unique = true)
	@Username
	private String username;
	
	@Length(min = 4, max= 12, message = "Must be between minimum 4 and maximum 12 characters")
	private String password;
	
	public User() {
		
	}
	
	public User(long id, String title, String firstName, String lastName, String username, String password) {
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public User(String title, String firstName, String lastName, String username, String password) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + "]";
	}

	
}
