package com.sk.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sk.bo.Account;
import com.sk.config.DemoConfig;
import com.sk.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		System.out.println("AfterReturningDemoApp ##");
		
		//read spring config java class
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DemoConfig.class);
	
		//get bean from spring container
		AccountDAO accountDAO = appContext.getBean("accountDAO",AccountDAO.class);

		
		//call method to findAccounts
		
		List<Account> accounts = accountDAO.findAcconts();
		
		//display the accounts
		System.out.println("\n ####### In Main App ########");
		System.out.println(accounts);
		
		appContext.close();
		
	}

}
