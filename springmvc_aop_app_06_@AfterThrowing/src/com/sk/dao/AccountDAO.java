package com.sk.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sk.bo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	
	public List<Account> findAcconts(boolean tripWire){
		
		if(tripWire) {
			throw new RuntimeException("Just Testing Exception ####");
		}
		
		
		List<Account> myAccounts = new ArrayList<>();
		
		//create some accounts
		Account acc1 = new Account("sandeep","123");
		Account acc2 = new Account("shrikant","124");
		Account acc3 = new Account("ganesh","125");
		
		myAccounts.add(acc1);
		myAccounts.add(acc2);
		myAccounts.add(acc3);
		
		return myAccounts;
	}
	
	public void addAccount(boolean isValidAccount, Account account) {
		System.out.println(getClass() + " : "+"DB QUERYIES EXECUTION");
	}

	public String getName() {
		System.out.println("getname : "+name);
		return name;
	}

	public void setName(String name) {
		System.out.println("setname : "+name);
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("getServiceCode : "+serviceCode);
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("setServiceCode : "+serviceCode);
		this.serviceCode = serviceCode;
	}
	
	
	
}
