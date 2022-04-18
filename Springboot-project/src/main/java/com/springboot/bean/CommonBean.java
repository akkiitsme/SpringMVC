package com.springboot.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lu_generic_information")
public class CommonBean {
	
	@Id
	@Column(name="generic_info_id")
	private int genericId;
	
	@Column(name="generic_type")
	private int genericType;
	
	@Column(name="generic_value")
	private String genericVal;

	public int getGenericId() {
		return genericId;
	}

	public void setGenericId(int genericId) {
		this.genericId = genericId;
	}

	public int getGenericType() {
		return genericType;
	}

	public void setGenericType(int genericType) {
		this.genericType = genericType;
	}

	public String getGenericVal() {
		return genericVal;
	}

	public void setGenericVal(String genericVal) {
		this.genericVal = genericVal;
	}
	
	
}
