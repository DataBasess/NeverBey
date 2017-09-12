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
import com.epro.leave.entity.ParameterTableDetail;
import com.epro.leave.service.ParameterTableDetailService;

@RestController
@RequestMapping("/api/parametertabledetail")
public class ParameterTableDetailController {
	
	@Autowired
	ParameterTableDetailService parameterTableDetailService;
	
	@PostMapping("/save")
	public ResponseEntity<MessageResponse> save(@RequestBody ParameterTableDetail parameterTableDetail) {
		try {
			parameterTableDetailService.save(parameterTableDetail);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/load")
	public List<ParameterTableDetail> loadParameterTableDetail() {
		return parameterTableDetailService.findAll(ParameterTableDetail.class);
	}
	
	@PostMapping("/update")
	public ResponseEntity<MessageResponse> update(@RequestBody ParameterTableDetail parameterTableDetail) {
		try {
			parameterTableDetailService.update(parameterTableDetail);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/remove")
	public ResponseEntity<MessageResponse> deleteAll(@RequestBody List<ParameterTableDetail> list) {
		try {
			parameterTableDetailService.mergeAndRemove(list);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/loadLazy")
	public LazyLoadEventResponse<ParameterTableDetail> loadParameterTableDetailLazy(@RequestBody LazyLoadEventRequest lazyLoadEventRequest) {

		try {
			
		DetachedCriteria criteria = DetachedCriteria.forClass(ParameterTableDetail.class);
		return LazyLoadEventUtill.generateLazyLoadEventResponseByCriteria(lazyLoadEventRequest, criteria, parameterTableDetailService);
		
		}catch(Exception e) {
			return null;
		}
		
	}
	
}
