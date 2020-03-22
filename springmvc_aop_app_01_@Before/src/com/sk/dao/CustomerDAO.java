package com.sk.dao;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {

	
	public void addCustomer() {
		System.out.println(getClass() + " : "+"DB QUERYIES EXECUTION");
	}
}
