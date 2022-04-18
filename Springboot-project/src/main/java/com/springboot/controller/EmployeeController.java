package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.bean.EmployeeBean;
import com.springboot.service.CommonService;
import com.springboot.service.EmployeeService;


@Controller
@RequestMapping("/springapp")
public class EmployeeController {
	
	
	@Autowired
	private CommonService commonService;
	
	@GetMapping("/")
	public String homePage(@ModelAttribute("employeeDetails") EmployeeBean employeeDetails,Model theModel) {
		//ModelAndView modelandview = new ModelAndView();
		theModel.addAttribute("employeeDetails" ,employeeDetails);
		theModel.addAttribute("day",commonService.getEmployeeDetails(1));
		theModel.addAttribute("month",commonService.getEmployeeDetails(2));
		theModel.addAttribute("year",commonService.getEmployeeDetails(3));
		theModel.addAttribute("empStatus",commonService.getEmployeeDetails(4));
		theModel.addAttribute("edu",commonService.getEmployeeDetails(5));
		//modelandview.setViewName("addDetails");
		return "addDetails";
		
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveForm")
	public String savePage(@ModelAttribute("employeeDetails")EmployeeBean theEmployee) {	
		employeeService.save(theEmployee);
		return "confirmation";
	}
	
	@GetMapping("/showForm/{id}")
	public String showPage(@PathVariable int id,Model theModel) {
		//EmployeeBean employeeDetails = employeeService.findById(id);
		theModel.addAttribute("employeeDetails",employeeService.findById(id));
		theModel.addAttribute("day",commonService.getEmployeeDetails(1));
		theModel.addAttribute("month",commonService.getEmployeeDetails(2));
		theModel.addAttribute("year",commonService.getEmployeeDetails(3));
		theModel.addAttribute("empStatus",commonService.getEmployeeDetails(4));
		theModel.addAttribute("edu",commonService.getEmployeeDetails(5));
		return "editDetails";
		
	}
	@RequestMapping(value="/showForm/updateForm/{id}",method = RequestMethod.POST)
	public String updatePage(@PathVariable int id,@ModelAttribute("employeeDetails")EmployeeBean theEmployee) {	
		employeeService.update(id,theEmployee);
		return "confirmation";
	}
}
