package com.bs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private long id;
	private String location;
	
	
	
	public Location(int id, String location) {
		this.id = id;
		this.location = location;
	}
	
	public Location(String location) {
		this.location = location;
	}
	
	public Location() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", location=" + location + "]";
	}
	
	
}

