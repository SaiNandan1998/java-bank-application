package com.css.bankapplication.exception;


	public class InvalidAccountException extends Exception {
		private String errorMsg = "Your AccountNo is invalid.";

		public InvalidAccountException(String errorMsg) {
			super();
			this.errorMsg = errorMsg;
		}

		public InvalidAccountException() {
			super();
		}

		@Override
		public String getMessage() {
			return this.errorMsg;
		}
		
		

	}

