package com.epro.infrastructure.security.web.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.ThrowableAnalyzer;
import org.springframework.security.web.util.ThrowableCauseExtractor;
import org.springframework.web.filter.GenericFilterBean;

import com.epro.infrastructure.util.BeanUtils;


public class AjaxTimeoutRedirectFilter extends GenericFilterBean
{

	//private static final Logger logger = LoggerFactory.getLogger(AjaxTimeoutRedirectFilter.class);
	protected static Logger logger = Logger.getLogger(AjaxTimeoutRedirectFilter.class);
	private ThrowableAnalyzer throwableAnalyzer = new DefaultThrowableAnalyzer();
	private AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();

	private int customAjaxSessionExpiredErrorCode = 901;
	private int customRequestSessionExpiredErrorCode = 902;
	private int customAccessDeniedExceptionErrorCode = 903;
	
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		try
		{
			chain.doFilter(request, response);

//			logger.debug("Chain processed normally");
		}
		catch (IOException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			Throwable[] causeChain = throwableAnalyzer.determineCauseChain(ex);
			RuntimeException ase = (AuthenticationException) throwableAnalyzer.getFirstThrowableOfType(AuthenticationException.class, causeChain);

			if (ase == null)
			{
				ase = (AccessDeniedException) throwableAnalyzer.getFirstThrowableOfType(AccessDeniedException.class, causeChain);
			}

			if (ase != null)
			{
				if (ase instanceof AuthenticationException)
				{
					throw ase;
				}
				else if (ase instanceof AccessDeniedException)
				{
					logger.info("isAnonymous=:"+authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication()));
					if (authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication()))
					{
						/*HttpServletRequest req=((HttpServletRequest) request);
						Enumeration headerNames = req.getHeaderNames();
						while (headerNames.hasMoreElements()) {
							String key = (String) headerNames.nextElement();
							String value = req.getHeader(key);
							
							System.err.println("key=:"+key);
							System.err.println("value=:"+value);
							
						}*/
						logger.info("User session expired or not logged in yet");
						String ajaxHeader = ((HttpServletRequest) request).getHeader("X-Requested-With");
						
						if(BeanUtils.isEmpty(ajaxHeader)){
							ajaxHeader = ((HttpServletRequest) request).getHeader("upgrade");
						}
					
						
						logger.info("ajaxHeader=:"+ajaxHeader);
						if ("XMLHttpRequest".equals(ajaxHeader))
						{
							logger.info("Ajax call detected, send "+this.customAjaxSessionExpiredErrorCode+" error code");
							HttpServletResponse resp = (HttpServletResponse) response;
							resp.sendError(this.customAjaxSessionExpiredErrorCode);
						}else if("websocket".equals(ajaxHeader)){
							// dear test------------------เธ–เน�เธฒเน�เธกเน�เธกเธต เธ�เธฃเธฃเธ—เธฑเธ”เธ—เธตเน� commet เธ�เธตเน�  websocket เธขเธดเธ�เธฃเธฑเธงเน� เธ—เธณเน�เธซเน� server เธ•เธฒเธข
							//System.err.println("this.customAccessDeniedExceptionErrorCode=:"+this.customAccessDeniedExceptionErrorCode);
							//HttpServletResponse resp = (HttpServletResponse) response;
							//ase.printStackTrace();
							logger.info("AccessDenied websocket connection..!!");
							HttpServletResponse resp = (HttpServletResponse) response;
							resp.sendError(this.customAjaxSessionExpiredErrorCode);
							//-------------------
						}
						else
						{
							logger.info("Redirect to login page");
							
							throw ase;
						}
					}
					else
					{
						throw ase;
					}
				}
			}

		}
	}

	private static final class DefaultThrowableAnalyzer extends ThrowableAnalyzer
	{
		/**
		 * @see org.springframework.security.web.util.ThrowableAnalyzer#initExtractorMap()
		 */
		protected void initExtractorMap()
		{
			super.initExtractorMap();

			registerExtractor(ServletException.class, new ThrowableCauseExtractor()
			{
				public Throwable extractCause(Throwable throwable)
				{
					ThrowableAnalyzer.verifyThrowableHierarchy(throwable, ServletException.class);
					return ((ServletException) throwable).getRootCause();
				}
			});
		}

	}

	public void setCustomAjaxSessionExpiredErrorCode(
			int customAjaxSessionExpiredErrorCode) {
		this.customAjaxSessionExpiredErrorCode = customAjaxSessionExpiredErrorCode;
	}

	public void setCustomRequestSessionExpiredErrorCode(
			int customRequestSessionExpiredErrorCode) {
		this.customRequestSessionExpiredErrorCode = customRequestSessionExpiredErrorCode;
	}

	public void setCustomAccessDeniedExceptionErrorCode(int customAccessDeniedExceptionErrorCode) {
		this.customAccessDeniedExceptionErrorCode = customAccessDeniedExceptionErrorCode;
	}

	

}
