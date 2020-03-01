package com.sk.spring.model;

import java.util.LinkedHashMap;

public class Student {

	private String firstName = "";
	private String lastName = "";
	private String country = "";
	private LinkedHashMap<String, String> countryOptions;
	private String favLanguage = "";
	private LinkedHashMap<String, String> favLanguageOptions;
	private String jobProfile = "";
	private String[] devOptions;
	private String[] testerOptions;
	
	public Student() {

		countryOptions = new LinkedHashMap<>();
		countryOptions.put("INDIA", "INDIA");
		countryOptions.put("US", "US");
		countryOptions.put("CANADA", "CANADA");
		countryOptions.put("JAPAN", "JAPAN");
		
		
		favLanguageOptions = new LinkedHashMap<>();
		favLanguageOptions.put("Java", "Java");
		favLanguageOptions.put("Python", "Python");
		favLanguageOptions.put("C#", "C#");
		favLanguageOptions.put("C++", "C++");
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public LinkedHashMap<String, String> getFavLanguageOptions() {
		return favLanguageOptions;
	}
	
	public String getFavLanguage() {
		return favLanguage;
	}

	public void setFavLanguage(String favLanguage) {
		this.favLanguage = favLanguage;
	}
	
	public String getJobProfile() {
		return jobProfile;
	}

	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}

	public String[] getDevOptions() {
		return devOptions;
	}

	public void setDevOptions(String[] devOptions) {
		this.devOptions = devOptions;
	}

	public String[] getTesterOptions() {
		return testerOptions;
	}

	public void setTesterOptions(String[] testerOptions) {
		this.testerOptions = testerOptions;
	}


}
