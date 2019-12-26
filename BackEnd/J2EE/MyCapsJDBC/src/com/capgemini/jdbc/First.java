package com.capgemini.jdbc;

import java.sql.*;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class First 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rst=null; 
		try
		{
			Driver drive=new com.mysql.jdbc.Driver();
			DriverManager.deregisterDriver(drive);
			
			String url="jdbc:mysql://127.0.0.1:3307/ty_cg_nov6"+"?user=root&password=root";
			con=DriverManager.getConnection(url);
			String query="select * from users_info";
			stmt=con.createStatement();
			rst=stmt.executeQuery(query);
			while(rst.next())
			{
				System.out.println(rst.getInt("userid"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
