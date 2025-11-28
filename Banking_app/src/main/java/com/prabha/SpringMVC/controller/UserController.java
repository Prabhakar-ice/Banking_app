package com.prabha.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prabha.SpringMVC.models.User;
import com.prabha.SpringMVC.services.UserService;

@Controller
@RequestMapping("/")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegisterForm() {
		return "register";
	}
	
	@GetMapping("/greet")
	public String greet() {
		return "Welcome to user Controller";
	}
	
	@PostMapping("/userLogin")
	public String userLogin(@RequestParam String email,
							@RequestParam String password, 
							RedirectAttributes redirectAttributes) {
		
		System.out.println(email + password);
		
		boolean status = userService.validateLogin(email, password);
		
		if(!status) {
			redirectAttributes.addFlashAttribute("error", "Invalid Email or Password");
			return "redirect:/login";
		}
		
		return "dashboard";
	}
	
	
	@PostMapping("/userRegister")
	public String userRegister(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
		
		System.out.println(user);
		
		boolean status = userService.register(user);
		
		if(!status) {
			redirectAttributes.addFlashAttribute("error", "User already exists");
			return "redirect:/register";
		}
		
		return "login";
	}
	
	@GetMapping("/userLogout")
	public String userLogout() {
		return "index";
	}
}
