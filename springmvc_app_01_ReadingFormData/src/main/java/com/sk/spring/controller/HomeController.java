package com.sk.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*picks up component of web app*/
@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	// need a controller method to show the initial HTML form
	@RequestMapping("/displayForm")
	public String showForm() {
		return "displayForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "registeredUser";
	}
	
	
	//need a controller method to process the HTML form

}
