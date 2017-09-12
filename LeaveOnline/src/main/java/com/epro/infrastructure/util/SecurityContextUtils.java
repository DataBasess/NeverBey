package com.epro.infrastructure.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Nattawut Verarattakul
 * @author Watsaphol Koongaew
 */
public class SecurityContextUtils {
	
	public static String getPrincipal() {
		
		Object principal = (SecurityContextHolder.getContext().getAuthentication()!=null)?SecurityContextHolder.getContext().getAuthentication().getPrincipal():null;
		String username = null;
		//================ Find Current User on Systems ===============
		if(principal!=null)
		{
			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			} else {
				username = principal.toString();
			}
		}
		
		return username;
	}
	
	@SuppressWarnings("unchecked")
	public static Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		return authorities;
	}

}
