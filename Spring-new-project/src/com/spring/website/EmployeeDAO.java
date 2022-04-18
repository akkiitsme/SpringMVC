package com.spring.website;

import java.util.List;

public interface EmployeeDAO {
	public List<EmployeeCommonBean> getUserList(int temp);
	public void insertData(Employee emp);
	public Employee getEmpById(int id);
//	public Employee getUserDOB(String dob);
	public String getUserDOBSplited(String dob);
	public void updateData(Employee emp);
	
	public String getDate(String val,String type);
	
}