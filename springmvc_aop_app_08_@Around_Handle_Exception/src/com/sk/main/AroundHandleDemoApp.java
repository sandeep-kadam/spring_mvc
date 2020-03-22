package com.sk.main;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sk.config.DemoConfig;
import com.sk.service.TrafficFortuneService;

public class AroundHandleDemoApp {

	public static void main(String[] args) {

		System.out.println("AfterReturningDemoApp ##");
		
		//read spring config java class
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DemoConfig.class);
	
		//get bean from spring container
		TrafficFortuneService trafficFortuneService = appContext.getBean("trafficFortuneService",TrafficFortuneService.class);

		boolean status = true;
		String data = trafficFortuneService.getFortune(status);
		
		System.out.println("\nTraffic Fortune is :: "+data);
		
		appContext.close();
		
	}

}
