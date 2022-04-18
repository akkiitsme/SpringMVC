package com.quizsetting;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizSettingService {
	
	@Autowired 
	private QuizSettingDAO quizSettingDao;
	
	public Optional<QuizSettingBean> findByID(Integer id){
		return quizSettingDao.findById(id);
	}
	
	public Optional<Object> update(Integer id,QuizSettingBean newSetting) {
		return quizSettingDao.findById(id).map(bean->{
			bean.setQuizTime(newSetting.getQuizTime());
			bean.setQuizModeCount(newSetting.getQuizModeCount());
			bean.setRandomModeCount(newSetting.getRandomModeCount());
			return quizSettingDao.save(bean);
		});
	}
	

}
