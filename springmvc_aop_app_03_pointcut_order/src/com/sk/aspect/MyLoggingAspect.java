package com.sk.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyLoggingAspect {
	
	@Before("com.sk.aspect.MyPointCutDeclarations.forDaoNoSetterGetterPackage()")
	public void beforeAddAccount() {
		System.out.println("\n"+getClass()+ "------------inside MyLoggingAspect @Before-----------\n");
	}
	
	
}
