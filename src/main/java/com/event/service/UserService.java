package com.event.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.event.dto.UserRegistrationDto;
import com.event.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
