package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bean.EmployeeBean;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeBean,Integer> {
	
	
}
