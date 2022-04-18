package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bean.CommonBean;
import com.springboot.dao.CommonBeanRepository;

@Service
public class CommonService {
	
	@Autowired
	CommonBeanRepository commonRepository;
	
	public List<CommonBean> getEmployeeDetails(int genericType){
		List<CommonBean> list = commonRepository.findByGenericType(genericType);
		return list;
		
	}
}
