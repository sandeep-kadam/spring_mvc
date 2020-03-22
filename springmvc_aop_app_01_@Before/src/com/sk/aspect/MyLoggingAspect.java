package com.sk.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

	
	/*@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ------------ inside ASPECT @Before -----------\n");
	}*/
	
	/*@Before("execution(public void add*())")
	public void beforeAllAdd() {
		System.out.println("\n ------------ inside ASPECT @Before ###-----------\n");
	}*/
	
	@Before("execution(public void com.sk.dao.AccountDAO.addAccount())")
	public void beforeAllAdd() {
		System.out.println("\n ------------ inside ASPECT @Before ###-----------\n");
	}
	
}
