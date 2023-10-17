package com.event.model;

import javax.persistence.*;


@Entity
@Table(name ="event_details")
public class Admin {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "event_organiser")
	private String event_organiser;
	
	@Column(name = "event_name")
	private String event_name;
	
	@Column(name = "location")
	private String location;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEvent_organiser() {
		return event_organiser;
	}
	public void setEvent_organiser(String event_organiser) {
		this.event_organiser = event_organiser;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
