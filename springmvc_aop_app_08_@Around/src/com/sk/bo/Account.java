package com.sk.bo;

public class Account {

	private String accountName;
	private String accountNumber;
	
	public Account() {
		System.out.println("inside 0-param constructor Account()");
	}
	
	public Account(String accountName, String accountNumber) {
		super();
		this.accountName = accountName;
		this.accountNumber = accountNumber;
	}


	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", accountNumber=" + accountNumber + "]";
	}
	
}
