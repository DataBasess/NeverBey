package com.epro.infrastructure.json;

import java.util.ArrayList;
import java.util.List;

public class StatusResponse {
	 
	private Boolean success;
	private String status;
	private List<String> message;
	private Object objectJson;
	
	public StatusResponse() {
		this.message = new ArrayList<String>();
	}
	public StatusResponse(Boolean success) {
		super();
		this.success = success;
		this.message = new ArrayList<String>();
	}
	public StatusResponse(Boolean success, String message) {
		super();
		this.success = success;
		this.message = new ArrayList<String>();
		this.message.add(message);
	}
	public StatusResponse(Boolean success, List<String> message) {
		super();
		this.success = success;
		this.message = message;
	}
	

	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String mess: message) {
		sb.append(mess +", ");
		}
		return "StatusResponse [success=" + success + ", message=" + sb.toString()
		+ "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getObjectJson() {
		return objectJson;
	}
	public void setObjectJson(Object objectJson) {
		this.objectJson = objectJson;
	}
	
}
