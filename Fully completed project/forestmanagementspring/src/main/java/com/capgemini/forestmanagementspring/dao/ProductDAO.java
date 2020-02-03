package com.capgemini.forestmanagementspring.dao;

import java.util.List;

import com.capgemini.forestmanagementspring.bean.Product;

public interface ProductDAO {

	public boolean addProduct(Product proObj);

	public boolean deleteProduct(String product_id);

	public Product searchProduct(String product_id);

	public List<Product> getAllProduct();

	public boolean updateProduct(Product product);

}
