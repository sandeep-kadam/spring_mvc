package com.sk.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	
	public String getFortune() {
		
		try {

			TimeUnit.SECONDS.sleep(5);
		
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Expect Heavy traffic this morning";
	}

	public String getFortune(boolean status) {
		
		if(status) {
			throw new RuntimeException("Due to Covid-19 pandemic : Mumbai is lockdown");
		}
		
		return getFortune();
	}
}
