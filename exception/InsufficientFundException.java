package com.css.bankapplication.exception;

 
	public class InsufficientFundException extends Exception {
		
		private String errorMsg = "Insuffiient fund in your account.";

		public InsufficientFundException(String errorMsg) {
			super();
			this.errorMsg = errorMsg;
		}

		public InsufficientFundException() {
			super();
		}

		@Override
		public String getMessage() {
			return this.errorMsg;
		}
		
		
	}

	
	
	
