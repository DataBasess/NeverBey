package com.epro.leave.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.epro.infrastructure.hibernate4.dao.GenericDaoHibernate;
import com.epro.leave.dao.UserDAO;

@Component
public class UserDAOImpl extends GenericDaoHibernate implements UserDAO {

	public UserDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
