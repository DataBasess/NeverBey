package com.epro.infrastructure.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Edit by Mr.Worachet Suparat.
 * @param <T>
 */
public class JQGridJSONHeaderDynamic {
	
	private GridModel gridModel = new GridModel();
	
	private List<ColModel> colModel = new ArrayList<ColModel>();
	
	private List<String> colName;
	
	private Integer maxFormRows;
	
	private Integer maxFormCols;
	
	//private List<ConfigurationUniversal> configurationUniversal=new ArrayList<ConfigurationUniversal>();;

	public Integer getMaxFormRows() {
		return maxFormRows;
	}

	public void setMaxFormRows(Integer maxFormRows) {
		this.maxFormRows = maxFormRows;
	}



	public GridModel getGridModel() {
		return gridModel;
	}

	public void setGridModel(GridModel gridModel) {
		this.gridModel = gridModel;
	}

	public List<ColModel> getColModel() {
		return colModel;
	}

	public void setColModel(List<ColModel> colModel) {
		this.colModel = colModel;
	}

	public List<String> getColName() {
		return colName;
	}

	public void setColName(List<String> colName) {
		this.colName = colName;
	}

	public Integer getMaxFormCols() {
		return maxFormCols;
	}

	public void setMaxFormCols(Integer maxFormCols) {
		this.maxFormCols = maxFormCols;
	}

//	public List<ConfigurationUniversal> getConfigurationUniversal() {
//		return configurationUniversal;
//	}
//
//	public void setConfigurationUniversal(List<ConfigurationUniversal> configurationUniversal) {
//		this.configurationUniversal = configurationUniversal;
//	}


	
	
}
