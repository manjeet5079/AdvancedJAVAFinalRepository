package com.praveen.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBFactory {
	public static Connection getConnection(){
		String driverClass="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Praveen";
		String user="root";
		String password="";
		Connection con=null;
		try {
			Class.forName(driverClass);
			con=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	} 

}
