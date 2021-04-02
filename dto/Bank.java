package com.css.bankapplication.dto;

import java.util.Arrays;

import com.css.bankapplication.dao.IBankServiceProvider;
import com.css.bankapplication.exception.InsufficientFundException;
import com.css.bankapplication.exception.InvalidAccountException;

public class Bank implements IBankServiceProvider {
	private String IFSCCode;
	private String bankName;
	private BankAccount[] accounts;
	
	public Bank() {
		super();
	}

	public Bank(String iFSCCode, String bankName, BankAccount[] accounts) {
		super();
		IFSCCode = iFSCCode;
		this.bankName = bankName;
		this.accounts = accounts;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BankAccount[] getAccounts() {
		return accounts;
	}

	public void setAccounts(BankAccount[] accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Bank [IFSCCode=" + IFSCCode + ", bankName=" + bankName + ", accounts=" + Arrays.toString(accounts)
				+ "]";
	}

	@Override
	public BankAccount checkAccount(String accountNo) throws InvalidAccountException {
		BankAccount foundAccount = null;
		for (BankAccount account : accounts){
			if (account.getAccountNo().equals(accountNo)){
				foundAccount = account;
				break;
			} 
		}
		if(foundAccount == null){
			throw new InvalidAccountException();
		}
		
		return foundAccount;
	}

	@Override
	public double getBalance(String accountNo)throws InvalidAccountException {
		double balance = 0.0;
		BankAccount foundAccount = checkAccount(accountNo);
		balance = foundAccount.getBalance();
		
		return balance;
	}

	@Override
	public boolean depositMoney(String accountNo, double amount) throws InsufficientFundException,InvalidAccountException {
		boolean dFlag = false;
		BankAccount foundAccount = checkAccount(accountNo);
		if(foundAccount!=null){
			foundAccount.setBalance(foundAccount.getBalance()+amount);
			dFlag = true;
		}
		
		return dFlag;
	}

	@Override
	public boolean withdrawMoney(String accountNo, double amount) throws InsufficientFundException,InvalidAccountException {
		boolean withdrawFlag = false;
		BankAccount foundAccount = checkAccount(accountNo);
		if(foundAccount!=null){
			foundAccount.setBalance(foundAccount.getBalance()+amount);
			withdrawFlag = true;
		}
		
		return withdrawFlag;
	}

	@Override
	public boolean transferMoney(String fromAccountNo, String toAccountNo, double amount) throws InsufficientFundException,InvalidAccountException {
		boolean transferFlag = false;
		boolean depositFlag = false;
		boolean withdrawFlag = withdrawMoney(fromAccountNo,amount);
		if(withdrawFlag)
			depositFlag = depositMoney(toAccountNo,amount);
		if(depositFlag)
			transferFlag = true;
		else
			depositMoney(fromAccountNo,amount);
		
		return transferFlag;
	}
}
