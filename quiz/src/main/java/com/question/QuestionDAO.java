package com.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDAO extends JpaRepository<QuestionBean, Integer> {
	
	public List<QuestionBean> findByQuestionId(int id);
	public List<QuestionBean> findBySubjectId(int id);
	public QuestionBean findByQuestionIdOrderByQuestionIdDesc(int queId);
}
