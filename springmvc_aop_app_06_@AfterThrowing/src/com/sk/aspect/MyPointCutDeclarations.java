package com.sk.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyPointCutDeclarations {

	//deinfing pointcut expression
	@Pointcut("execution(* com.sk.dao.*.*(..))")
	public void forDaoPackage() {}
	
	
	//poincut for getters methods
	@Pointcut("execution(* com.sk.dao.*.get*(..))")
	public void getter() {}
	
	//pointcut for setters methods
	@Pointcut("execution(* com.sk.dao.*.set*(..))")
	public void setter() {}
	
	//combining pointcuts : including dao but excluding getters & setters pointcut
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoNoSetterGetterPackage() {}
}
