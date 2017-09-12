package com.epro.leave.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epro.infrastructure.hibernate4.service.GenericServiceHibernate;
import com.epro.leave.dao.MenuDAO;
import com.epro.leave.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl extends GenericServiceHibernate implements MenuService {
	
	@Autowired
	private MenuDAO menuDAO;

}
