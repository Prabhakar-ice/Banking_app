package com.prabha.SpringMVC.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	

	@PostMapping("/createBankAccount")
	public String createBankAccount(@RequestParam(name= "account_type") String acc_type,
									@RequestParam(name = "initial_deposit") BigDecimal initial_deposit,
									@RequestParam String branch_name, HttpSession session, RedirectAttributes redirectAttributes) {
		System.out.println(acc_type + "  " + initial_deposit + "  acc controller");
		
		if((Long)session.getAttribute("userId") == null) {
					
			redirectAttributes.addFlashAttribute("error", "Session Time Out Please Login again");
			
			return "redirect:/login";
		}
		
		Long userId = (Long)session.getAttribute("userId");
		
		if(accountService.countAccountsByUser(userId) > 5) {
			redirectAttributes.addFlashAttribute("error", "You cannot create account, You have reach the limit");
			return "redirect:/createAccount";
		}
		
		boolean status = accountService.createNewBankAccount(acc_type, initial_deposit, branch_name, userId);
		
		if(!status) {
			redirectAttributes.addFlashAttribute("error", "Account creation failed. Try again.");
	        return "redirect:/createAccount";
		}
		
		return "accountCreated";
	}
	
	
	@GetMapping("/withdraw")
	public String withdraw(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		
		System.out.println("redirecd jsp");
		
		
		if((Long)session.getAttribute("userId") == null) {
			
			redirectAttributes.addFlashAttribute("error", "Session Time Out Please Login again");
			
			return "redirect:/login";
		}
		
		Long userId = (Long)session.getAttribute("userId");
		
		System.out.println(userId + "  withdraw UserId");
		
		List<Account> accounts = accountService.findByUserId(userId);
		
		System.out.println(accounts);
		
		model.addAttribute("accounts", accounts);
		
		return "withdraw";
	}
	
	
	@PostMapping("/withdraw")
	public String withdraw_money(@RequestParam BigDecimal amount_to_withdraw,
							@RequestParam String account_selected) {
		
		boolean status = accountService.withdrawMoney(amount_to_withdraw, account_selected);
		
		System.out.println(amount_to_withdraw + " " + account_selected + "  Controller ");
		
		if(!status) {
			System.out.println("low balance");
		}
		
		return "withdrawSuccess";
	}
}
