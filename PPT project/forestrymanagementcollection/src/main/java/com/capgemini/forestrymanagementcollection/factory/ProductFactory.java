package com.capgemini.forestrymanagementcollection.factory;

import com.capgemini.forestrymanagementcollection.dao.ProductDAO;
import com.capgemini.forestrymanagementcollection.dao.ProductDAOImpl;
import com.capgemini.forestrymanagementcollection.service.ProductServices;
import com.capgemini.forestrymanagementcollection.service.ProductServicesImpl;

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
