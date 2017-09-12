package com.epro.leave.controller.administrator;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epro.infrastructure.security.entity.User;
import com.epro.leave.common.CommonResponse;
import com.epro.leave.common.LazyLoadEventRequest;
import com.epro.leave.common.LazyLoadEventResponse;
import com.epro.leave.common.LazyLoadEventUtill;
import com.epro.leave.common.MessageResponse;
import com.epro.leave.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/loadLazy")
	public LazyLoadEventResponse<User> load(@RequestBody LazyLoadEventRequest lazyLoadEventRequest) {
		try {
			System.out.println("===========================>"+lazyLoadEventRequest.getRows());
			DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
			return LazyLoadEventUtill.generateLazyLoadEventResponseByCriteria(lazyLoadEventRequest, criteria, userService);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/load")
	public List<User> load() {
		List<User> user = userService.findAll(User.class);
		return user;
	}
	
	@PostMapping("delete")
	public ResponseEntity<MessageResponse> removeUserManagementTable(@RequestBody List<User> userManagementTable) {
		
		try {
			System.out.println("==================================Remove=============================================");
			userService.mergeAndRemove(userManagementTable);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<MessageResponse> save(@RequestBody User value) {
		System.out.println("==================================save=============================================");
		try {
			userService.save(value);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<MessageResponse> update(@RequestBody User value) {
		System.out.println("==================================update=============================================");
		try {
			userService.update(value);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
}
