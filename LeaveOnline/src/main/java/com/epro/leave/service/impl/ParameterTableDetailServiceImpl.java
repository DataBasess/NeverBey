package com.epro.leave.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epro.infrastructure.hibernate4.service.GenericServiceHibernate;
import com.epro.leave.dao.ParameterTableDetailDAO;
import com.epro.leave.service.ParameterTableDetailService;

@Service
@Transactional
public class ParameterTableDetailServiceImpl extends GenericServiceHibernate implements ParameterTableDetailService {
	@Autowired
	private ParameterTableDetailDAO parameterTableDetailDAO;
}
