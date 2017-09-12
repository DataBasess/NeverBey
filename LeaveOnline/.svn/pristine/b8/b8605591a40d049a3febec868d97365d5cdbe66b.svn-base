package com.epro.infrastructure.json;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Mr.Worachet Suparat.
 * @param <T>
 */
public class TreeJSONReader {
	private String key;
	private String title;
	private Boolean isFolder = false;
	private Boolean select=false;
	private Boolean expand= true; 
	private List<TreeJSONReader> children;	
	
	
	
	
	public Boolean getExpand() {
		return expand;
	}
	public void setExpand(Boolean expand) {
		this.expand = expand;
	}
	public Boolean getSelect() {
		return select;
	}
	public void setSelect(Boolean select) {
		this.select = select;
	}
	

	public TreeJSONReader(){
		 children =  new ArrayList<TreeJSONReader>();
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getIsFolder() {
		return isFolder;
	}
	public void setIsFolder(Boolean isFolder) {
		this.isFolder = isFolder;
	}
	public List<TreeJSONReader> getChildren() {
		return children;
	}
	public void setChildren(List<TreeJSONReader> children) {
		this.children = children;
	}
	
}
