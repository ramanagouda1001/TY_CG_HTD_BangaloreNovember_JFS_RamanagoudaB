package com.capgemini.retailermaintenance.dao;

import com.capgemini.retailermaintenance.bean.OrderInfo;
import com.capgemini.retailermaintenance.bean.ProductInfo;

public interface ProductDAO {

public boolean add(ProductInfo bean);
	
	public ProductInfo serach(int product_id);

	public boolean addOrder(OrderInfo bean);
}
