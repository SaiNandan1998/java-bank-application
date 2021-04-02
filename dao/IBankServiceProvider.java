package com.css.bankapplication.dao;

import com.css.bankapplication.dto.BankAccount;
import com.css.bankapplication.exception.InsufficientFundException;
import com.css.bankapplication.exception.InvalidAccountException;

public interface IBankServiceProvider {
     BankAccount checkAccount(String accountNo) throws InvalidAccountException;
	 double getBalance(String accountNo) throws InvalidAccountException;
	 boolean depositMoney(String accountNo, double amount) throws InvalidAccountException, InsufficientFundException;
	 boolean withdrawMoney(String accountNo, double amount) throws InvalidAccountException, InsufficientFundException;
	 boolean transferMoney(String fromAccountNo, String toAccountNo, double amount) throws InsufficientFundException,InvalidAccountException;
	
	
}
