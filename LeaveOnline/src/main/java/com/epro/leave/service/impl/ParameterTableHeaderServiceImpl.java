package com.epro.leave.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epro.infrastructure.hibernate4.service.GenericServiceHibernate;
import com.epro.leave.dao.ParameterTableHeaderDAO;
import com.epro.leave.service.ParameterTableHeaderService;

@Service
@Transactional
public class ParameterTableHeaderServiceImpl extends GenericServiceHibernate implements ParameterTableHeaderService {

	@Autowired
	private ParameterTableHeaderDAO parameterTableHeaderDAO;
}
