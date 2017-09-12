package com.epro.infrastructure.util;

import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static Workbook getWorkbook(String excelType, InputStream inputStream) throws Exception{
		Workbook wb;
		if(("xlsx").equalsIgnoreCase(excelType)){
			//เน�เธ�เธ� xlsx
			wb = new XSSFWorkbook(inputStream);
		}else if(("xls").equalsIgnoreCase(excelType)){
			//เน�เธ�เธ� xls
			wb = new HSSFWorkbook(inputStream);
		}else{
			throw new RuntimeException("is invalid, allowed extensions");
		}
		return wb;
	}
	public static String getCellValue(Cell cell){
		return getCellValue(cell,"String");
	}
	public static String getCellValue(Cell cell,String type){
		String value="";
		try {
		if(BeanUtils.isNotNull(cell)){
			 switch(cell.getCellType()) {
			 case Cell.CELL_TYPE_BLANK:
	             value="";
	             break;
	         case Cell.CELL_TYPE_BOOLEAN:
	             value=cell.getBooleanCellValue()+"";
	             break;
	         case Cell.CELL_TYPE_NUMERIC:
	        	 if (DateUtil.isCellDateFormatted(cell) || "date".equals(type))
	        	 {
	        	    try {
	        	     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        	     value   = sdf.format(cell.getDateCellValue());
	        	     } catch (Exception e) {
	        	    	 System.err.println(e.getMessage());
	        	    	 value="";
	        	     }
	        	 }else{
	        		 value=cell.getNumericCellValue()+"";
	        	 }
	             break;
	         case Cell.CELL_TYPE_STRING:
	             value=cell.getStringCellValue()+"";
	             break;
	         case Cell.CELL_TYPE_FORMULA: 
	        	 try {
	        		 value=cell.getStringCellValue()+"";
				} catch (Exception e) {
					 value=cell.getNumericCellValue()+"";
				}
	             break;
	         default: value="";
			 }
		}else{
			value="";
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		 return  value;
	}	
}
