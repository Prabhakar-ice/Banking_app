package com.prabha.SpringMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prabha.SpringMVC.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsByEmail(String email);

	User findByEmail(String username);

//	User findByRole(Roles admin);

}
