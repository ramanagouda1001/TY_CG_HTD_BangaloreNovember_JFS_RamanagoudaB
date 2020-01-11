package com.capgemini.retailermaintenance.service;

import com.capgemini.retailermaintenance.bean.OrderInfo;
import com.capgemini.retailermaintenance.bean.ProductInfo;

public interface ProductService {
	
	public boolean add(ProductInfo bean);//done
	
	public ProductInfo serach(int product_id);//done
	
	
	public boolean addOrder(OrderInfo bean);//done
}
