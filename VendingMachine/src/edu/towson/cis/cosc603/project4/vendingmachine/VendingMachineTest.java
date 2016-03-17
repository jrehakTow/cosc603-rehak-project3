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
		
		//add items
		sodaPopMachine.addItem(coke, "A");
		sodaPopMachine.addItem(pesi, "B");
		sodaPopMachine.addItem(drPepper, "C");
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
		
		//add item normal. 
		sodaPopMachine.addItem(jolt, "D");
		
		//add too many times
		sodaPopMachine.addItem(pesi, "E");
		
		//add item with duplicate code
		
		//add item wrong code
		
	}

	@Test
	public void testGetItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveItem() {
		//fail("Not yet implemented");
		//test if remove item operates normal
		assertEquals(coke, sodaPopMachine.removeItem("A")); 
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
		//success (don't forget about balance)
		sodaPopMachine.balance = 1.50;
		assertTrue(sodaPopMachine.makePurchase("A"));
		
		//failure out of stock
	}
	
	@Test(expected = VendingMachineException.class)
	public void testMakePurchaseNoBalance() {
		//failure not enough money
		sodaPopMachine.balance = 0;
		assertFalse(sodaPopMachine.makePurchase("A"));
	}
	
	@Test(expected = VendingMachineException.class)
	public void testMakePurchaseBadInput() {
		//failure bad code
		assertFalse(sodaPopMachine.makePurchase("E"));
	}

	@Test
	public void testReturnChange() {
		sodaPopMachine.balance = 0.50;
		assertEquals(0.50, sodaPopMachine.returnChange(), 0.0);
		
		assertEquals(0, sodaPopMachine.balance, 0);
	}
	
	@Test
	public void testReturnChange1() {
		sodaPopMachine.balance = 0.0;
		assertEquals(0.0, sodaPopMachine.returnChange(), 0.0);
	}


}
