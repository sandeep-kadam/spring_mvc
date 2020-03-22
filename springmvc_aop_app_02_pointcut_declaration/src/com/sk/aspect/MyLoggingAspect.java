package com.sk.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
	
	/*@Before("execution(public void com.sk.dao.AccountDAO.addAccount())")
	public void beforeAllAdd() {
		System.out.println("\n ------------ inside ASPECT @Before ###-----------\n");
	}*/
	
	
	//deinfing pointcut expression
	@Pointcut("execution(* com.sk.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	//poincut for getters methods
	@Pointcut("execution(* com.sk.dao.*.get*(..))")
	private void getter() {}
	
	//pointcut for setters methods
	@Pointcut("execution(* com.sk.dao.*.set*(..))")
	private void setter() {}
	
	//combining pointcuts : including dao but excluding getters & setters pointcut
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoNoSetterGetterPackage() {}
	
	
	@Before("forDaoNoSetterGetterPackage()")
	public void beforeAddAccount() {
		System.out.println("\n ------------ combined POINTCUT ASPECT @Before Using PointCut Exp###-----------\n");
	}
	
	
}
