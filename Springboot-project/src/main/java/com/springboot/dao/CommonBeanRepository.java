package com.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bean.CommonBean;

@Repository
public interface CommonBeanRepository extends JpaRepository<CommonBean,Integer> {
	
	public List<CommonBean> findByGenericType(int genericType);
	
	public String findByGenericValAndGenericType(String genericVal,int genericType);
}
