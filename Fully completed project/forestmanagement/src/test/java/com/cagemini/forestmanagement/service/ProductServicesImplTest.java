package com.cagemini.forestmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cagemini.forestmanagement.bean.Product;
import com.cagemini.forestmanagement.exception.ForestManagementSystem;

class ProductServicesImplTest {

	ProductServices obj=null;
	Product product=null;
	
	
	@BeforeEach
	void load() {
		obj=new ProductServicesImpl();
	}
	
	@Test
	void testGetAuth() {
		String username="Arun123@gmail.com";
		String password="Arun123@";
		try {
			boolean flag=obj.getAuth(username, password);
			assertEquals(flag, true);
		}
		catch(Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				obj.getAuth(username, password);
			});
		}
	}

	@Test
	void testAddProduct() {
		product=new Product();
		product.setProductDate("01/11/2020");
		product.setProductId("uu22");
		product.setProductName("rohan");
		product.setProductQuality(22);
		try {
			boolean flag=obj.addProduct(product);
			assertEquals(flag,true);
		}
		catch(Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				obj.addProduct(product);
			});
		}
	}

	@Test
	void testDeleteProduct() {
		String product_id="ww22";
		try {
			boolean flag=obj.deleteProduct(product_id);
			assertEquals(flag,false);
		}
		catch(Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				obj.deleteProduct(product_id);
			});
		}

	}

	@Test
	void testSearchProduct() {
		String product_id="rr22";
		try {
			Product testObject=obj.searchProduct(product_id);
			assertEquals(testObject!=null,true);
		}
		catch(Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				obj.searchProduct(product_id);
			});
		}

	}
	
	@Test
	void testModifyProductName() {
		String product_id="ee44";
		String product_name="hi";
		try {
			boolean flag=obj.modifyProductName(product_id, product_name);
			assertEquals(flag, true);
		}
		catch(Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				obj.modifyProductName(product_id, product_name);
			});
		}
		
	}

	@Test
	void testModifyProductDate() {
		String product_id="ee44";
		String product_date="31/12/2019";
		try {
			boolean flag=obj.modifyProductDate(product_id, product_date);			
		}
		catch(Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				obj.modifyProductDate(product_id, product_date);
			});
		}
	}

}
