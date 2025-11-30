package com.prabha.SpringMVC.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.prabha.SpringMVC.dto.AccountType;
import com.prabha.SpringMVC.models.Account;
import com.prabha.SpringMVC.models.User;
import com.prabha.SpringMVC.repository.AccountRepo;
import com.prabha.SpringMVC.repository.UserRepository;

@Service
public class AccountService {

	private AccountRepo accountRepo;
	private UserRepository userRepo;
	
	private final Map<AccountType, String> accountTypeCode =
            Map.of(AccountType.SAVINGS, "0201",
                   AccountType.CURRENT, "0204");
	
	private final Map<String, String> branchCode = 
			Map.of("T Nagar", "9961",
					"Ashok Nagar", "9963",
					"Uthangarai", "9965");
	
	
	public AccountService(AccountRepo accountRepo, UserRepository userRepo) {
		this.accountRepo = accountRepo;
		this.userRepo = userRepo;
	}

	public boolean withdrawMoney(BigDecimal amount_to_withdraw, String account_selected) {

		// The Account may or may not be, so we use optional
		Account current_account = accountRepo.findByAccountNo(account_selected);
		
		System.out.println(current_account + "  Account Service ");
		
		BigDecimal current_balance = current_account.getBalance();
		
		System.out.println(current_balance+ "  Account Service ");
		
		if(current_balance.compareTo(amount_to_withdraw) != 1) {
			return false;
		}
		
		// For BigDecimal we cannot use operator, instead we use methods
		BigDecimal new_balance = current_balance.subtract(amount_to_withdraw);
		System.out.println(new_balance+ "   Service ");
		current_account.setBalance(new_balance);
		
		accountRepo.save(current_account);
		
		return true;
	}

	public List<Account> findByUserId(long userId) {
		// TODO Auto-generated method stub
		return accountRepo.findByUserId(userId);
	}

	public boolean createNewBankAccount(String acc_type, BigDecimal initial_deposit, String branch_name, Long userId) {
		
		User user = userRepo.findById(userId).orElse(null);
		
		Account new_account = new Account(AccountType.valueOf(acc_type));
		String account_no = generateAccountNumber(acc_type, branch_name);
		
		new_account.setUser(user);
		new_account.setAccount_no(account_no);
		new_account.setBalance(initial_deposit);
		new_account.setCreated_on();
		
		accountRepo.save(new_account);
		
		return true; 
	}
	
	private String generateAccountNumber(String acc_type, String branch_name) {
		
		String branch_code= branchCode.get(branch_name);
		String acc_type_code = accountTypeCode.get(AccountType.valueOf(acc_type));
		
		String timeStamp_number =String.valueOf(System.currentTimeMillis()).substring(6) ;
		
		System.out.println(timeStamp_number + "  acc service");
		
		System.out.println(branch_code + acc_type_code + timeStamp_number + "  acc Service");
		
		return branch_code + acc_type_code + timeStamp_number;
	}
	
	public int countAccountsByUser(Long userId) {
	    return accountRepo.countByUserId(userId);
	}

	
	
}
