package com.capgemini.forestmanagement.dao;

import java.util.List;

import com.capgemini.forestmanagement.bean.Product;


public interface ProductDAO {

	public boolean addProduct(Product proObj);

	public boolean deleteProduct(String product_id);

	public Product searchProduct(String product_id);

	public List<Product> getAllProduct();

	public boolean modifyProductName(String product_id, String product_name);

	public boolean modifyProductDate(String product_id, String product_date);

}
