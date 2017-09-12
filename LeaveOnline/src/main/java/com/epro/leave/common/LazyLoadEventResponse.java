package com.epro.leave.common;

import java.util.List;

public class LazyLoadEventResponse<T> {

	private Integer totalRecords;
	private List<T> listOfData;
	
	public LazyLoadEventResponse(Integer totalRecords, List<T> listOfData) {
		super();
		this.totalRecords = totalRecords;
		this.listOfData = listOfData;
	}
	
	public LazyLoadEventResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<T> getListOfData() {
		return listOfData;
	}
	public void setListOfData(List<T> listOfData) {
		this.listOfData = listOfData;
	}
}
