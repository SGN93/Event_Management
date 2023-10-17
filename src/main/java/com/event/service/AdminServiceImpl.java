package com.event.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.event.model.Admin;
import com.event.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<Admin> getAllEvent() {
		return adminRepository.findAll();
	}

	@Override
	public void saveNewEvent(Admin admin) {
		this.adminRepository.save(admin);
	}

	@Override
	public Admin getEventById(long id) {
		Optional<Admin> optional = adminRepository.findById(id);
		Admin admin = null;
		if (optional.isPresent()) {
			admin = optional.get();
		} else {
			throw new RuntimeException(" Event not found for id :: " + id);
		}
		return admin;
	}

	@Override
	public void deleteEventById(long id) {
		this.adminRepository.deleteById(id);
	}


}
