package com.prabha.SpringMVC.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prabha.SpringMVC.dto.AccountType;
import com.prabha.SpringMVC.models.Account;
import com.prabha.SpringMVC.services.AccountService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class AccountController {

	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/createAccount")
	public String createNewAccount() {
		return "createAccount";
	}
	
	@GetMapping("/withdraw")
	public String withdraw(HttpSession session, Model model) {
		System.out.println("redirecd jsp");
		
		long userId = (long)session.getAttribute("userId");
		
		System.out.println(userId + "  withdraw UserId");
		
		List<Account> accounts = accountService.findByUserId(userId);
		
		model.addAttribute("account", accounts);
		
		return "withdraw";
	}
	
	@PostMapping("/createBankAccount")
	public String createBankAccount(@RequestParam(name= "account_type") AccountType acc_type,
									@RequestParam(name = "initial_deposit") BigDecimal initial_deposit,
									@RequestParam String branch_name) {
		System.out.println(acc_type + "  " + initial_deposit + "  acc controller");
		
		boolean status = accountService.createNewBankAccount(acc_type, initial_deposit, branch_name);
		
		return "dashboard";
	}
	
	@PostMapping("/withdraw")
	public String withdraw_money(@RequestParam BigDecimal amount_to_withdraw,
							@RequestParam String account_selected) {
		boolean status = accountService.withdrawMoney(amount_to_withdraw, account_selected);
		
		System.out.println(amount_to_withdraw + " " + account_selected + "  Controller ");
		
		if(!status) {
			System.out.println("low balance");
		}
		
		return "success";
	}
}
