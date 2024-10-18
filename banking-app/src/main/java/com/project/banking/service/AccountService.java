package com.project.banking.service;

import java.util.List;

import com.project.banking.entity.Account;

public interface AccountService {
	
	//create the account
	public Account createAccount(Account account);
	
	//get account using accnumber
	public Account getAccountByAN(Long accountNumber);
	
	//all account Details
	public List<Account> getAllAccountDetails();
	
	//deposite the money
	public Account depositAmount(Long accountNumber , Double amount);
	
	//withdrow 
	public Account withdrowAmount(Long accountNumber , Double amount);
	
	//delete an Account
	public  Account closeAccount(Long accountNumber);
	
	

}
