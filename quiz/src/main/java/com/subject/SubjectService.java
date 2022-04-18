package com.subject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  SubjectService {
	@Autowired
	private SubjectDAO subjectDAO;

	//Getting Subject Lists
	public List<SubjectBean> findAll() {
		return subjectDAO.findAll() ;
	}
	
	//Saving Subject
	public SubjectBean save(SubjectBean subjectBean) {
		return subjectDAO.save(subjectBean);
		
	}
	
	//Subject Details BY ID
	public SubjectBean findById(int id) {
	   Optional<SubjectBean> result = subjectDAO.findById(id);
       SubjectBean subjectBean = result.get();
       subjectBean.setSubjectId(subjectBean.getSubjectId());
       subjectBean.setSubjectName(subjectBean.getSubjectName());
       subjectBean.setSubjectStatus(subjectBean.getSubjectStatus());
		return subjectBean;
	}
	
	//Subject UPDATE 
	public SubjectBean update(int id, SubjectBean subjectBean) {
		SubjectBean updateDetails = subjectDAO.findById(id).orElse(null);
		updateDetails.setSubjectName(subjectBean.getSubjectName());
		updateDetails.setSubjectStatus(subjectBean.getSubjectStatus());
		return subjectDAO.save(updateDetails);
		
	}
}
