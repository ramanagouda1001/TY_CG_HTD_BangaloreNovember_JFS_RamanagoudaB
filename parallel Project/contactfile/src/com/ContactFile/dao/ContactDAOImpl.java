package com.ContactFile.dao;

import java.io.FileReader;
import java.util.*;
import java.sql.*;

import com.ConatctFile.bean.Contact;


public class ContactDAOImpl  implements ContactDAO{
	
	FileReader reader;
	Properties prop;
	Contact bean;
	
	public ContactDAOImpl()
	{
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("hi");
		}
	}
	@Override
	public List<Contact> contractDetails() {
		List<Contact> list = new ArrayList<Contact>();
		try (Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = con.createStatement();
				ResultSet rst = stmt.executeQuery(prop.getProperty("display"))) {
				while(rst.next())
				{
					bean=new Contact();
					bean.setName(rst.getString(1));
					bean.setNumber(rst.getInt(2));
					bean.setGroup(rst.getString(3));
					list.add(bean);
				}
				return list;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	@Override
	public boolean addContact(Contact bean) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("insert"))) {
			
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getNumber());
			pstmt.setString(3, bean.getGroup());
			
			int count=pstmt.executeUpdate();
			if(count>0)
				return true;
		}
		catch(Exception e)
		{
			
		}
		return false;
	}

	@Override
	public boolean deleteContact(String name) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("delete"))) {
			
			pstmt.setString(1, name);
			int count=pstmt.executeUpdate();
			if(count>0)
				return true;
		}
		catch(Exception e)
		{
			
		}
		return false;
	}

	@Override
	public boolean editNumber(String name, int number) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("upadte")))
		{
			pstmt.setInt(1,number);
			pstmt.setString(2, name);
			int count=pstmt.executeUpdate();
			if(count>0)
				return true;
		}
		catch(Exception e)
		{
			
		}
		return false;
	}
	@Override
	public Contact searchContact(String name) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("search")))
		{
			pstmt.setString(1, name);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next())
			{
				bean=new Contact();
				bean.setName(rst.getString(1));
				bean.setNumber(rst.getInt(2));
				bean.setGroup(rst.getString(3));
				return bean;
			}
		}
		catch(Exception e )
		{
			
		}
		return null;
	}

}
