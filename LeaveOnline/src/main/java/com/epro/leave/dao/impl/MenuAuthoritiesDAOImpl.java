package com.epro.leave.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.epro.infrastructure.hibernate4.dao.GenericDaoHibernate;
import com.epro.leave.dao.MenuAuthoritiesDAO;

@Component
public class MenuAuthoritiesDAOImpl extends GenericDaoHibernate implements MenuAuthoritiesDAO {

	public MenuAuthoritiesDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
