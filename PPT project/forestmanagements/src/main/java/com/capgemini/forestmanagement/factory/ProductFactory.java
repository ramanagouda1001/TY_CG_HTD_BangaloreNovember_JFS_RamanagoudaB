package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.ProductDAO;
import com.capgemini.forestmanagement.dao.ProductDAOImpl;
import com.capgemini.forestmanagement.service.ProductServices;
import com.capgemini.forestmanagement.service.ProductServicesImpl;

public class ProductFactory {

	private ProductFactory() {

	}

	public static ProductDAO instanceOfProductDAOImpl() {
		ProductDAO dao = new ProductDAOImpl();
		return dao;
	}

	public static ProductServices instanceOfProductServicesImpl() {
		ProductServices dao = new ProductServicesImpl();
		return dao;
	}
}
