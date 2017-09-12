package com.epro.leave.controller.master;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

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
import com.epro.leave.entity.Employee;
import com.epro.leave.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<MessageResponse> saveParameterTableHeader(@RequestBody Employee employee) {

		try {
			employeeService.save(employee);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponse.getErrorMessageResponse();
		}
	}

	@PostMapping("/update")
	public ResponseEntity<MessageResponse> updateParameterTableHeader(@RequestBody Employee employee) {

		try {
			employeeService.update(employee);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponse.getErrorMessageResponse(e);
		}
	}

	@PostMapping("/remove")
	public ResponseEntity<MessageResponse> removeParameterTableHeader(@RequestBody List<Employee> employee) {

		try {
			System.out.println("==================================Remove=============================================");
			employeeService.mergeAndRemove(employee);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponse.getErrorMessageResponse(e);
		}
	}

	@PostMapping("/load")
	public List<Employee> findEmployee() {
		List<Employee> empList = employeeService.findAll(Employee.class);
		return empList;

	}

	@PostMapping("/loadLazyEmployeeForLOV")
	public LazyLoadEventResponse<Employee> loadLazyEmployeeForLOV(
			@RequestBody LazyLoadEventRequest lazyLoadEventRequest) {

		try {
			DetachedCriteria criteriaUser = DetachedCriteria.forClass(User.class, "user");
			criteriaUser.add(Restrictions.eqProperty("employeeObjectemployeeId.employeeId", "employee.employeeId"));
			criteriaUser.setProjection(Projections.property("employeeObjectemployeeId.employeeId"));

			DetachedCriteria criteriaEmployee = DetachedCriteria.forClass(Employee.class, "employee");
			criteriaEmployee.createAlias("employeePrefix", "employeePrefix");
			criteriaEmployee.createAlias("causeOfResign", "causeOfResign");
			criteriaEmployee.createAlias("employeePosition", "employeePosition");
			criteriaEmployee.createAlias("employeeDepartment", "employeeDepartment");
			criteriaEmployee.add(Subqueries.propertyNotIn("employee.employeeId", criteriaUser));
			
			return LazyLoadEventUtill.generateLazyLoadEventResponseByCriteria(lazyLoadEventRequest, criteriaEmployee,
					employeeService);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@PostMapping("/loadLazy")
	public LazyLoadEventResponse<Employee> loadEmployee(@RequestBody LazyLoadEventRequest lazyLoadEventRequest) {

		try {
			System.out.println("===========================>" + lazyLoadEventRequest.getRows());
			DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
			criteria.createAlias("employeePrefix", "employeePrefix");
			criteria.createAlias("causeOfResign", "causeOfResign");
			criteria.createAlias("employeePosition", "employeePosition");
			criteria.createAlias("employeeDepartment", "employeeDepartment");

			return LazyLoadEventUtill.generateLazyLoadEventResponseByCriteria(lazyLoadEventRequest, criteria,
					employeeService);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}
}
