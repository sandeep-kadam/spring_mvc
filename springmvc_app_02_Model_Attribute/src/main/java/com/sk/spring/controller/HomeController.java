package com.sk.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "registeredUser";
	}
	
	//using Model Attribute to manipulate form data
	@RequestMapping("/processFormVersiontwo")
	public String upperCaseFormField(HttpServletRequest request, Model model) {
		
		String upperCaseFieldName = "";
		if(!StringUtils.isEmpty(request.getParameter("userName"))) {
			upperCaseFieldName = request.getParameter("userName").toUpperCase();
		} else {
			upperCaseFieldName = "emptry String";
		}
		
		model.addAttribute("message", upperCaseFieldName);
		
		return "registeredUser";
	}
	
	//Reading form parameters using @RequestParam("fieldName")
	@RequestMapping("/processFormVersionthree")
	public String processFormVersionthree(@RequestParam("userName") String name, Model model) {
		
		String upperCaseFieldName = "";
		if(!StringUtils.isEmpty(name)) {
			upperCaseFieldName = "Hey "+name.toUpperCase()+" , welcome to the world of spring";
		} else {
			upperCaseFieldName = "emptry String";
		}
		
		model.addAttribute("message", upperCaseFieldName);
		
		return "registeredUser";
	}
	
	
	

}
