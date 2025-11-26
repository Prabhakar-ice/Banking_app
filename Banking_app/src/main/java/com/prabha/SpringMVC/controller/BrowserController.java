package com.prabha.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BrowserController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("greet")
	public void greet() {
		System.out.println( "Welcome to user Controller");
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegisterForm() {
		return "register";
	}
}
