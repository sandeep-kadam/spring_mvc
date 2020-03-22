package com.sk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
		
		accountDAO.addAccount();
		
		//calling again
		customerDAO.addCustomer();
		
		appContext.close();
		
	}

}
