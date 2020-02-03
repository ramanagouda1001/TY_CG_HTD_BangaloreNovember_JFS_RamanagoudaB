package com.capgemini.forestrymanagementcollection.service;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.Product;

public interface ProductServices {
	public boolean addProduct(Product proObj);

	public boolean deleteProduct(String product_id);

	public Product searchProduct(String product_id);

	public List<Product> getAllProduct();

	public boolean modifyProductName(String product_id, String product_name);

	public boolean modifyProductDate(String product_id, String product_date);

}
