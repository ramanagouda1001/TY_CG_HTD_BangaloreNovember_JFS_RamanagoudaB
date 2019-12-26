package com.capgemini.jdbc;

import java.sql.*;
import java.util.Scanner;

public class UserLogin 
{
	public static void main(String[] args) 
	{
		Connection con=null;// its a interface and it is presert in java.sql package
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		Scanner in=new Scanner(System.in);//load the driver
		try 
		{
			Driver drive=new com.mysql.jdbc.Driver();//Drive should be interface
			DriverManager.registerDriver(drive);// static 
			System.out.println("Driver is loaded");
			
			//get the db connection
			//String sql="jdbc:mysql://localhost:3307/ty_cg_nov6";
			String sql="jdbc:mysql://127.0.0.1:3307/ty_cg_nov6";
			
			System.out.println("enter the user and password");
			String dbuser=in.nextLine();
			String dbPass=in.nextLine();
			con=DriverManager.getConnection(sql,dbPass,dbPass);// static and return Connection 
			System.out.println("Connection is established");
			//issue the sql queries via connection
			
			String query="select * from users_info where "
					+ "userId= ? and password= ?";
			
			pstmt=con.prepareStatement(query);
			
			System.out.println("enter userid");
			pstmt.setInt(1,Integer.parseInt(in.nextLine()));
			 
			System.out.println("enter password");
			pstmt.setString(2,in.nextLine());
			
			rst=pstmt.executeQuery();
			System.out.println("Query issued and excuted..");
			if(rst.next())// used since result is 0 or 1 used if
			{
				System.out.println("UserID is "+rst.getString(1));
				System.out.println("Name is "+rst.getString("username"));
				System.out.println("email is "+rst.getString("email"));
			}
		} 
		
		//close jdbc object
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rst!=null)
			{
				try {
					rst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(in!=null)
			{
				in.close();
			}
			System.out.println("all JDBC object is closed");
		}
	}
}
