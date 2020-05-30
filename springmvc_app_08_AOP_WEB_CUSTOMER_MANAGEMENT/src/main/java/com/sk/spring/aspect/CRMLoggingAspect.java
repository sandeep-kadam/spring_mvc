package com.sk.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	
	//setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declaration
	@Pointcut("execution(* com.sk.spring.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.sk.spring.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.sk.spring.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
		
	}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		//display method name which we are calling
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("##### in @Before : calling method : " + methodName);
		
		//get method arguments
		Object[] methodArgs = joinPoint.getArgs();
		
		for(Object args : methodArgs) {
			logger.info(" Arguments ### : "+args);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()" , returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		
		//display method we are returning
		String methodName = joinPoint.getSignature().toShortString();
		logger.info(" ######### in @AfterReturning : from method : "+ methodName);
		
		//display data returned from method
		logger.info("Return Value is ===> "+result);
	}
	
	
	
	
	//add @AfterReturning advicd
}
