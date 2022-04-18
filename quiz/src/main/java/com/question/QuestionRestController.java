package com.question;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.subject.SubjectBean;
import com.subject.SubjectDAO;

@RestController
@RequestMapping("/api")
public class QuestionRestController {
	
	@Autowired
	private QuestionDAO questionDao;
	@Autowired
	private AnswerDAO answerDao;
	
	@Autowired 
	private SubjectDAO subjectDao;
	
	@Autowired 
	private CorrectAnswerDAO correctAnswerDao;
	   
	@GetMapping("/question")
	public List<QuestionBean> questionmaster() {
		List<QuestionBean> queList = questionDao.findAll();
		
		for(QuestionBean bean : queList) {
			SubjectBean tempSubjectName = subjectDao.findBySubjectId(bean.getSubjectId());
			bean.setSubjectName(tempSubjectName.getSubjectName());
			bean.setAnsList(answerDao.findByQuestionId(bean.getQuestionId()));
		}
			return queList;
		}  
	
	@GetMapping("/question/{id}")
	public List<QuestionBean> showPage(@PathVariable int id) {
		List<QuestionBean> queList = questionDao.findByQuestionId(id);
		for(QuestionBean bean : queList) {
			SubjectBean tempSubjectName = subjectDao.findBySubjectId(bean.getSubjectId());
			CorrectAnswerBean  tempCorrectAnswer = correctAnswerDao.findByQuestionId(bean.getQuestionId());
			bean.setCorrectAnswerId(tempCorrectAnswer.getAnswerId());
			bean.setSubjectName(tempSubjectName.getSubjectName());
			bean.setAnsList(answerDao.findByQuestionId(bean.getQuestionId()));	
		}
			return queList;
	}
	
	
	@GetMapping("/questionsbysubject/{id}")
	public List<QuestionBean> subjectDetails(@PathVariable int id) {
		List<QuestionBean> queList = questionDao.findBySubjectId(id);
		try {
		for(QuestionBean bean : queList) {
			SubjectBean tempSubjectName = subjectDao.findBySubjectId(bean.getSubjectId());
			bean.setSubjectName(tempSubjectName.getSubjectName());
			bean.setAnsList(answerDao.findByQuestionId(bean.getQuestionId()));
			CorrectAnswerBean  tempCorrectAnswer = correctAnswerDao.findByQuestionId(bean.getQuestionId());
			bean.setCorrectAnswerId(tempCorrectAnswer.getAnswerId());
			System.out.println("CorrectAnswer: " + tempCorrectAnswer.getAnswerId());
			//bean.setCorrectAnswerId(tempCorrectAnswer.getCorrectAnswerId());
		}
		} catch(NullPointerException e) {
			
		}
			return queList;
	}
	
//	@PostMapping("/addquestion")
//	QuestionBean SaveQuestion(@RequestBody QuestionBean newQuestion) {
//	    return questionDao.save(newQuestion);
//	  }
//	
//	 @PutMapping("/updatequestion/{id}")
//	 public Optional<Object> updateQuestion(@RequestBody QuestionBean newQuestion, @PathVariable int id) { 
//	    return questionDao.findById(id).map(questionBean -> {
//	    	questionBean.setQuestion(newQuestion.getQuestion());
//	    	questionBean.setQueStatus(newQuestion.getQueStatus());
//	    	questionBean.setSubjectId(newQuestion.getSubjectId());
//	      return questionDao.save(questionBean);
//	    });
//	  }
	
}
