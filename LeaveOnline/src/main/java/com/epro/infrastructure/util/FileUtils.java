package com.epro.infrastructure.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

public class FileUtils {
	protected static Logger logger = Logger.getLogger(FileUtils.class);
	// dear edit for support copy all file in folder.
		public static void copyFile(String pathFrom,String pathTo)throws Exception{
			InputStream inputStream= null;
			OutputStream  outputStream=null;
			try {
				
			
				File from =new File(pathFrom);
				File to =new File(pathTo);
				
//				if(!to.exists()){
//					if(to.isDirectory()){
//						to.mkdir();
//					}
//				}
				
				//OutputStream out=new FileOutputStream(new File("\\\\10.28.45.80\\share\\myFile.txt"));  
				
				
				if(from.exists()){
					if(from.isDirectory()){
						
						 File[] listOfFiles = from.listFiles();
					      
					        for(File file : listOfFiles){
					        	logger.debug(pathFrom+file.getName()+"===>"+pathTo+file.getName());
					        	copyFile(pathFrom+file.getName(),pathTo+file.getName());
					        } 
					}else{

						//File dirPath = new File(String.valueOf(pathTo.substring(0,pathTo.lastIndexOf("/"))));
						File dirPath = new File(BeanUtils.cutLastBySymbol("/",pathTo));
						if(!dirPath.exists()){
							dirPath.mkdirs();
						}
						
						inputStream  = new FileInputStream(from);

//						NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication("softsquaregroup.com", "worachet_s", "Pa$$w0rd"); // replace with actual values 
//						
//						SmbFile fileAuthentication = new SmbFile("smb:\\\\172.16.150.6\\CAT\\Text.text", authentication); // note the different format  
//						
//						System.out.println("fileAuthentication==>"+fileAuthentication);
//						outputStream = fileAuthentication.getOutputStream(); 
						
						
						outputStream  = new FileOutputStream(to);
						byte[] buffer = new byte[1024];
						int length;
						while ((length = inputStream.read(buffer)) > 0){
							outputStream.write(buffer, 0, length);
					    }
						
					}
				}else{
					logger.error("file not found.");
				}

				
			
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
				throw e;
			}finally{
				if(inputStream!=null) {
					inputStream.close();
				}
				if(outputStream!=null){
					outputStream.close();
				}
			}
		}
		
		
		
}
