package com.quizsetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.subject.SubjectService;

@Controller
public class QuizSettingController {
	
	@Autowired
	private QuizSettingService quizSettingService;
	
	@Autowired private SubjectService subjectService;
	
	@GetMapping("/quizsetting")
	public String addQuizSetting() {
		return "quizSetting";
	}
	
	@GetMapping("/quizsetting/{id}")
	public String showSetting(@PathVariable int id, Model theModel, QuizSettingBean quizSettingBean) {
		theModel.addAttribute("quizDetails",quizSettingService.findByID(id));
		return "updateQuizSetting";
	}
	
	@RequestMapping("/quizsetting/update/{id}")
	public String updateSetting(@PathVariable int id, Model theModel, QuizSettingBean quizSettingBean) {
		//quizSettingService.update(id, quizSettingBean);
		theModel.addAttribute("subjectDetails",subjectService.findAll());
		return "subject";
	}
	
}
