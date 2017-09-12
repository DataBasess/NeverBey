package com.epro.leave.controller.administrator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epro.infrastructure.security.entity.Authority;
import com.epro.infrastructure.security.entity.Menu;
import com.epro.infrastructure.security.entity.MenuAuthority;
import com.epro.leave.common.CommonResponse;
import com.epro.leave.common.MessageResponse;
import com.epro.leave.service.MenuAuthoritiesService;

@RestController
@RequestMapping("/api/MenuAuthorities")
public class MenuAuthoritiesController {
	
	@Autowired
	MenuAuthoritiesService menuAuthoritiesService;
	
	
	
	
	@RequestMapping(value="/Test")
	public void  saveMenuAuthorities() {

		
		
		
		
		Authority authorities = menuAuthoritiesService.get(Authority.class,1);
		System.out.println(authorities.getAuthorityId());
		Menu menus = menuAuthoritiesService.get(Menu.class, 4);
		System.out.println(menus.getId());
		
		MenuAuthority menuAuthority = new MenuAuthority();
		
		menuAuthority.setAuthorities(authorities);
		menuAuthority.setMenus(menus);
		
		
		
		menuAuthoritiesService.save(menuAuthority);
				
	}
	
	@PostMapping("/save")
	public   ResponseEntity<MessageResponse> save(@RequestBody MenuAuthority menuAuthority) {
		
		try {
			
			
			
			System.out.println(menuAuthority.getAuthorities().getAuthorityId());
			System.out.println(menuAuthority.getMenus().getId());
			menuAuthoritiesService.save(menuAuthority);
			return CommonResponse.getSuccessMessageResponse();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<MessageResponse> update(@RequestBody MenuAuthority menuAuthority) {
		try {
			menuAuthoritiesService.update(menuAuthority);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/delete")
	public ResponseEntity<MessageResponse> deleteAll(@RequestBody List<MenuAuthority> menuAuthority) {
		try {
			menuAuthoritiesService.mergeAndRemove(menuAuthority);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/loadAll")
	@RequestMapping(value="/loadAll")
	public List<MenuAuthority> load() {
		List<MenuAuthority> menuAuthority = menuAuthoritiesService.findAll(MenuAuthority.class);
		return menuAuthority;
	}
	
	
	

}
