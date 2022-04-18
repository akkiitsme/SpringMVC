package com.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDAO extends JpaRepository<SubjectBean,Integer> {
	public SubjectBean findBySubjectId(int subjectId);
}
