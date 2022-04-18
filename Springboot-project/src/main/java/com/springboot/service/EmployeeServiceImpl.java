package com.springboot.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bean.EmployeeBean;
import com.springboot.dao.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public EmployeeBean save(EmployeeBean theEmployee) {
		//Splitting the Date
		String year = theEmployee.getYear();
		String month = theEmployee.getMonth();
		String day = theEmployee.getDay();
		String newDob = year+"-"+month+"-"+day;
		theEmployee.setDob(newDob);
		return employeeRepository.save(theEmployee);
	}

	@Override
	public EmployeeBean findById(int id) {
		Optional<EmployeeBean> result = employeeRepository.findById(id);	
		EmployeeBean theEmployee = result.get();
			// Splitting Date of birth
			try {
				String newDob = theEmployee.getDob();
				String newDate[] = newDob.split("-");
				String year = newDate[0];
				String month = newDate[1];
				String day = newDate[2];
				// Setting dob to day month and year
				theEmployee.setDay(day);
				theEmployee.setMonth(month);
				theEmployee.setYear(year);
			} catch (NullPointerException e) {
				
			}
		return theEmployee;
	}
	

	@Override
	public EmployeeBean update(int id,EmployeeBean theEmployee) {
		EmployeeBean updateDetails = employeeRepository.findById(id).orElse(null);
		// Splitting Date of birth
		String year = theEmployee.getYear();
		String month = theEmployee.getMonth();
		String day = theEmployee.getDay();
		String myDob = year+"-"+month+"-"+day;
		//updating individual fields
		updateDetails.setDob(myDob);
		return employeeRepository.save(updateDetails);
		
	}

	

	

	
	
	
}
