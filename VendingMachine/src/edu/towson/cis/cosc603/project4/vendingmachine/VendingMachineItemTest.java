package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	
	VendingMachineItem coke;
	VendingMachineItem pesi;
	
	VendingMachineItem nullName;
	VendingMachineItem emptyName;
	VendingMachineItem whiteSpace;

	@Before
	public void setUp() throws Exception {
		coke = new VendingMachineItem("coke", 1.50);
	}

	@After
	public void tearDown() throws Exception {
		coke = null;
	}

	@Test
	public void testVendingMachineItem() {
		assertNotNull(coke);
	}
	
	@Test(expected = VendingMachineException.class)
	public void testVendingMachineItem1LessThanZero() {
		pesi = new VendingMachineItem("pesi", -1);
		assertNull(pesi);
	}
	
	@Test(expected = VendingMachineException.class)
	public void testVendingMachineItem2NullName() {
		nullName = new VendingMachineItem(null, 1);
		assertNull(nullName);
	}
	
	@Test(expected = VendingMachineException.class)
	public void testVendingMachineItem3NoName() {
		emptyName = new VendingMachineItem("", 1);
		assertNull(emptyName);
	}
	
	@Test(expected = VendingMachineException.class)
	public void testVendingMachineItem4Whitespace() {
		whiteSpace = new VendingMachineItem(" ", 1);
		assertNull(whiteSpace);
	}

	@Test
	public void testGetName() {
		assertEquals("coke", coke.getName());
	}

	@Test
	public void testGetPrice() {
		assertEquals(1.50, coke.getPrice(), 0.0);
	}

}
