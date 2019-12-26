package com.capgemini.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class EvolvedJDBCv2 
{
	public static void main(String[] args) 
	{
		FileReader reader=null;
		Properties prop=null;
		try 
		{
			reader=new FileReader("db.properties");
			prop=new Properties();
			prop.load(reader);
			
			//load the driver
			Class.forName(prop.getProperty("driverClass"));
			System.out.println("Driver is loaded");
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		try(Connection con=DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
			Statement stmt=con.createStatement();
			ResultSet rst=stmt.executeQuery(prop.getProperty("query1"));)
		{
			while(rst.next())
			{
				System.out.println("userid:-"+rst.getInt(1));
				System.out.println("username:-"+rst.getString(2));
				System.out.println("email:-"+rst.getString(3));
				System.out.println("-----------------------------");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
