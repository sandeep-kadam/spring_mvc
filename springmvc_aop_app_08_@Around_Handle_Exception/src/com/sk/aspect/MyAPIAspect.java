package com.sk.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAPIAspect {

	@Before("com.sk.aspect.MyPointCutDeclarations.forDaoNoSetterGetterPackage()")
	public void beforeAddAccount() {
		System.out.println("\n"+getClass()+ "------------inside MyAPIAspect @Before-----------\n");
	}
	
}
