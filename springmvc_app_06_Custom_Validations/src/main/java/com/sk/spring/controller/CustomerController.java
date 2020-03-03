package com.sk.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sk.spring.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	//add an initbinder to trim input strings
	//removes leading and trailing whitespaces
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		System.out.println("inside initBinder ######");
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	
	@RequestMapping("/registration")
	public String showStudentForm(Model model) {
		
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	
	//@Valid to validate @Model i.e customer
	//binding result spring background error binder
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customerObj,
			BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			System.out.println("has errors : "+bindingResult.hasErrors());
			System.out.println("Fields ## : "+bindingResult.getAllErrors());
			return "customer-form";
		} else {
			return "customerConfirmation";
		}
	}
}
