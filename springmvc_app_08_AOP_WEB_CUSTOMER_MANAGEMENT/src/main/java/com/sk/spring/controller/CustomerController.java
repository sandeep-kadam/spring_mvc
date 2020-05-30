package com.sk.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sk.spring.entity.Customer;
import com.sk.spring.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject customerDAO object
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("searchName") String customerName, Model model) {
		System.out.println("inside searchCustomer");
		
		
		//get customer list from dao through service layer
		List<Customer> customerList = customerService.getCustomers(customerName);
		
		//add customer list to spring model
		model.addAttribute("customerList", customerList);
		
		return "list-customers";
	}
	
	
	//new annotation from spring to allow only GET method request
	//Its a replacement for @RequestMapping(path="/list", method=RequestMethod.GET)
	@GetMapping("/list")
	public String listCustomer(Model model) {
		System.out.println("inside list customer");
		
		//get customer list from dao through service layer
		List<Customer> customerList = customerService.getCustomers("");
		
		//add customer list to spring model
		model.addAttribute("customerList", customerList);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showCustomerAddForm")
	public String showCustomerAddForm(Model model) {
		
		//bind form data to spring model
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.saveCustomer(customer);
		//used to redirect to different controller path
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showCustomerUpdateForm")
	//Here @RequestParam("param Name") reads form parameters
	public String showCustomerUpdateForm(@RequestParam("customerId") int customerId, Model model) {
		
		//get customerDetails for customerId from service
		Customer customer = customerService.getCustomer(customerId); 
		model.addAttribute("customer",customer);
		return "customer-form";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int customerId) {

		customerService.deleteCustomer(customerId);
		//used to redirect to different controller path
		return "redirect:/customer/list";
	}
	
	
}
