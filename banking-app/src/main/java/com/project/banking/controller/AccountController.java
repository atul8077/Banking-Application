package com.project.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.banking.entity.Account;
import com.project.banking.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	
	
	//CREATE AN ACCOUNT
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createAccount=service.createAccount(account);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
		
	}
	
	
	//GET ACCOUNT BY ID
	@GetMapping("/{accountNumber}")
	public Account getAccountByAN(@PathVariable Long accountNumber) {
		Account account=service.getAccountByAN(accountNumber);
		
		return account;
	}
	
	
	
	
	//for get ALL THE ACCOUNT DETAILS
	@GetMapping("/getallAccount")
	public List<Account> getAllDetails(){
		List<Account> account=service.getAllAccountDetails();
		return account;
	}
	
	
	
	
	//for DEPOSIT THE AMOUNT 
	@PutMapping("/deposite/{accountNumber}/{amount}")
	public Account depositAccount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		Account account=service.depositAmount(accountNumber, amount);
		return account;
	}
	
	
	
	
	//for WITHDROW AMOUNT
	@PutMapping("/withdrow/{accountNumber}/{amount}")
	public Account withdrowAmount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		Account account=service.withdrowAmount(accountNumber, amount);
		
		return account;
	}
	
	
	
	
	//for DELETE AN ACCOUNT
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<Account> deleteAccountByid(@PathVariable Long accountNumber) {
	  Account deleteAccount=service.closeAccount(accountNumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleteAccount);
		
	}

}
