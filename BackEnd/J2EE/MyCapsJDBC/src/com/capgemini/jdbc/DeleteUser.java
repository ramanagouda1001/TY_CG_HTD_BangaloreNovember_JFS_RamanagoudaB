package com.capgemini.jdbc;

import java.sql.*;
import java.util.*;

public class DeleteUser 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		Scanner in=new Scanner(System.in);
		try
		{
			//load the driver
			//Driver drive=new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(drive);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver has been loaded");
			
			// get the connection database
			
			String dburl="jdbc:mysql://127.0.0.1:3307/ty_cg_nov6";
			System.out.println("enter the user ");
			String dbuser=in.nextLine();
			System.out.println("enter the password ");
			String dbpass=in.nextLine();
			con=DriverManager.getConnection(dburl,dbuser,dbpass);
			System.out.println("connection is established..");
			
			//issue the sqlQuery 
			
			String query="delete from users_info where userid= ? and password =?";
			pstmt=con.prepareStatement(query);

			// process the Result
			System.out.println("enter userid");
			pstmt.setInt(1,Integer.parseInt(in.nextLine()));
			
			System.out.println("enter password");
			pstmt.setString(2,in.nextLine());

			int count=pstmt.executeUpdate();
			if(count>0)
			{
				System.out.println("user deleted");
			}
			else
			{
				System.err.println("failed to delete");
			}
		}
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		//close JDBC objects}

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

			if(in!=null)
			{
				in.close();
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
			System.out.println("all JDBC object is closed");
		}
	}
}