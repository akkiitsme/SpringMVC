package com.springboot.service;

import java.util.List;

import com.springboot.bean.EmployeeBean;

public interface EmployeeService {
	
	public EmployeeBean save(EmployeeBean theEmployee);

	public EmployeeBean findById(int id);

	public EmployeeBean update(int id,EmployeeBean theEmployee);
	
	//public String getDate(String val , int type);
}
