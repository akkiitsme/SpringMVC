package com.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	@GetMapping(value="/")
	public String LoginPage(){
		return "login";
	}
	
	@GetMapping("/subject")
	public String showSubject(Model theModel) {
		theModel.addAttribute("subjectDetails",subjectService.findAll());
		return "subject";
		
	}
	
	@GetMapping("/subject/addsubject")
	public String addSubject(@ModelAttribute("subjectDetails")SubjectBean subjectBean,Model theModel) {
		return "addSubject";
	}
	
	@PostMapping("subject/savesubject")
	public String saveSubject(Model theModel,SubjectBean subjectBean) {
		subjectService.save(subjectBean);
		theModel.addAttribute("subjectDetails",subjectService.findAll());
		return "subject";
	}
	
	@GetMapping("/subject/updatesubject/{id}")
	public String showSubjectDetails(@PathVariable int id,Model theModel) {
		theModel.addAttribute("subjectDetails",subjectService.findById(id));
		return "updateSubject";	
	}
	@RequestMapping(value="/subject/updatesubject/edit/{id}",method = RequestMethod.POST)
	public String updateSubject(@PathVariable int id, Model theModel,SubjectBean subjectBean) {
		subjectService.update(id,subjectBean);
		theModel.addAttribute("subjectDetails",subjectService.findAll());
		return "subject";
		
	}
	
}
