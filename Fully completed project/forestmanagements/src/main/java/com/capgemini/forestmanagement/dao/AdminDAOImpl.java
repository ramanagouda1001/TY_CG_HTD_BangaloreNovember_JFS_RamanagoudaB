package com.capgemini.forestmanagement.dao;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestmanagement.bean.Account;
import com.capgemini.forestmanagement.bean.Admin;
import com.capgemini.forestmanagement.exception.ForestManagementException;


public class AdminDAOImpl  implements AdminDAO{
	FileReader reader;
	Properties prop;
	Admin admin;
	Account account;
	public AdminDAOImpl() {
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("hi");
		}	}
	@Override
	public boolean getAdmin(Admin admin) {
		boolean status=false;
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("specificaccount")))
		{
			pstmt.setString(1, admin.getName());
			pstmt.setString(2, admin.getPassword());
			ResultSet rst=pstmt.executeQuery();
			if(rst.next())
				status=true;
			return status;
		}
		catch (Exception e) {
			throw new ForestManagementException("Invalid credentials");
		}
	}
	@Override
	public boolean addAccount(Account bean) {
		boolean status=false;
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("insertaccount")))
		{
			
			pstmt.setString(1, bean.getUsername());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getRole());
			
			int count=pstmt.executeUpdate();
			if(count>0)
				status=true;
			return status;
		}
		catch (Exception e) {
			throw new ForestManagementException("Account Already Present");
		}
	}
	@Override
	public boolean getAccount(String username, String password) {
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("authaccount")))
		{
				boolean status=false;
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				ResultSet rst=pstmt.executeQuery();
				if(rst.next())
					status=true;
			return status;
		}
		catch(Exception e)
		{
			throw new ForestManagementException("Account is not Present");
		}
	}
	@Override
	public boolean deleteAccount(Account bean) {
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("deleteaccount")))
		{
			boolean status=false;
			pstmt.setString(1, bean.getUsername());
			pstmt.setString(2,bean.getPassword());
			int count=pstmt.executeUpdate();
			if(count>0)
				status=true;
			
			return status;
		}
		catch(Exception e)
		{
			throw new ForestManagementException("Account is alreday deleted");
		}
	}
	@Override
	public List<Account> listAccount() {
		List<Account> list=new ArrayList<Account>();
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = con.createStatement();
				ResultSet rst = stmt.executeQuery(prop.getProperty("selectaccount")))
		{
			while(rst.next())
			{
				account=new Account();
				account.setUsername(rst.getString(1));
				account.setPassword(rst.getString(2));
				account.setRole(rst.getString(3));
				list.add(account);
			}
			return list;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	public boolean updateAccount(String newPassword, String oldPassword) {
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("updateaccount")))
		{
			pstmt.setString(1, newPassword);
			pstmt.setString(2, oldPassword);
			
			int count=pstmt.executeUpdate();
			
			if(count>0)
				return true;
		}
		catch(Exception e)
		{
			throw new ForestManagementException("unable to update");
		}
		return false;
	}
	@Override
	public boolean getSchedular(String username, String password) {
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("authschedular")))
		{
				boolean status=false;
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				ResultSet rst=pstmt.executeQuery();
				if(rst.next())
					status=true;
			return status;
		}
		catch(Exception e)
		{
			throw new ForestManagementException("Account is not Present");
		}
	}
}
