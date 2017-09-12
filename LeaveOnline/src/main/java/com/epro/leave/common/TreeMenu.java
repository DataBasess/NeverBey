package com.epro.leave.common;

import java.util.ArrayList;

import com.epro.infrastructure.security.entity.Menu;

public class TreeMenu {
	
	public    String label;
	public    Menu data;
	public    String expandedIcon="fa-folder-open";
	public    String collapsedIcon="fa-folder";
	public	  Boolean selectable;
	public	  Boolean metaKeySelection;
	public	  Boolean checked;
	public  ArrayList<TreeMenu> children =new ArrayList<TreeMenu>();
	
	
	
	
	
	
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Boolean getMetaKeySelection() {
		return metaKeySelection;
	}
	public void setMetaKeySelection(Boolean metaKeySelection) {
		this.metaKeySelection = metaKeySelection;
	}
	public Boolean getSelectable() {
		return selectable;
	}
	public void setSelectable(Boolean selectable) {
		this.selectable = selectable;
	}
	public ArrayList<TreeMenu> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<TreeMenu> children) {
		this.children = children;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Menu getData() {
		return data;
	}
	public void setData(Menu data) {
		this.data = data;
	}
	public String getExpandedIcon() {
		return expandedIcon;
	}
	public void setExpandedIcon(String expandedIcon) {
		this.expandedIcon = expandedIcon;
	}
	public String getCollapsedIcon() {
		return collapsedIcon;
	}
	public void setCollapsedIcon(String collapsedIcon) {
		this.collapsedIcon = collapsedIcon;
	}

}
