package com.epro.infrastructure.security.service;

import java.util.List;

import com.epro.leave.entity.Employee;
import com.epro.infrastructure.security.bean.MenuBean;
import com.epro.infrastructure.security.entity.Menu;
import com.epro.infrastructure.security.entity.User;

/**
 * @author Nattawut Verarattakul
 */
public interface MenuService {
	
	List<Menu> findMenuByUsername(String username);
	Employee getEmpolyeeByUserLoginName(String username);
	User getUserByUserUserLoginName(String username);
	
	List<MenuBean> checkUserAuthorizationForMenu(final String UserIdLogin);
}
