package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.bean.Product;
import com.capgemini.forestmanagement.exception.ForestManagementException;


public class ProductDAOImpl implements ProductDAO {

	List<Product> list=new ArrayList<Product>();
	@Override
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

	@Override
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

	@Override
	public Product searchProduct(String product_id) {
		for (Product product : list) {
			if(product.getProductId().equals(product_id))
			{
				return product;
			}
		}
		throw new ForestManagementException("Account not exist");
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
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

	@Override
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