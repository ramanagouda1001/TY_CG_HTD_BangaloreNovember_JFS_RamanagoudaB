package com.capgemini.forestmanagementspring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestmanagementspring.bean.Product;
import com.capgemini.forestmanagementspring.exception.ForestManagementSystem;

@SpringBootTest
class ProductServicesImplTest {

	@Autowired
	ProductServices productServices;
	
	@Test
	void testAddProduct() {
		Product product=new Product();
		product.setProduct_id("tt55");
		product.setProduct_name("Rubber");
		product.setProduct_date("2020-02-02");
		product.setProduct_quality(55);
		try {
			boolean flag=productServices.addProduct(product);
			assertEquals(flag, true);
		}
		catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				productServices.addProduct(product);
			});
		}
	}

	@Test
	void testDeleteProduct() {
		try {
			boolean flag=productServices.deleteProduct("tt55");
			assertEquals(flag, true);
		}
		catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				productServices.deleteProduct("tt55");
			});
		}
	}

	@Test
	void testGetAllProduct() {
		List<Product> list=productServices.getAllProduct();
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
			boolean flag=productServices.updateProduct(product);
			assertEquals(flag,true);
		}
		catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				productServices.updateProduct(product);
			});
		}
	}

}