package com.capgemini.jdbc;

import java.sql.*;

public class MyFirstJDBC 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement smt=null;
		ResultSet rs=null;
		try
		{
			//Load the Driver
			//Driver drive=new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(drive);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...");
			
			//Get the DB connection via driver
			
			String dbURl = "jdbc:mysql://localhost:3307/ty_cg_nov6"+"?user=root&password=root";
			con=DriverManager.getConnection(dbURl);
			System.out.println("Connection is established...");
			
			//Issue SQl queries via connection
			String qry="select * from users_info";
			smt=con.createStatement();
			//Process the result returned
		
			rs=smt.executeQuery(qry);
			System.out.println("query issued...");
			while(rs.next())
			{
				System.out.println("userID: "+rs.getInt("userid"));
				System.out.println("userName: "+rs.getString("username"));
				System.out.println("useremail: "+rs.getString("email"));
				//System.out.println("password : "+rs.getString("password"));
				System.out.println("********************************************");
			}
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		//Close the connection
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
			if(smt!=null)
			{
				try 
				{
					smt.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try 
				{
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println("All Connection is Closed");
	}
}
