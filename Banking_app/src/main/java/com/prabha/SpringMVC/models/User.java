package com.prabha.SpringMVC.models;

import java.util.ArrayList;
import java.util.List;

import com.prabha.SpringMVC.dto.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "User", 
		uniqueConstraints = {
				@UniqueConstraint(name = "user_unique_email", columnNames = "email")
		})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long user_id;
	
	@NotBlank(message = "username cannot be empty")
	@Column(length = 100, nullable = false)
	private String username;
	
	@NotBlank(message = "password cannot be empty")
	@Column(nullable = false, length = 150)
	private String password;
	
	@Email(message= "enter valid email")
	@Column(name = "email",length = 150, nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "Role")
	private Roles role;
	
	@OneToMany(mappedBy = "user") // meaning one user can have many Accounts
	private List<Account> accounts = new ArrayList<>();
	
	public User() {
		super();
	}
	
	public User(String username, String password, String email, Roles role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public long getId() {
		return this.user_id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	
	public void setPassword(String encryptedPassword) {
		// TODO Auto-generated method stub
		this.password = encryptedPassword;
	}
	
	public Roles getRole() {
		return this.role;
	}
	
	public void setRole(Roles role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + "]";
	}

	

	
	
	
}
