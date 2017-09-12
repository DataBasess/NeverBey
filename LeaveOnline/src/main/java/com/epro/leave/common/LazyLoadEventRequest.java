package com.epro.leave.common;

import java.util.Map;

public class LazyLoadEventRequest {
	private Integer first;
	private Integer rows;
	private String sortField;
    private Integer sortOrder;
    private SortMeta multiSortMeta;
    private Map<String,FilterMetadata> filters;
    
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public SortMeta getMultiSortMeta() {
		return multiSortMeta;
	}
	public void setMultiSortMeta(SortMeta multiSortMeta) {
		this.multiSortMeta = multiSortMeta;
	}
	public Map<String, FilterMetadata> getFilters() {
		return filters;
	}
	public void setFilters(Map<String, FilterMetadata> filters) {
		this.filters = filters;
	}
    
    
    
}
