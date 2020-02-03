package com.capgemini.forestrymanagementcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.Product;
import com.capgemini.forestrymanagementcollection.exception.ForestManagementException;


public class ProductDAOImpl implements ProductDAO {

	List<Product> list=new ArrayList<Product>();
	public boolean addProduct(Product proObj) {
		boolean status=true;
		for (Product product : list) {
			if(product.getProductId().equals(proObj.getProductId()))
			{
				throw new ForestManagementException("Product Already Exist");
			}
		}
		list.add(proObj);
		return status;
	}


	public boolean deleteProduct(String product_id) {
		boolean status=true;
		for (Product product : list) {
			if(product.getProductId().equals(product_id))
			{
				list.remove(product);
				return status;
			}
		}
		throw new ForestManagementException("Account not exist");
	}

	public Product searchProduct(String product_id) {
		for (Product product : list) {
			if(product.getProductId().equals(product_id))
			{
				return product;
			}
		}
		throw new ForestManagementException("Account not exist");
	}

	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return list;
	}

	public boolean modifyProductName(String product_id, String product_name) {
		boolean status=true;
		for (Product product : list) {
			if(product.getProductId().equals(product_id))
			{
				product.setProductName(product_name);
				return status;
			}
		}
		throw new ForestManagementException("Cannot Update");
	}

	public boolean modifyProductDate(String product_id, String product_date) {
		boolean status=true;
		for (Product product : list) {
			if(product.getProductId().equals(product_id))
			{
				product.setProductDate(product_date);
				return status;
			}
		}
		throw new ForestManagementException("Cannot update");
	}

}
