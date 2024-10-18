package com.project.banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.banking.entity.Account;
import com.project.banking.repository.AccountRepository;

@Service
public class AccountServiceimpl implements AccountService{

	@Autowired
	AccountRepository repo;
	
	
	//FOR CREATING AN ACCOUNT
	@Override
	public Account createAccount(Account account) {
		 Account account_save= repo.save(account);
		return account_save;
	}

	
	//GET ACCOUNT BY ACCOUNT NUMBER
	@Override
	public Account getAccountByAN(Long accountNumber) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is  not present ");
		}
		Account account_Found=account.get();
		return account_Found;
	}
	
	
	//for get ALL THE ACCOUNT DETAILS
	@Override
	public List<Account> getAllAccountDetails() {
		List<Account> listofaccount=repo.findAll();
		return listofaccount;
	}

	
	//for DEPOSIT THE AMOUNT 
	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
	 Optional<Account> account=	repo.findById(accountNumber);
	 if(account.isEmpty()) {
		 throw new RuntimeException("Account is  not present ");
	 }
	 Account accountPresent=account.get();
	Double totalBalance= accountPresent.getBalance()+amount;
	accountPresent.setBalance(totalBalance);
	repo.save(accountPresent);
		return accountPresent;
	}
	
	
	
	
	//for WITHDROW AMOUNT
	@Override
	public Account withdrowAmount(Long accountNumber, Double amount) {
		Optional<Account> account= repo.findById(accountNumber);
	   if(account.isEmpty()) {
		   throw new RuntimeException("Account is  not present ");
		   
	   }
	   Account accountPresent=account.get();
	   Double totalBalance= accountPresent.getBalance()-amount;
	   accountPresent.setBalance(totalBalance);
	   repo.save(accountPresent);
	   
		return accountPresent;
	}
	
	
	
	
	//for DELETE AN ACCOUNT
	@Override
	public Account closeAccount(Long accountnumber) {
		Optional<Account> account= repo.findById(accountnumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		
		repo.deleteById(accountnumber);
		return account.get();
		}
		
}

