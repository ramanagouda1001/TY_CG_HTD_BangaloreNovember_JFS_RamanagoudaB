package com.capgemini.forestmanagementrest.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestmanagementrest.bean.Product;
import com.capgemini.forestmanagementrest.config.ORMConfig;
import com.capgemini.forestmanagementrest.config.TestBeans;
import com.capgemini.forestmanagementrest.dao.ProductDAO;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;

@SpringJUnitConfig(classes = {TestBeans.class,ORMConfig.class})
class ProductServicesImplTest {

	@Autowired
	ProductDAO productDAO;
	
	@Test
	void testAddProduct() {
		Product product=new Product();
		product.setProduct_id("tt55");
		product.setProduct_name("Rubber");
		product.setProduct_date("2020-02-02");
		product.setProduct_quality(55);
		try {
			boolean flag=productDAO.addProduct(product);
			assertEquals(flag, true);
		}
		catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				productDAO.addProduct(product);
			});
		}
	}

	@Test
	void testDeleteProduct() {
		try {
			boolean flag=productDAO.deleteProduct("tt55");
			assertEquals(flag, true);
		}
		catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				productDAO.deleteProduct("tt55");
			});
		}
	}

	@Test
	void testGetAllProduct() {
		List<Product> list=productDAO.getAllProduct();
		assertNotNull(list);
	}

	@Test
	void testUpdateProduct() {
		Product product=new Product();
		product.setProduct_id("ee44");
		product.setProduct_name("Timber");
		product.setProduct_date("2020-08-11");
		product.setProduct_quality(88);
		try {
			boolean flag=productDAO.updateProduct(product);
			assertEquals(flag,true);
		}
		catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				productDAO.updateProduct(product);
			});
		}
	}


}
