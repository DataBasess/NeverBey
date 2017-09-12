package com.epro.infrastructure.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHelper
{
	private static String user;// = "postgres";
	private static String password;// = "1234";
	private static ConnectionHelper instance;
	private static String url;// = "jdbc:postgresql://localhost/wdpoc";

	private ConnectionHelper()
	{
		try {
			
			
//			// * ===========  Get connection from tnsname ==========
				Properties props = new Properties();
				props.load(this.getClass().getClassLoader().getResourceAsStream("hibernate.properties"));
				url = props.getProperty("jdbc.url");
				user = props.getProperty("jdbc.username");
//				BasicTextEncryptor textEncryptor  = new BasicTextEncryptor();
//				textEncryptor.setPassword("ePro");
				password = props.getProperty("jdbc.password");
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = new ConnectionHelper();
		}
		try {
			/*
			 * ===========  Get connection from tnsname ==========
			 *  */
			
            return DriverManager.getConnection(url, user, password);
           

		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static void close(Connection connection)
	{
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection connection)
	{
		try {
			if (connection != null && !connection.isClosed()) {
				if(!connection.getAutoCommit()){
					connection.rollback();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}