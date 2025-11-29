package com.prabha.SpringMVC.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.prabha.SpringMVC.dto.AccountType;
import com.prabha.SpringMVC.models.Account;
import com.prabha.SpringMVC.repository.AccountRepo;

@Service
public class AccountService {

	private AccountRepo accountRepo;
	
	private final Map<AccountType, String> accountTypeCode =
            Map.of(AccountType.SAVINGS, "0201",
                   AccountType.CURRENT, "0204");
	
	private final Map<String, String> branchCode = 
			Map.of("T Nagar", "9961",
					"Ashok Nagar", "9963",
					"Uthangarai", "9965");
	
	private static long seven_digit_code = 1000000l;
	
	public AccountService(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
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

	public boolean createNewBankAccount(AccountType acc_type, BigDecimal initial_deposit, String branch_name) {
		
//		accountRepo.findByAccountType()
		
		Account current_account = new Account(acc_type);
		String account_no = generateAccountNumber(acc_type, branch_name);
		
		current_account.setAccount_no(account_no);
		current_account.setBalance(initial_deposit);
		current_account.setCreated_on();
		
		
		
		return false;
	}
	
	private String generateAccountNumber(AccountType acc_type, String branch_name) {
		
		String branch_code= branchCode.get(branch_name);
		String acc_type_code = accountTypeCode.get(acc_type);
		
		String account_number = branch_code + acc_type + ++seven_digit_code;
		
		System.out.println(account_number + "  acc Service");
		
		return account_number;
	}
	
	
	
	
}
