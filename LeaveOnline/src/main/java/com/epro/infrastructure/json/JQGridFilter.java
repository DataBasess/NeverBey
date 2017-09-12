package com.epro.infrastructure.json;

import java.util.ArrayList;
import java.util.List;

public class JQGridFilter {

	private String source;
	private String groupOp;
	private ArrayList<JQGridRules> rules;


	public JQGridFilter() {
	super();
	}
	public JQGridFilter(String source) {
	super();
	this.source = source;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getGroupOp() {
		return groupOp;
	}
	public void setGroupOp(String groupOp) {
		this.groupOp = groupOp;
	}
	public List<JQGridRules> getRules() {
		return rules;
	}
	public void setRules(ArrayList<JQGridRules> rules) {
		this.rules = rules;
	}
	
	
}
