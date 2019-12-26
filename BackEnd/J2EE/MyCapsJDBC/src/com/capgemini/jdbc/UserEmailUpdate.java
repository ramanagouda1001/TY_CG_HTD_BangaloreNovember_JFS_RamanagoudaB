package com.capgemini.jdbc;

import java.sql.*;
import java.sql.SQLException;
import java.util.*;

public class UserEmailUpdate 
{
	public static void main(String[] args) 
	{
		//load the driver
		Connection con=null;
		PreparedStatement pstmt=null;
		Scanner in=new Scanner(System.in);
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("drivre loaded");
			
			//get connection
			String url="jdbc:mysql://127.0.0.1:3307/ty_cg_nov6";
			System.out.println("enter the user name");
			String user=in.nextLine();
			System.out.println("enter the password");
			String pass=in.nextLine();
			con=DriverManager.getConnection(url, user, pass);
			System.out.println("connection esablished......");
			// issue query
			
			
			String query="update users_info set email=? where userid=? and password=?";
			pstmt=con.prepareStatement(query);
			
			// process the resultqu+ery
			System.out.println("enter the userid");
			pstmt.setInt(2,Integer.parseInt(in.nextLine()));
			
			System.out.println("enter the password");
			pstmt.setString(3,in.nextLine());
			
			System.out.println("enter the email");
			pstmt.setString(1,in.nextLine());
			
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				System.out.println("updated sucessfully");
			}
			else
			{
				System.err.println("failed to update");
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
			//close+
		}
		finally
		{
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(in!=null)
			{
				in.close();
			}
		}
	}
}
