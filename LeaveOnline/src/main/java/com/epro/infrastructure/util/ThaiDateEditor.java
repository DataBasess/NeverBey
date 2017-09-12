package com.epro.infrastructure.util;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ThaiDateEditor extends PropertyEditorSupport{
	Locale local = new Locale("th","TH");
	SimpleDateFormat format;
	public ThaiDateEditor() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public ThaiDateEditor(String pattern,boolean isLenient) {
		// TODO Auto-generated constructor stub
		//super();
		format.setLenient(isLenient);
		this.format=new SimpleDateFormat(pattern,local);
	}
	
	public void setAsText(String value) {
	      try {
	    	  System.err.println("format.parse(value)=>"+format.parse(value));
	    	  
	        setValue(format.parse(value));
	      } catch(ParseException e) {
	        setValue(null);
	        e.printStackTrace();
	      }
	}

    public String getAsText() {
      String s = "";
      System.err.println("getValue"+getValue());
      if (getValue() != null) {
         s = format.format((Date) getValue());
      }
      return s;
    }
}
