package com.capgemini.forestmanagementspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementspring.bean.Product;
import com.capgemini.forestmanagementspring.dao.ProductDAO;

@Service
public class ProductServicesImpl implements ProductServices{

	@Autowired
	private ProductDAO dao;

	@Override
	public boolean addProduct(Product proObj) {
		// TODO Auto-generated method stub
		return dao.addProduct(proObj);
	}

	@Override
	public boolean deleteProduct(String product_id) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(product_id);
	}

	@Override
	public Product searchProduct(String product_id) {
		// TODO Auto-generated method stub
		return dao.searchProduct(product_id);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProduct();
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return dao.updateProduct(product);
	}
}
