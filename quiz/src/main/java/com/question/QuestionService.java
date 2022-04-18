package com.question;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.subject.SubjectBean;
import com.subject.SubjectDAO;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionDAO questionDao;
	
	@Autowired
	private AnswerDAO answerDao;
	
	@Autowired 
	private SubjectDAO subjectDao;
	
	@Autowired
	private CorrectAnswerDAO correctAnswerDao;
	
	//show list in question master page
	public List<QuestionBean> findAll() {
		List<QuestionBean> queList = questionDao.findAll();
		for(QuestionBean bean : queList) {
			SubjectBean tempSubjectName = subjectDao.findBySubjectId(bean.getSubjectId());
			bean.setSubjectName(tempSubjectName.getSubjectName());
			bean.setAnsList(answerDao.findByQuestionId(bean.getQuestionId()));
		}
			return queList;
		} 
	
	//Get subject name list in add questionPage
	public List<SubjectBean> getSubjectName() {
		return subjectDao.findAll();
	}

	//save the question with Answers
	public void save(QuestionBean questionBean) {
		//save question in lu_quiz_question
		questionDao.save(questionBean);
		
		// save Answer in lu_quiz_answer
		List<AnswerBean> ansList = questionBean.getAnsList();
		for(AnswerBean bean:ansList){
			QuestionBean tempQueId = questionDao.findByQuestionIdOrderByQuestionIdDesc(questionBean.getQuestionId());
			bean.setQuestionId(tempQueId.getQuestionId());
			bean.getAnswer();
		}
		answerDao.saveAll(ansList);
		
		//save correct Answer in lu_quiz_correct_answer
		CorrectAnswerBean correctAnsBean = new CorrectAnswerBean();
		QuestionBean tempQueId = questionDao.findByQuestionIdOrderByQuestionIdDesc(questionBean.getQuestionId());
		correctAnsBean.getCorrectAnswerId();
		correctAnsBean.setQuestionId(tempQueId.getQuestionId());
		correctAnsBean.setAnswerId(questionBean.getCorrectAnswerId());
		correctAnsBean.getStatus();
		correctAnsBean.getCreatedOn();
		correctAnswerDao.save(correctAnsBean);
		
	}
	
	//Find the Question With answer using Id in update Question Page
	public QuestionBean FindById(int id){
		Optional<QuestionBean> result = questionDao.findById(id);
		QuestionBean questionBean = result.get();
			List<QuestionBean> ansList = questionDao.findByQuestionId(id);
			try {
			for(QuestionBean bean : ansList) {
				CorrectAnswerBean  tempCorrectAnswer = correctAnswerDao.findByQuestionId(bean.getQuestionId());
				bean.setAnsList(answerDao.findByQuestionId(bean.getQuestionId()));	
				bean.setCorrectAnswerId(tempCorrectAnswer.getAnswerId());
			}
			questionBean.setAnsList(questionBean.getAnsList());
			questionBean.setCorrectAnswerId(questionBean.getCorrectAnswerId());
			} catch(NullPointerException e){
							
			}
		return questionBean;
		
	}

	//update And Save Question Details with answer 
	public void updateQuestion(int id, QuestionBean questionBean) {
		try {
		QuestionBean updateDetails = questionDao.findById(id).orElse(null);
		updateDetails.setSubjectId(questionBean.getSubjectId());
		updateDetails.setQueStatus(questionBean.getQueStatus());
		updateDetails.setQuestion(questionBean.getQuestion());
		questionDao.save(updateDetails);
		
		List<AnswerBean> ansList = questionBean.getAnsList();
		for(AnswerBean bean:ansList){
			QuestionBean tempQueIdAndSubId = questionDao.findByQuestionIdOrderByQuestionIdDesc(questionBean.getQuestionId());
			bean.setAnswerId(bean.getAnswerId());;
			bean.setQuestionId(tempQueIdAndSubId.getQuestionId());
			bean.setAnswer(bean.getAnswer());	
		}
		answerDao.saveAll(ansList);

		CorrectAnswerBean updateAnswer = correctAnswerDao.findByQuestionId(questionBean.getQuestionId());
		updateAnswer.setCorrectAnswerId(updateAnswer.getCorrectAnswerId());
		updateAnswer.setAnswerId(questionBean.getCorrectAnswerId());
		correctAnswerDao.save(updateAnswer);
		} catch(NullPointerException e) {
			
		}
	}
}
