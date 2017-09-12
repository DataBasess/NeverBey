package com.epro.infrastructure.json;

import java.util.List;
import java.util.Map;

/**
 * @author Edit by Mr.Worachet Suparat.
 * @param <T>
 */
public class JQGridJSONReaderDynamic {
	
	private Integer page;
	
	private Integer total;
	
	private Long records;
	
	private Map<String,String> userdata;
	
	private List<Map<String,Object>> rows;
	
//	private GridModel gridModel = new GridModel();
//	
//	private List<ColModel> colModel = new ArrayList<ColModel>();
//	
//	private List<String> colName; 
	
	
//	public GridModel getGridModel() {
//		return gridModel;
//	}
//
//	public void setGridModel(GridModel gridModel) {
//		this.gridModel = gridModel;
//	}



	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Long getRecords() {
		return records;
	}

	public void setRecords(Long records) {
		this.records = records;
	}

	public Map<String, String> getUserdata() {
		return userdata;
	}

	public void setUserdata(Map<String, String> userdata) {
		this.userdata = userdata;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> requestProductMap) {
		this.rows = requestProductMap;
	}

//	public List<String> getColName() {
//		return colName;
//	}
//
//	public void setColName(List<String> colName) {
//		this.colName = colName;
//	}
//
//	public List<ColModel> getColModel() {
//		return colModel;
//	}
//
//	public void setColModel(List<ColModel> colModel) {
//		this.colModel = colModel;
//	}

}
