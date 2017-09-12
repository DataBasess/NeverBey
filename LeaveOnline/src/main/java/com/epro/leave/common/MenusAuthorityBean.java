package com.epro.leave.common;

import com.epro.infrastructure.security.entity.Menu;

public class MenusAuthorityBean extends Menu{

	private static final long serialVersionUID = 1L;
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
