package com.epro.infrastructure.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.HibernateException;
/*
import jdk.nashorn.internal.ir.annotations.Ignore;*/

public class BeanUtils {

	public static void wrapperClass(Object objOld, Object objNew) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		for(Field field:objOld.getClass().getDeclaredFields())
		{   
			if(!"serialVersionUID".equals(field.getName()))
			{
				Object objFiled=PropertyUtils.getProperty(objOld, field.getName());
		    
				if(objFiled!=null)
				{
					if(PropertyUtils.isWriteable(objNew, field.getName()))
					{
						PropertyUtils.setProperty(objNew, field.getName(), objFiled);
					}
				}
			}
		}
	}
	
	
	public static void wrapperToClass(Object objOld, Object objNew) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		for(Field field:objNew.getClass().getDeclaredFields())
		{   
			if(!"serialVersionUID".equals(field.getName()))
			{
				Object objFiled=PropertyUtils.getProperty(objOld, field.getName());
		    
				if(objFiled!=null)
				{
					if(PropertyUtils.isWriteable(objNew, field.getName()))
					{
						PropertyUtils.setProperty(objNew, field.getName(), objFiled);
					}
				}
			}
		}
		
	}
	
	public static void wrapperToClassAndIgnore(Object objOld, Object objNew) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		for(Field field:objNew.getClass().getDeclaredFields())
		{   
			try {
				if(!"serialVersionUID".equals(field.getName()))
				{
					Object objFiled=PropertyUtils.getProperty(objOld, field.getName());
			    
					if(objFiled!=null)
					{
						if(PropertyUtils.isWriteable(objNew, field.getName()))
						{
							PropertyUtils.setProperty(objNew, field.getName(), objFiled);
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				//e.printStackTrace();
				//ignore exception
			}
			
		}
		
	}

	public static boolean isEmpty(String st) {
		boolean b = true;
		if (st != null && st.trim().length() > 0) {
			b = false;
		}
		return (b);
	}

	public static boolean isEmpty(StringBuilder st) {
		boolean b = true;
		if (st != null && st.toString().trim().length() > 0) {
			b = false;
		}
		return (b);
	}

	public static boolean isEmpty(List<?> ls) {
		boolean b = true;
		if (ls != null && !ls.isEmpty()) {
			b = false;
		}
		return (b);
	}

	public static boolean isEmpty(Map<?, ?> map) {
		boolean b = true;
		if (map != null && !map.isEmpty()) {
			b = false;
		}
		return (b);
	}

	public static boolean isEmpty(Integer integer) {
		boolean b = isNull(integer);
		return (b);
	}

	public static boolean isEmpty(Byte byt) {
		boolean b = isNull(byt);
		return (b);
	}

	public static boolean isEmpty(Short s) {
		boolean b = isNull(s);
		return (b);
	}

	public static boolean isEmpty(Long l) {
		boolean b = isNull(l);
		return (b);
	}

	public static boolean isEmpty(Character c) {
		boolean b = isNull(c);
		return (b);
	}

	public static boolean isEmpty(Float f) {
		boolean b = isNull(f);
		return (b);
	}

	public static boolean isEmpty(Double d) {
		boolean b = isNull(d);
		return (b);
	}

	public static boolean isEmpty(Number num) {
		boolean b = isNull(num);
		return (b);
	}

	public static boolean isEmpty(BigDecimal d) {
		boolean b = isNull(d);
		return (b);
	}

	public static boolean isNull(Object obj) {
		boolean b = true;
		if (obj != null) {
			b = false;
		}
		
		
		return (b);
	}

	public static Object getDefaultValueIfNull(Object value, Object defaultValue) {
		Object result = defaultValue;
		

		if (value != null) {
			result = value;
		}
		return (result);
	}
	
	public static <T>  T getDefaultValueIfNull(T value) {
		T result = null;
		if (value != null) {
			result = value;
		}
		return  (result);
	}
	
	
	
	public static Integer convertBigDecimalToIntegerDefaultNull(BigDecimal value) {
		Integer result = null;
		if (value != null) {
			result = value.intValue();
		}
		return  (result);
	}

	public static boolean isNotEmpty(String st) {
		boolean b = true;
		if (st == null || st.trim().length() == 0) {
			b = false;
		}
		return (b);
	}

	public static boolean isNotEmpty(List<?> ls) {
		boolean b = false;
		if (ls != null && !ls.isEmpty()) {
			b = true;
		}
		return (b);
	}

	public static boolean isNotEmpty(Set<?> set) {
		boolean b = false;
		if (set != null && !set.isEmpty()) {
			b = true;
		}
		return (b);
	}

	public static boolean isNotEmpty(Map<?, ?> map) {
		boolean b = false;
		if (map != null && !map.isEmpty()) {
			b = true;
		}
		return (b);
	}

	public static boolean isNotEmpty(Integer integer) {
		boolean b = isNotNull(integer);
		return (b);
	}

	public static boolean isNotEmpty(Byte byt) {
		boolean b = isNotNull(byt);
		return (b);
	}

	public static boolean isNotEmpty(Short s) {
		boolean b = isNotNull(s);
		return (b);
	}

	public static boolean isNotEmpty(Long l) {
		boolean b = isNotNull(l);
		return (b);
	}

	public static boolean isNotEmpty(Character c) {
		boolean b = isNotNull(c);
		return (b);
	}

	public static boolean isNotEmpty(Float f) {
		boolean b = isNotNull(f);
		return (b);
	}

	public static boolean isNotEmpty(Double d) {
		boolean b = isNotNull(d);
		return (b);
	}

	public static boolean isNotEmpty(Number num) {
		boolean b = isNotNull(num);
		return (b);
	}

	public static boolean isNotEmpty(BigDecimal d) {
		boolean b = isNotNull(d);
		return (b);
	}

	public static boolean isNotEmpty(Object obj) {
		boolean b = false;
		if (obj != null) {
			b = true;
		}
		return (b);
	}

	public static boolean isNotNull(Object obj) {
		boolean b = false;
		if (obj != null) {
			b = true;
		}
		return (b);
	}

	public static Object cloneObject(Object obj)
	{
		try
		{
			ByteArrayOutputStream baOutStream = new ByteArrayOutputStream();
			ObjectOutputStream objOutStream = new ObjectOutputStream(baOutStream);
			objOutStream.writeObject(obj);
			objOutStream.flush();
			objOutStream.close();
		
			ByteArrayInputStream baInStream = new ByteArrayInputStream(baOutStream.toByteArray());
			ObjectInputStream objInStream = new ObjectInputStream(baInStream);
			Object copyObj = (Object)objInStream.readObject();
			objInStream.close();
			
			return copyObj;
		}
		catch(Throwable t)
		{
			throw new HibernateException(t);
		}
	}
	
	
	public static String[] removeItemFromArray(String[] input, String item) {
		if (input == null) {
		    return null;
		} else if (input.length <= 0) {
		    return input;
		} else {
			String[] output = new String[input.length - 1];
		    int count = 0;
		    for (String i : input) {
		        if (!i.equals(item)) {
		            output[count++] = i;
		        }
		    }
		    return output;
		}
	}
	
	public static String addSpaces(String value,int numSpace){

		return  String.format("%-"+numSpace+"s", value);
	}
	
	public static String addSpacesWithBySize(String value,int numSize){
		value=addSpaces(value, numSize);
		if(isNotEmpty(value) && value.length()>=numSize){
			return value.substring(0, numSize);
		}else{
			return value;
		}
	}
	
	public static String ifNullIsEmpty(String value) {
		String result = "";
		if (BeanUtils.isNotNull(value)) {
			result = value;
		}
		return  (result);
	}
	
	public static String ifEmptyIsNull(String value) {
		String result = null;
		if (BeanUtils.isNotEmpty(value)) {
			result = value;
		}
		return  (result);
	}

	// BeanUtils.sortingArrayList(list, new CustomerSurveySiteBean(), "taskID"); --> Result : Order by taskID asec
	public static void sortingArrayList(List<?> list, Object obj, String columnName) {
		Collections.sort(list, new SortingArrayList(obj, columnName));
	}
	
	// BeanUtils.cutLastBySymbol("/", "aaa/bbb/ccc/image.jpg"); --> Result : aaa/bbb/ccc/
	public static String cutLastBySymbol(String symbol,String data){
		
		String[] array =data.split(symbol); 
		data = data.replace(array[array.length-1],"" );
		return data;
	}
	
	public static String numberToStringZero(int number){

		String numberString = number<10?"0"+number:number+"";
		
		return numberString;
	}
	
	public static String ifFirstStringIsNotNullGetFirstString(String firstString,String secondString){
		return BeanUtils.isNotNull(firstString)?firstString:secondString;
	}
	
	
	public static void setPropertyVale(Object entity, String prop, Object value) {
	    if (PropertyUtils.isWriteable(entity, prop)) {
	        try {
	            PropertyUtils.setProperty(entity, prop, value);
	        } catch (IllegalAccessException e) {
	            //logger.warn("Add property ", e);
	        	e.printStackTrace();
	        } catch (InvocationTargetException e) {
	           // logger.warn("Add property ", e);
	        	e.printStackTrace();
	        } catch (NoSuchMethodException e) {
	           // logger.warn("Add property ", e);
	        	e.printStackTrace();
	        }
	    }
	}
	
	public static Object getPropertyVale(Object entity, String prop) {
		Object value = null;
	    //if (PropertyUtils.isWriteable(entity, prop)) {
	        try {
	        	value= PropertyUtils.getProperty(entity, prop);
	            
	        } catch (IllegalAccessException e) {
	            //logger.warn("Add property ", e);
	        	e.printStackTrace();
	        } catch (InvocationTargetException e) {
	           // logger.warn("Add property ", e);
	        	e.printStackTrace();
	        } catch (NoSuchMethodException e) {
	           // logger.warn("Add property ", e);
	        	e.printStackTrace();
	        }
	  //  }
		return value;
	}
	
	// เน€เธญเธฒเน�เธงเน�เธซเธฒ เธ�เธทเน�เธญ column เธ—เธตเน�เธญเธขเธนเน�เน�เธ� database เธ�เธฒเธ� เธ�เธทเน�เธญเธ•เธฑเธงเน�เธ�เธฃ
	public static String getColumnNameDB(Class<?> entityClass,String name){
		
		try {
				Field field = entityClass.getDeclaredField(name);
				
				Annotation annotation = field.getAnnotation(Column.class);
				if(annotation instanceof Column){
					Column columnAnnotation = (Column) annotation;
				    return columnAnnotation.name();
				}	
	            
        } catch (Exception e) {
        	 try { // for find in super class.
	        	Class<?> subperClass = entityClass.getSuperclass();
	        	Field fieldSuperClass = subperClass.getDeclaredField(name);
	    		Annotation annotationSuperClass = fieldSuperClass.getAnnotation(Column.class);
	    		if(annotationSuperClass instanceof Column){
	    			Column columnAnnotation = (Column) annotationSuperClass;
	    		    return columnAnnotation.name();
	    		}
        	 } catch (Exception ex) {
        		 return null;	
        	 }
        }
		return null;
	}
	
	public static String pad (String str, int max) {
		  str = str.toString();
		  return str.length() < max ? pad("0" + str, max) : str;
	}
	
}
