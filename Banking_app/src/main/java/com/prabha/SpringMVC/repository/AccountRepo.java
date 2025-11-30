package com.prabha.SpringMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prabha.SpringMVC.models.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, String>{

	Account findByAccountNo(String account_number);

	List<Account> findByUserId(long userId);
	
	int countByUserId(Long userId);

}
