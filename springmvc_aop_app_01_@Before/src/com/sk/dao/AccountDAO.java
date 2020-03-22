package com.sk.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	
	public void addAccount() {
		System.out.println(getClass() + " : "+"DB QUERYIES EXECUTION");
	}
	
}
