package com.epro.infrastructure.util;

import java.util.Comparator;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author Watsaphol Koongaew
 */

public class SortingArrayList implements Comparator<Object> {
	
	private String colName = "";
	
	public SortingArrayList(Object obj, String columnName)
	{
		this.colName = columnName;
		compare(obj,obj);
	}
	
    @Override
    public int compare(Object o1, Object o2) 
    {
    	try 
    	{
			Object obj1 = PropertyUtils.getProperty(o1, this.colName);
			Object obj2 = PropertyUtils.getProperty(o2, this.colName);
			
			if(obj1!=null && obj2!=null)
			{
				if(obj1 instanceof Integer)
				{
					Integer int1 = Integer.parseInt(obj1.toString());
					Integer int2 = Integer.parseInt(obj2.toString());
					return int1.compareTo(int2);
				}
				else
				{
					return obj1.toString().compareTo(obj2.toString());
				}
			}
			else
			{
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
    }
}