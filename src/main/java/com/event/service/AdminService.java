package com.event.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.event.model.Admin;

public interface AdminService {
	List<Admin> getAllEvent();
	void saveNewEvent(Admin admin);
	Admin getEventById(long id);
	void deleteEventById(long id);
	
}
