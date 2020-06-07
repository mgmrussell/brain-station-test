package com.bs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Status {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private long id;
	@ManyToOne
	private User user;
	@NotEmpty(message = "Status can not be empty")
	@Length(min = 1, max= 250, message = "Must be between minimum 1 and maximum 250 characters")
	private String description;
	@OneToOne
	private Location location;
	private boolean privacy;
	
	public Status() {}

	
	public Status(long id, User user, String description, Location location, boolean privacy) {
		this.id = id;
		this.user = user;
		this.description = description;
		this.location = location;
		this.privacy = privacy;
	}

	public Status(User user, String description, Location location, boolean privacy) {
		this.user = user;
		this.description = description;
		this.location = location;
		this.privacy = privacy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}


	public boolean getPrivacy() {
		return privacy;
	}


	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}


	@Override
	public String toString() {
		return "Status [id=" + id + ", user=" + user + ", description=" + description + ", location=" + location
				+ ", privacy=" + privacy + "]";
	}

	
	
	
}
