package com.prabha.SpringMVC;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prabha.SpringMVC.dto.Roles;
import com.prabha.SpringMVC.models.User;
import com.prabha.SpringMVC.repository.UserRepository;


@SpringBootApplication
public class BankingAppApplication implements CommandLineRunner{

	private final UserRepository userRepo;
	
	public BankingAppApplication(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		User admin =userRepo.findByEmail("admin@gmail.com");
		
		if(admin ==null) {
			User user =new User();
			
			user.setEmail("admin@gmail.com");
			user.setUsername("admin");
			user.setPassword(new BCryptPasswordEncoder(12).encode("admin"));
			user.setRole(Roles.ADMIN);
			
			userRepo.save(user);
		}
	}

}
