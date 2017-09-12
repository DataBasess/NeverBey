package com.epro.leave.controller.master;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epro.leave.common.CommonResponse;
import com.epro.leave.common.LazyLoadEventRequest;
import com.epro.leave.common.LazyLoadEventResponse;
import com.epro.leave.common.LazyLoadEventUtill;
import com.epro.leave.common.MessageResponse;
import com.epro.leave.entity.ParameterTableHeader;
import com.epro.leave.service.ParameterTableHeaderService;

@RestController
@RequestMapping("/api/parameterTableHeader")
public class ParameterTableHeaderController {
	
	@Autowired
	ParameterTableHeaderService parameterTableHeaderService;
	
	@PostMapping("/load")
	public List<ParameterTableHeader> loadParameterTableHeader() {
		return parameterTableHeaderService.findAll(ParameterTableHeader.class);
	}
	
	@PostMapping("/save")
	public ResponseEntity<MessageResponse> saveParameterTableHeader(@RequestBody ParameterTableHeader parameterTableHeader) {
		
		try {
			parameterTableHeaderService.save(parameterTableHeader);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponse.getErrorMessageResponse();
		}
	}
	
	@PostMapping("update")
	public ResponseEntity<MessageResponse> updateParameterTableHeader(@RequestBody ParameterTableHeader parameterTableHeader) {
		
		try {
			parameterTableHeaderService.update(parameterTableHeader);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("remove")
	public ResponseEntity<MessageResponse> removeParameterTableHeader(@RequestBody List<ParameterTableHeader> parameterTableHeaders) {
		
		try {
			System.out.println("==================================Remove=============================================");
			parameterTableHeaderService.mergeAndRemove(parameterTableHeaders);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/loadLazy")
	public LazyLoadEventResponse<ParameterTableHeader> loadParameterTableHeaderLazy(@RequestBody LazyLoadEventRequest lazyLoadEventRequest) {
		
		try {
			System.out.println("===========================>"+lazyLoadEventRequest.getRows());
			DetachedCriteria criteria = DetachedCriteria.forClass(ParameterTableHeader.class);
			
			return LazyLoadEventUtill.generateLazyLoadEventResponseByCriteria(lazyLoadEventRequest, criteria, parameterTableHeaderService);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
