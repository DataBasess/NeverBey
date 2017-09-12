package com.epro.leave.controller.master;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epro.infrastructure.json.TreeJSONReader;
import com.epro.infrastructure.security.entity.Menu;
import com.epro.infrastructure.util.BeanUtils;
import com.epro.leave.service.EmployeeService;

@RestController
public class ApiController {
	
	@Autowired
	EmployeeService employeeService;
	
	 @RequestMapping("/api/hello")
	 public String greet() {
		 return "Hello from the other side!!!";
	 }
	 
	 @RequestMapping(value="/test/menu")
	 public List<TreeJSONReader> loadmenu() {
		 List<Menu> menuAll = null;
		 List<TreeJSONReader> treeGrand = new ArrayList<TreeJSONReader>();
		 try {
			menuAll = employeeService.findAll(Menu.class);
			List<Menu> menuGrandFilter = menuAll.stream().filter(m -> m.getLink().equals("#") && BeanUtils.isNull(m.getParent()))
								.collect(Collectors.toList());
			
			for(Menu menuGrand : menuGrandFilter) {
				TreeJSONReader grand = new TreeJSONReader();
				grand.setTitle(menuGrand.getName());

				treeGrand.add(ApiController.loadChildren(menuAll, grand, menuGrand.getId()));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		 return treeGrand;
	 }
	 
	 public static TreeJSONReader loadChildren(List<Menu> menuAll,TreeJSONReader grand,Integer menuGrandId){
		 try {
			List<Menu> motherNotNullGrand = menuAll.stream().filter( m -> BeanUtils.isNotNull(m.getParent()) ).collect(Collectors.toList());
			List<Menu> mothers = motherNotNullGrand.stream().filter(m -> m.getParent().getId() == menuGrandId).collect(Collectors.toList());
			
			if(BeanUtils.isNotEmpty(mothers)) {
				for(Menu menuMother : mothers) {
					TreeJSONReader mother = new TreeJSONReader();
					mother.setTitle(menuMother.getName());
					grand.getChildren().add(mother);
					
					ApiController.loadChildren(menuAll, mother, menuMother.getId());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		 
		 return grand;
	 }
	 
}
