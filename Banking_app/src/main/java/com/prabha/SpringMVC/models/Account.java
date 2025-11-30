package com.prabha.SpringMVC.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.prabha.SpringMVC.dto.AccountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "Account")
@Table(name = "Account",
				uniqueConstraints = 
						@UniqueConstraint(name = "Account_no_unique", columnNames = "Account No")
				)
public class Account {

	@Id
	@Column(name = "Account No", nullable = false, length = 15)
	private String accountNo;
	
	@ManyToOne // meaning many accounts belongs to one user 
	@JoinColumn(name = "user_id") 
	private User user;
	
	
	@Column(name = "Balance", nullable = false, columnDefinition = "DECIMAL(15,2) DEFAULT 0.00" )
	private BigDecimal balance;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "Account Type")
	private AccountType accType;
	
	private LocalDateTime created_on;
	
	public Account() {
		super();
	}
	
	public Account( AccountType acc_type) {
		this.accType = acc_type;
	}


	public String getAccount_no() {
		return accountNo;
	}


	public void setAccount_no(String account_no) {
		this.accountNo = account_no;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public AccountType getAcc_type() {
		return accType;
	}


	public void setAcc_type(AccountType acc_type) {
		this.accType = acc_type;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public LocalDateTime getCreated_on() {
		return created_on;
	}
	
	public void setCreated_on() {
		this.created_on = LocalDateTime.now();;
	}


	@Override
	public String toString() {
		return "Account [account_no=" + accountNo + ", user_id=" + user.getId() + ", balance=" + balance + ", acc_type="
				+ accType + ", created_on=" + created_on + "]";
	}
	
	
	
}
