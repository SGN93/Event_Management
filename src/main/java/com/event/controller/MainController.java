package com.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.event.model.Admin;
import com.event.service.AdminService;

@Controller
public class MainController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String viewHomePage(Model model) {		
		model.addAttribute("listOfEvents",  adminService.getAllEvent());	
		return "index";		
	}
	

	
}
