package com.cagemini.forestmanagement.dao;

import java.util.List;

import com.cagemini.forestmanagement.bean.Product;

public interface ProductDAO {
	public boolean getAuth(String username, String password);

	public boolean addProduct(Product proObj);

	public boolean deleteProduct(String product_id);

	public Product searchProduct(String product_id);

	public List<Product> getAllProduct();

	public boolean modifyProductName(String product_id, String product_name);

	public boolean modifyProductDate(String product_id, String product_date);
	

}
