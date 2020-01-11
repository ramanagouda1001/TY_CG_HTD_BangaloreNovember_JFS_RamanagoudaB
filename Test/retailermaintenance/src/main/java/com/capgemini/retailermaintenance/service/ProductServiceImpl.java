package com.capgemini.retailermaintenance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailermaintenance.bean.OrderInfo;
import com.capgemini.retailermaintenance.bean.ProductInfo;
import com.capgemini.retailermaintenance.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO dao;
	@Override
	public boolean add(ProductInfo bean) {
		// TODO Auto-generated method stub
		return dao.add(bean);
	}

	@Override
	public ProductInfo serach(int product_id) {
		// TODO Auto-generated method stub
		return dao.serach(product_id);
	}

	@Override
	public boolean addOrder(OrderInfo bean) {
		// TODO Auto-generated method stub
		return dao.addOrder(bean);
	}

}
