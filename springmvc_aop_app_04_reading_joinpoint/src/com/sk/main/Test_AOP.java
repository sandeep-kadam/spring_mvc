package com.sk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sk.bo.Account;
import com.sk.config.DemoConfig;
import com.sk.dao.AccountDAO;
import com.sk.dao.CustomerDAO;

public class Test_AOP {

	public static void main(String[] args) {

		System.out.println("Test AOP ##");
		
		//read spring config java class
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DemoConfig.class);
	
		//get bean from spring container
		AccountDAO accountDAO = appContext.getBean("accountDAO",AccountDAO.class);
		CustomerDAO customerDAO = appContext.getBean("customerDAO",CustomerDAO.class);
		
		Account account = new Account();
		account.setAccountName("fffffffffffffffffff");
		account.setAccountNumber("1234444444444");
		accountDAO.addAccount(true,account);
		
		//call the accountDAO setters/getters method
		accountDAO.setName("sandeep");
		accountDAO.setServiceCode("1854");
		
		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();
		
		//calling again
		customerDAO.addCustomer();
		
		appContext.close();
		
	}

}
