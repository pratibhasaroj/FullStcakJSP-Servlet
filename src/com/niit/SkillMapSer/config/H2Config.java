package com.niit.SkillMapSer.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class H2Config {
	
	public static Connection getConnection()
	{
		Connection conn=null;
		try {
			Class.forName("org.h2.Driver");
			String url="jdbc:h2:tcp://localhost/~/SkillMap";
			String user="sa";
			String password="";
			conn =DriverManager.getConnection(url, user, password);
			}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return conn;
		
	}

}
