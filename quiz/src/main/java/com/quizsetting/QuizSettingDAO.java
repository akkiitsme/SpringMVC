package com.quizsetting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizSettingDAO extends JpaRepository<QuizSettingBean,Integer> {

	public QuizSettingBean findByQuizSettingId(int id);

}
