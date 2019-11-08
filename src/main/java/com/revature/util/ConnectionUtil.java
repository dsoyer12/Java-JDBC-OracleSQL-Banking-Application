package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnection(String filename) throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("src\\main\\java\\connection.properties");
		prop.load(in);
		// need to provide: url to db, username, password
		// read in the contents of a properties file
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

//	public static Connection getConnection() throws SQLException, IOException {
//		// read in contents of a properties file - NEVER want to hardcode credentials
//		Properties prop = new Properties();
//		//InputStream in = new FileInputStream("connection.properties");
//		prop.load(connectionUtil.class.getClassLoader().getResourceAsStream("src\\main\\java\\connection.properties"));
//		// need to provide: url to the database, username, password
//		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
//				prop.getProperty("password"));
//	}
}
