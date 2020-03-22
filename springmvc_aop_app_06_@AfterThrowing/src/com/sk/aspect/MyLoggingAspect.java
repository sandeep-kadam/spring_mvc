package com.sk.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sk.bo.Account;

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
	
	@AfterReturning(pointcut="execution(* com.sk.dao.*.find*(..))",returning="accountList")
	public void afterReturninhFindAccount(JoinPoint joinPoint ,List<Account> accountList) {
		
		
		//method signature
		String methodName = joinPoint.getSignature().toString();
		System.out.println("Method Name : "+methodName);
		
		//Actual Result
		System.out.println("\n inside @AfterReturing : "+accountList);
		
		convertAccountNamesToUpperCase(accountList);
		
		System.out.println("\n After Conversion AccountNames : "+accountList);
	}

	private void convertAccountNamesToUpperCase(List<Account> accountList) {

		for(Account tempAccount : accountList) {
			String upperCaseName = tempAccount.getAccountName().toUpperCase();
			tempAccount.setAccountName(upperCaseName);
		}
	}
	
	@AfterThrowing(
			pointcut="execution(* com.sk.dao.*.find*(..))",
			throwing="exception")	
	public void afterThrowingFindAccounts(JoinPoint joinPoint, Throwable exception) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n ###### Executing @AfterThrowing on method : "+method);
		
		System.out.println("\n The Exception is ::: "+exception);
		
		
	}
	
	
}
