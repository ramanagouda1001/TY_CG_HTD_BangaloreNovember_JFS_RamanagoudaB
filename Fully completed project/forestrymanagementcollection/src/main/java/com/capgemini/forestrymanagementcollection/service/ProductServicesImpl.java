package com.capgemini.forestrymanagementcollection.service;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.Product;
import com.capgemini.forestrymanagementcollection.dao.ProductDAO;
import com.capgemini.forestrymanagementcollection.factory.ProductFactory;

public class ProductServicesImpl implements ProductServices{

	ProductDAO dao=ProductFactory.instanceOfProductDAOImpl();
	public boolean addProduct(Product proObj) {
		// TODO Auto-generated method stub
		return dao.addProduct(proObj);
	}

	public boolean deleteProduct(String product_id) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(product_id);
	}

	public Product searchProduct(String product_id) {
		// TODO Auto-generated method stub
		return dao.searchProduct(product_id);
	}

	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProduct();
	}

	public boolean modifyProductName(String product_id, String product_name) {
		// TODO Auto-generated method stub
		return dao.modifyProductName(product_id, product_name);
	}

	public boolean modifyProductDate(String product_id, String product_date) {
		// TODO Auto-generated method stub
		return dao.modifyProductDate(product_id, product_date);
	}

}