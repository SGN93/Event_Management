package com.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.event.dto.UserRegistrationDto;
import com.event.model.Admin;
import com.event.service.AdminService;
import com.event.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;
	
	@Autowired
	private AdminService adminService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	

	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}

	@GetMapping("/showEventForm")
	public String showEventForm(Model model) {
		// create model attribute to bind form data
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "new_event";
	}
	
	@PostMapping("/saveNewEvent")
	public String saveNewEvent(@ModelAttribute("admin") Admin admin) {
		// save employee to database
		adminService.saveNewEvent(admin);
		return "redirect:/";
	}
	
	@GetMapping("/showEventFormForUpdate/{id}")
	public String showEventFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		Admin admin = adminService.getEventById(id);
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("admin", admin);
		return "update_event";
	}
	
	@GetMapping("/deleteEventById/{id}")
	public String deleteEventById(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.adminService.deleteEventById(id);
		return "redirect:/";
	}
	
	
}
