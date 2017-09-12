package com.epro.infrastructure.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Nattawut Verarattakul
 */
public class ExceptionUtils {
	
	public static String readStackTrace(Exception e) {
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    e.printStackTrace(pw);
	    return sw.toString();
	}
	
}
