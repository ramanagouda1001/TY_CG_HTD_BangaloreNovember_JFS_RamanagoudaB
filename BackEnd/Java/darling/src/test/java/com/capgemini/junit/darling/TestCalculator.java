package com.capgemini.junit.darling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalculator {

//	Calculator c = new Calculator();
	Calculator c = null;

	@BeforeEach
	void createObj() {
		c = new Calculator();
	}

	@Test
	void tesAdd() {
		int i = c.add(20, 5);
		assertEquals(25, i);
	}

	@Test
	void testAddForNegative() {
		int i = c.add(-1, 6);
		assertEquals(5, i);
	}

	@Test
	void testMultiple() {
		int i = c.mutiple(10, 5);
		assertEquals(50, i);
	}

	@Test
	void testDivisionArithemeticException() {
		assertThrows(ArithmeticException.class, () -> {
			c.division(10, 0);
		});
	}

	@Test
	void testFindString() {
		int res = c.findLength("rohan");
		assertEquals(5, res);
	}

	@Test
	void testNullString() {
		assertThrows(NullPointerException.class, () -> {
			c.findLength(null);
		});
	}
}
//@Test
//@BeforeEach
//@AfterEAch
//BeforeAll only for static
//AfterAll only for static