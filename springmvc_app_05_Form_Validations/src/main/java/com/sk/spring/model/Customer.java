package com.sk.spring.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

	private String firstName = "";

	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName = "";
	
	@NotNull(message="is required")
	//@Size is only valid for string input fields
	//@Size(min=18,max=60,message="only customer between 18-60 age are allowed")
	@Min(value=18,message=" must be greater than or equal to 18")
	@Max(value=60,message=" must be less than or equal to 60")
	private Integer age;
	//@Pattern not working for integer fields
	@Pattern(regexp="^[a-zA-Z0-9]{6}",message=" only 6 chars/digits are allowed")
	private String postalCode = "";
	
	public Customer() {

	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
