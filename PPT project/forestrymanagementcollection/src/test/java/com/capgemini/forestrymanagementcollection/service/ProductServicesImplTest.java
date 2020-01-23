package com.capgemini.forestrymanagementcollection.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.Product;
import com.capgemini.forestrymanagementcollection.dao.ProductDAO;
import com.capgemini.forestrymanagementcollection.dao.ProductDAOImpl;

class ProductServicesImplTest {

	private ProductServices productDAO= new ProductServicesImpl();
	private Product product=new Product();
	
	@BeforeEach
	void addProduct() {
		product.setProductId("ww22");
		product.setProductName("timber");
		product.setProductDate("22/02/2020");
		product.setProductQuality(22);
	}
	@Test
	void testAddProduct() {
		boolean flag=productDAO.addProduct(product);
		assertEquals(flag, true);
	}	

	@Test
	void testDeleteProduct() {
		productDAO.addProduct(product);
		boolean flag=productDAO.deleteProduct("ww22");
		assertEquals(flag, true);
	}

	@Test
	void testSearchProduct() {
		productDAO.addProduct(product);
		Product object=productDAO.searchProduct("ww22");
		assertEquals(object, product);
	}

	@Test
	void testGetAllProduct() {
		List<Product> list=productDAO.getAllProduct();
		boolean flag=list!=null;
		assertEquals(flag, true);
	}

}
