package com.epro.leave.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonResponse {
	
	public static ResponseEntity<MessageResponse> getSuccessMessageResponse(){
		HttpStatus http = HttpStatus.OK;
		MessageResponse msg = new MessageResponse(Constant.msgSeveritySuccess,Constant.msgSummarySuccess,Constant.msgDetailSuccess);
		return new ResponseEntity<MessageResponse>(msg,http);
	}
	
	public static ResponseEntity<MessageResponse> getErrorMessageResponse(Exception e){
		HttpStatus http = HttpStatus.INTERNAL_SERVER_ERROR;
		MessageResponse msg = new MessageResponse(Constant.msgSeveritySuccess,Constant.msgSummarySuccess,e.getMessage());
		return new ResponseEntity<MessageResponse>(msg,http);
	}
	
	public static ResponseEntity<MessageResponse> getErrorMessageResponse(){
		HttpStatus http = HttpStatus.INTERNAL_SERVER_ERROR;
		MessageResponse msg = new MessageResponse(Constant.msgSeverityError,Constant.msgSummaryError,Constant.msgDetailError);
		return new ResponseEntity<MessageResponse>(msg,http);
	}

}