package com.prabha.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prabha.SpringMVC.models.User;
import com.prabha.SpringMVC.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/greet")
	public String greet() {
		return "Welcome to user Controller";
	}
	
	@PostMapping("/login")
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
	
	
	@PostMapping("/register")
	public String userRegister(@ModelAttribute("user") User user, Model model) {
		
		System.out.println(user);
		
		String status = userService.register(user);
		
		if(!status.equals("success")) {
			return "redirect:/register";
		}
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String userLogout() {
		return "index";
	}
}
