package com.sk.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sk.bo.Account;
import com.sk.config.DemoConfig;
import com.sk.dao.AccountDAO;
import com.sk.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		System.out.println("AfterReturningDemoApp ##");
		
		//read spring config java class
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DemoConfig.class);
	
		//get bean from spring container
		TrafficFortuneService trafficFortuneService = appContext.getBean("trafficFortuneService",TrafficFortuneService.class);

		String data = trafficFortuneService.getFortune();
		
		System.out.println("\nTraffic Fortune is :: "+data);
		
		appContext.close();
		
	}

}
