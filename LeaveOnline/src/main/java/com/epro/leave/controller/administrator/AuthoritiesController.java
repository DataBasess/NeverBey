package com.epro.leave.controller.administrator;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epro.infrastructure.security.entity.Authority;
import com.epro.leave.common.CommonResponse;
import com.epro.leave.common.LazyLoadEventRequest;
import com.epro.leave.common.LazyLoadEventResponse;
import com.epro.leave.common.LazyLoadEventUtill;
import com.epro.leave.common.MessageResponse;
import com.epro.leave.service.AuthoritiesService;

@RestController
@RequestMapping("/api/authorities")
public class AuthoritiesController {
	
	@Autowired
	private AuthoritiesService authoritiesService;
	
	/*@PostMapping("/save")
	public void save(@RequestBody Authority value) {
		authoritiesService.save(value);
	}*/
	
	@PostMapping("/save")
	public ResponseEntity<MessageResponse> save(@RequestBody Authority value) {
		System.out.println("==================================save=============================================");
		try {
			authoritiesService.save(value);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<MessageResponse> update(@RequestBody Authority value) {
		System.out.println("==================================update=============================================");
		try {
			authoritiesService.update(value);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/load")
	public List<Authority> load() {
		List<Authority> authorities = authoritiesService.findAll(Authority.class);
		return authorities;
	}
	
	@PostMapping("/loadLazy")
	public LazyLoadEventResponse<Authority> loadLazy(@RequestBody LazyLoadEventRequest lazyLoadEventRequest) {
		try {
			System.out.println("===========================>"+lazyLoadEventRequest.getRows());
			DetachedCriteria criteria = DetachedCriteria.forClass(Authority.class);
			return LazyLoadEventUtill.generateLazyLoadEventResponseByCriteria(lazyLoadEventRequest, criteria, authoritiesService);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/delete")
	public ResponseEntity<MessageResponse> removeParameterTableHeader(@RequestBody List<Authority> value) {
		
		try {
			System.out.println("==================================Remove=============================================");
			authoritiesService.mergeAndRemove(value);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	


}
