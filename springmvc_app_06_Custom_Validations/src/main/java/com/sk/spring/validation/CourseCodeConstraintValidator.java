package com.sk.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix = "";
	
	@Override
	public void initialize(CourseCode constraintAnnotation) {
		coursePrefix = constraintAnnotation.value(); //should return value of coursecode annotation
	}
	
	@Override
	public boolean isValid(String actualValue, ConstraintValidatorContext constraintValidatorContext) {

		boolean result = false;
		
		if(null != actualValue && actualValue.startsWith(coursePrefix)) {
			result = true;
		} 
			
		return result;
	}

}
