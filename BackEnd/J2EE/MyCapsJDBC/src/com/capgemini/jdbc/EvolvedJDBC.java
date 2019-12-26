package com.capgemini.jdbc;


import java.sql.*;
import java.util.Scanner;

public class EvolvedJDBC 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		String url="jdbc:mysql://127.0.0.1:3307/ty_cg_nov6";
		System.out.println("enter the user name");
		String user=in.nextLine();
		System.out.println("enter the password");
		String pass=in.nextLine();
		String query="select * from users_info";
		try(Connection conn=DriverManager.getConnection(url,user,pass);
				Statement stmt=conn.createStatement();
				ResultSet rst=stmt.executeQuery(query))
				{
			while(rst.next())
			{
				System.out.println(rst.getInt(1));
				System.out.println(rst.getString(2));
			}
			
		}
		catch(Exception e)
		{
			
		}
		
	}
}
