package com.sk.spring.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	
	//@Constraint -> defines validation constraint defined in CourseCodeConstraintValidator class file
	//CourseCodeConstraintValidator is a helper class which contains business validation/validation logic.
	
	//@Target -> where to apply this annotation
	
	//@Retention - > how long will the marked annotation will used/stay( RUNTIME process at runtime)
	
	
	
	//define default course code
	public String value() default "MVC";
	
	//define default error message
	public String message() default "must starts with MVC";
	
	//define deafult groups
	public Class<?>[] groups() default {};
	
	//define default payloads
	public Class<? extends Payload>[] payload() default {}; 

}
