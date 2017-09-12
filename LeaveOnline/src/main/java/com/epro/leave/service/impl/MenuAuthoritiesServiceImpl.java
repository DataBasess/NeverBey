package com.epro.leave.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epro.infrastructure.hibernate4.service.GenericServiceHibernate;
import com.epro.leave.dao.MenuAuthoritiesDAO;
import com.epro.leave.service.MenuAuthoritiesService;

@Service
@Transactional
public class MenuAuthoritiesServiceImpl extends GenericServiceHibernate implements MenuAuthoritiesService {
	
	@Autowired
	private MenuAuthoritiesDAO menuAuthoritiesDAO;

}
