package com.epro.leave.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epro.infrastructure.hibernate4.service.GenericServiceHibernate;
import com.epro.leave.dao.AuthoritiesDAO;
import com.epro.leave.dao.UserDAO;
import com.epro.leave.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends GenericServiceHibernate implements UserService {

	@Autowired
	private UserDAO userDAO;
}
