package com.capgemini.forestmanagementrest.service;

import java.util.List;

import com.capgemini.forestmanagementrest.bean.Product;

public interface ProductServices {

	public boolean addProduct(Product proObj);//done

	public boolean deleteProduct(String product_id);//done

	public Product searchProduct(String product_id);//wrote

	public List<Product> getAllProduct();//done

	public boolean updateProduct(Product product);
	
}
