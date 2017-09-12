package com.epro.leave.controller.common;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.epro.leave.entity.ParameterTableDetail;
import com.epro.leave.service.DropdownService;;

@RestController
@RequestMapping("api/dropdown")
public class DropdownController {

	@Autowired
	DropdownService dropdownService;
	
	/*@PostMapping("/employee")
	public DropdownResponse getEmployee() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}*/
	
	@PostMapping("/employee")
	public List<ParameterTableDetail> getEmployeeDropdown(@RequestBody String tableCode) {
		
		List<ParameterTableDetail> listDrop = null;
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(ParameterTableDetail.class);
			criteria.add(Restrictions.eq("tableCode", tableCode));
			
			//criteria.setResultTransformer(Transformers.aliasToBean(DropdownResponse.class) );
			listDrop = dropdownService.findByCriteria(criteria);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listDrop;
	}
	


}
