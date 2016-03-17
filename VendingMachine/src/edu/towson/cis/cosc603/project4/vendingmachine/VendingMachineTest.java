package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	
	VendingMachine sodaPopMachine; //declare object
	
	//declare items for vending machine
	VendingMachineItem coke;
	VendingMachineItem pesi;
	VendingMachineItem drPepper;
	VendingMachineItem jolt;

	@Before
	public void setUp() throws Exception {
		sodaPopMachine = new VendingMachine();
		coke = new VendingMachineItem("coke", 1.50);
		pesi = new VendingMachineItem("pesi", 1.25);
		drPepper = new VendingMachineItem("Dr. Pepper", 1.34);
		jolt = new VendingMachineItem("jolt", 3.99);
		
		//add item
		sodaPopMachine.addItem(coke, "A");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVendingMachine() {
		//fail("Not yet implemented");
		assertNotNull(sodaPopMachine); //make sure soda machine created
	}

	@Test
	public void testAddItem() {
		fail("Not yet implemented");
		//sodaPopMachine.addItem(coke, "A");
		
		
		
	}

	@Test
	public void testGetItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveItem() {
		//fail("Not yet implemented");
		//test if remove item operates normal
		assertEquals(sodaPopMachine.removeItem("A"), coke); 
	}

	@Test
	public void testInsertMoney() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBalance() {
		fail("Not yet implemented");
	}

	@Test
	public void testMakePurchase() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnChange() {
		fail("Not yet implemented");
	}


}
