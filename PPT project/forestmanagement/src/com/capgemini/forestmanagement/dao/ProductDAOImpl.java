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


public class ProductDAOImpl implements ProductDAO {

	List<Product> list=new ArrayList<Product>();
	@Override
	public boolean addProduct(Product proObj) {
		for (Product product : list) {
			if(product.getProduct_id().equals(proObj.getProduct_id()))
			{
				return false;
			}
		}
		list.add(proObj);
		return true;
	}

	@Override
	public boolean deleteProduct(String product_id) {
		for (Product product : list) {
			if(product.getProduct_id().equals(product_id))
			{
				list.remove(product);
				return true;
			}
		}
		return false;
	}

	@Override
	public Product searchProduct(String product_id) {
		for (Product product : list) {
			if(product.getProduct_id().equals(product_id))
			{
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public boolean modifyProductName(String product_id, String product_name) {
		for (Product product : list) {
			if(product.getProduct_id().equals(product_id))
			{
				product.setProduct_name(product_name);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean modifyProductDate(String product_id, String product_date) {
		for (Product product : list) {
			if(product.getProduct_id().equals(product_id))
			{
				product.setProduct_date(product_date);
				return true;
			}
		}
		return false;
	}

}
