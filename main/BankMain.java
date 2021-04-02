
	package com.css.bankapplication.main;

	import com.css.bankapplication.dto.Bank;
	import com.css.bankapplication.dto.BankAccount;
	import com.css.bankapplication.exception.InsufficientFundException;
	import com.css.bankapplication.exception.InvalidAccountException;

	public class BankMain {

		public static void main(String[] args){
			BankAccount[] accounts = new BankAccount[3];
			accounts[0] = new BankAccount("	Nandan");
			accounts[1] = new BankAccount("Harsheth");
			accounts[2] = new BankAccount("Natrajan");
			
			Bank sbiBank = new Bank("SBI123","guindy",accounts);
			BankAccount foundAccount = null;
			double balance = 0.0;
			try {
				foundAccount = sbiBank.checkAccount("1001");
				balance = sbiBank.getBalance("1001");
				
				sbiBank.depositMoney("1000", 10000.00);
				
				sbiBank.withdrawMoney("1001", 300);
				
				sbiBank.transferMoney("1000", "1002", 800);
				 
				
			} catch (InsufficientFundException | InvalidAccountException e) {
				e.printStackTrace();
			}
			System.out.println(foundAccount.toString());
			
			System.out.println(balance);
		
		
		}
	}
		
		
		
		
		
		
		
		

	


