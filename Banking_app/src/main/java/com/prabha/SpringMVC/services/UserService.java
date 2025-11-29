package com.prabha.SpringMVC.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prabha.SpringMVC.dto.Roles;
import com.prabha.SpringMVC.models.User;
import com.prabha.SpringMVC.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	private final PasswordEncoder passwordEncoder;
	
	
	public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		
	}

	public boolean register(User user) {
		
		
		if(userRepo.existsByEmail(user.getEmail())){
			System.out.println("User Exists");
			return false;
		}
		
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		
		user.setPassword(encryptedPassword);
		
		user.setRole(Roles.valueOf("USER"));
		
		userRepo.save(user);
		
		return true;
	}

	public boolean validateLogin(String email, String enteredPassword) {
		User user = userRepo.findByEmail(email);
		System.out.println(user + " " + "service");
		
		if(user == null) {
			return false;
		}
		
		if(!passwordEncoder.matches(enteredPassword, user.getPassword())) {
			return false;
		}
		return true;
	}

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	
}
