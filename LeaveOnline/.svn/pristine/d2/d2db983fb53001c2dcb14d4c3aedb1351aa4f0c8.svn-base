package com.epro.leave.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epro.infrastructure.hibernate4.service.GenericServiceHibernate;
import com.epro.leave.dao.EmployeeDAO;
import com.epro.leave.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl extends GenericServiceHibernate implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;
}
