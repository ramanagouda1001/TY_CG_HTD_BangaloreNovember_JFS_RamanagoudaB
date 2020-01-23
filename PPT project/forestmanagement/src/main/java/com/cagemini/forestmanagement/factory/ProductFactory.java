package com.cagemini.forestmanagement.factory;

import com.cagemini.forestmanagement.dao.ProductDAO;
import com.cagemini.forestmanagement.dao.ProductDAOImpl;
import com.cagemini.forestmanagement.service.ProductServices;
import com.cagemini.forestmanagement.service.ProductServicesImpl;

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
