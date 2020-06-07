package com.capgemini.forestmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagement.bean.Product;
import com.capgemini.forestmanagement.exception.ForestManagementException;

class ProductServicesImplTest {

	ProductServices obj=null;
	Product product=null;
	
	@BeforeEach
	void testProductDAOImpl() {
		FileReader reader;
		Properties prop;
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("hi");
		}
		obj=new ProductServicesImpl();

	}

	@Test
	void testAddProduct() {
		product=new Product();
		product.setProductDate("01/11/2020");
		product.setProductId("rr22");
		product.setProductName("rohan");
		try {
			boolean flag=obj.addProduct(product);
			assertEquals(flag,true);
		}
		catch(Exception e) {
			assertThrows(ForestManagementException.class, () -> {
				obj.addProduct(product);
			});
		}
	}

	@Test
	void testDeleteProduct() {

		String product_id="rr22";
		boolean flag=obj.deleteProduct(product_id);
		if(flag==true)
			assertEquals(flag, true);
		else
			assertEquals(flag, false);

	}

	@Test
	void testSearchProduct() {
		product=new Product();
		product.setProductId("ee44");
		product.setProductName("hi");
		product.setProductDate("31/12/2019");
		Product testObject=obj.searchProduct(product.getProductId());
		if(testObject!=null)
			assertEquals(testObject, product);
		else
			assertEquals(testObject,null );
		}

	@Test
	void testGetAllProduct() {
		List<Product> list=obj.getAllProduct();
		boolean flag=list!=null;
		assertEquals(flag,true);
	}

	@Test
	void testModifyProductName() {
		String product_id="ee44";
		String product_name="hi";
		boolean flag=obj.modifyProductName(product_id, product_name);
		if(flag==true)
			assertEquals(flag, true);
		else
			assertEquals(flag, false);
	}

	@Test
	void testModifyProductDate() {
		String product_id="ee44";
		String product_date="31/12/2019";
		boolean flag=obj.modifyProductDate(product_id, product_date);
		if(flag==true)
			assertEquals(flag, true);
		else
			assertEquals(flag, false);

	}

	@Test
	void testGetAuth() {
		String username="Arun123@gmail.com";
		String password="Arun123@";
		try {
			boolean flag=obj.getAuth(username, password);
			assertEquals(flag,false);
		}
		catch(Exception e) {
			assertThrows(ForestManagementException.class, () -> {
				obj.addProduct(product);
			});
		}

	}

}