package com.epro.infrastructure.security.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Nattawut Verarattakul
 */
public class SessionTimeoutFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        //request.getSession().setMaxInactiveInterval(request.getSession().getMaxInactiveInterval());
        request.setAttribute("sessionTimeout", request.getSession().getMaxInactiveInterval());
        
       // System.out.println("request.getSession().getMaxInactiveInterval()==>"+request.getSession().getMaxInactiveInterval());
        chain.doFilter(req, res);
        
        //System.out.println("SessionTimeoutFilter++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++%%%%%%%%%%%%%%%%%%%%%%%%");
        //System.out.println("getMaxInactiveInterval = "+request.getSession().getMaxInactiveInterval());
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }

}