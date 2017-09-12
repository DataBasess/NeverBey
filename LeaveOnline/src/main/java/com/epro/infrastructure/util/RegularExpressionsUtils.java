package com.epro.infrastructure.util;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author Vip Klaywong
 */
public class RegularExpressionsUtils {
	
	public static boolean isNumber(String number){
		ExpressionParser parser = new SpelExpressionParser();
		boolean result = false;
		if(parser.parseExpression("'" + number + "' matches '\\d'").getValue(Boolean.class) == true){
			result = true;
		}
		return result;
	}
	
}
