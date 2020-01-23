package com.cagemini.forestmanagement.service;

import java.util.List;

import com.cagemini.forestmanagement.bean.Product;
import com.cagemini.forestmanagement.dao.ProductDAO;
import com.cagemini.forestmanagement.factory.ContractFactory;
import com.cagemini.forestmanagement.factory.ProductFactory;

public class ProductServicesImpl implements ProductServices{

	ContractServices services=ContractFactory.insatnceOfServicesImpl();
	ProductDAO dao=ProductFactory.instanceOfProductDAOImpl();
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
	public boolean modifyProductName(String product_id, String product_name) {
		// TODO Auto-generated method stub
		return dao.modifyProductName(product_id, product_name);
	}

	@Override
	public boolean modifyProductDate(String product_id, String product_date) {
		// TODO Auto-generated method stub
		return dao.modifyProductDate(product_id, product_date);
	}

	@Override
	public boolean getAuth(String username, String password) {
		// TODO Auto-generated method stub
		return dao.getAuth(username, password);
	}

}