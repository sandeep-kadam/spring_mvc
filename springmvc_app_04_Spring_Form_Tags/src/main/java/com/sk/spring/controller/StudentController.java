package com.sk.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sk.spring.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	
	
	@RequestMapping("/registration")
	public String showStudentForm(Model model) {
		
		Student studentobj = new Student();
		model.addAttribute("student", studentobj);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(HttpServletRequest request ,@ModelAttribute("student") Student studentObj) {

		//log data
		System.out.println("First Name : "+studentObj.getFirstName());
		System.out.println("Last Name : "+studentObj.getLastName());
		System.out.println("Country : "+studentObj.getCountry());
		System.out.println("JobProfile : "+studentObj.getJobProfile());
		
		request.setAttribute("jobProfile", studentObj.getJobProfile());
		
		return "studentConfirmation";
	}
}
