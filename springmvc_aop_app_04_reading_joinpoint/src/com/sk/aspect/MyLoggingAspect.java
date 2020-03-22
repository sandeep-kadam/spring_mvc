package com.sk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sk.bo.Account;
import com.sk.dao.AccountDAO;

@Aspect
@Component
@Order(3)
public class MyLoggingAspect {
	
	@Before("com.sk.aspect.MyPointCutDeclarations.forDaoNoSetterGetterPackage()")
	public void beforeAddAccount(JoinPoint joinPoint) {
		System.out.println("\n"+getClass()+ "------------inside MyLoggingAspect @Before-----------\n");
		
		//display method signature
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		System.out.println("method signature : "+methodSignature);
		
		//display method arguments
		Object[] argsArray = joinPoint.getArgs();
		
		for(Object arg : argsArray) {
			System.out.println(arg);
			
			if(arg instanceof Account) {
				//downcast and print account specific stuff
				Account account = (Account)arg;
				
				System.out.println("Account name : " + account.getAccountName());
				System.out.println("Account name : " + account.getAccountNumber());
			}
		}
	}
	
	
}
