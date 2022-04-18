package com.question;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionController {
	
	@Autowired 
	private QuestionService questionService;
	
	@GetMapping(value="/login")
	public String LoginPage(){
		return "login";
	}
	
	@GetMapping("/question")
	public String showQuestionPage(Model theModel) {
		theModel.addAttribute("questionDetails",questionService.findAll());
		return "questionMaster";
	}

	@GetMapping("/question/addquestion")
	public String addQuestionPage(@ModelAttribute("questionWithAnswer")QuestionBean questionBean,Model theModel) {
		theModel.addAttribute("subjectDetails",questionService.getSubjectName());
		return "addQuestion";
	}
	
	@PostMapping("/question/savequestion")
	public String saveQuestionPage(Model theModel,QuestionBean questionBean) {
		questionService.save(questionBean);
		theModel.addAttribute("questionDetails",questionService.findAll());
		return "questionMaster";
	}
	
	@GetMapping("/question/updatequestion/{id}")
	public String showQuestionDetailsPage(@PathVariable int id,Model theModel) {
		theModel.addAttribute("subjectDetails",questionService.getSubjectName());
		theModel.addAttribute("questionDetails",questionService.FindById(id));
		return "updateQuestion";
	}
	
	@RequestMapping(value="/question/updatequestion/edit/{id}",method = RequestMethod.POST)
	public String updateQuestionPage(@PathVariable int id, Model theModel,QuestionBean questionBean) {
		questionService.updateQuestion(id,questionBean);
		theModel.addAttribute("questionDetails",questionService.findAll());
		return "questionMaster";
	}
}
