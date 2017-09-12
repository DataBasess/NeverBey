package com.epro.infrastructure.util;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.SQLException;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

public class FileWriterUtil {
	
	public static <T> void writefile(String path,String fileName,List<String []> data,char delimiter) throws IOException, SQLException{

		//1.concat file path and file name
	    String output = path.concat(fileName);
		//2.used CSVWriter object ,set separator,not display quote in data text
	    /*Writer out = new BufferedWriter(new OutputStreamWriter(
	    	    new FileOutputStream(output), "UTF8"));
	     */
		CSVWriter writer = new CSVWriter(new FileWriter(output),delimiter,CSVWriter.NO_QUOTE_CHARACTER,"\r\n"); 
		//3.write file ,set false : write only data not include header name
		writer.writeAll(data); 
		//4.close a writer
		writer.close();

    }
	
	public static int getLineCount(String fileName) throws Exception{
		int lineCount = 0;
		File file = new File(fileName);
		if(file.exists()){
			LineNumberReader  lnr = new LineNumberReader(new FileReader(file));
			lnr.skip(Long.MAX_VALUE);
			lineCount =lnr.getLineNumber();
			lnr.close();
		}
		
		return lineCount;
	}
	
	public static String generateOutputFileName(String bussDate, String bussTime, String fileFormat, String fileType){
		return bussDate+"_"+bussTime+"_"+fileFormat+fileType;
	}
	

}
