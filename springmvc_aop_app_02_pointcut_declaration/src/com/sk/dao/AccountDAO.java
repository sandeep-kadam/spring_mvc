package com.sk.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public void addAccount() {
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
