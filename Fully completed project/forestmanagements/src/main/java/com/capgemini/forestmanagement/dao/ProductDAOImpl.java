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

import com.capgemini.forestmanagement.bean.Product;
import com.capgemini.forestmanagement.exception.ForestManagementException;


public class ProductDAOImpl implements ProductDAO {

	FileReader reader;
	Properties prop;
	Product user;

	public ProductDAOImpl() {
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
	public boolean addProduct(Product proObj) {
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("insertproduct")))
		{
			boolean status=false;
			pstmt.setString(1, proObj.getProductId());
			pstmt.setString(2, proObj.getProductName());
			pstmt.setString(3, proObj.getProductDate());
			pstmt.setInt(4, proObj.getProductQuality());
			int count = pstmt.executeUpdate();

			if (count > 0)
				status=true;
		
			return status;
		}
		catch(Exception e)
		{
			throw new ForestManagementException("Alraedy Present");
		}
	}

	@Override
	public boolean deleteProduct(String product_id) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("deleteproduct"))) {
			pstmt.setString(1, product_id);
			
			boolean status=false;
			int count = pstmt.executeUpdate();
			if (count > 0)
				status=true;
			
			return status;
		} catch (Exception e) {
			throw new ForestManagementException("Already Deleted or Not Present");
		}
	}

	@Override
	public Product searchProduct(String product_id) {
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("displayproduct")))
		{
			pstmt.setString(1, product_id);
			ResultSet rst=pstmt.executeQuery();
			if(rst.next())
			{
				user=new Product();
				user.setProductId(rst.getString(1));
				user.setProductName(rst.getString(2));
				user.setProductDate(rst.getString(3));
				user.setProductQuality(rst.getInt(4));
				return user;
			}

		}
		catch(Exception e)
		{
			
		}
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list=new ArrayList<Product>();
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = con.createStatement();
				ResultSet rst = stmt.executeQuery(prop.getProperty("selectproduct")))
		{
			while(rst.next())
			{
				user=new Product();
				user.setProductId(rst.getString(1));
				user.setProductName(rst.getString(2));
				user.setProductDate(rst.getString(3));
				user.setProductQuality(rst.getInt(4));
				list.add(user);
			}
			return list;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}

	@Override
	public boolean modifyProductName(String product_id, String product_name) {
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("updateproductname")))
		{
			boolean status=false;
			pstmt.setString(1, product_name);
			pstmt.setString(2, product_id);
			
			int count=pstmt.executeUpdate();
			if(count >0)
				status=true;
			return status;
		}
		catch(Exception e)
		{
			throw new ForestManagementException("unable to modify");
		}
	}

	@Override
	public boolean modifyProductDate(String product_id, String product_date) {
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("updateproductdate")))
		{
			boolean status=false;
			pstmt.setString(1, product_date);
			pstmt.setString(2, product_id);
			
			int count=pstmt.executeUpdate();
			if(count >0)
				status=true;
			
			return status;
		}
		catch(Exception e)
		{
			throw new ForestManagementException("unable to modify");
		}
	}
	@Override
	public boolean getAuth(String username, String password) {
		try(Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("authproduct"))){
			boolean status=false;
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rst=pstmt.executeQuery();
			if(rst.next())
				status=true;
		return status;
		}
		catch (Exception e) {
			throw new ForestManagementException("Account is not present");
		}
	}
}
