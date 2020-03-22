package com.sk.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@After("execution(* com.sk.dao.*.find*(..))")	
	public void afterFinallyFindAccounts(JoinPoint joinPoint) {
	
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n ###### Executing @After (finally) on method : "+method);
	}
	
	
	
	@Around("execution(* com.sk.service.*.getFortune*(..))")	
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
	
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n ###### Executing @Around on method : "+method);
	
		long begin = System.currentTimeMillis();
		
		Object result = null;
		
		//Case 1: handle exception inside Around advice due to this main app will not know about the exception.	
		/*try {
			result = proceedingJoinPoint.proceed();
		}catch(Exception e) {
			System.out.println("CustomException log: "+e.getMessage());
			result = " Covid-19 pandemic But no worries, Medical Help is ready to help you! ";
		}*/

		//Case 2: re-throw the exception occurred and main app will know about the exception thrown	
		try {
			result = proceedingJoinPoint.proceed();
		}catch(Exception e) {
			System.out.println("CustomException log: "+e.getMessage());
			throw e;
		}

		long end = System.currentTimeMillis();
		long duration = end - begin;
		
		System.out.println("\n ====>Execution Duration : "+duration / 1000.0 + " seconds");
		
		return result;
	}
	
	
	
}
