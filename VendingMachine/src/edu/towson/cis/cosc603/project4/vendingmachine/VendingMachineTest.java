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
		assertNotNull(sodaPopMachine); //make sure soda machine created
	}

	@Test
	public void testAddItem() {
		//add item normal. 
		sodaPopMachine.addItem(jolt, "D");
		
	}
	
	@Test(expected = VendingMachineException.class)
	public void testAddItem1BadCode() {
		//add item wrong code
		sodaPopMachine.addItem(pesi, "E");
	}
	
	@Test(expected = VendingMachineException.class)
	public void testAddItem2SlotOccupied() {
		//add too many times
		sodaPopMachine.addItem(coke, "A");	
	}

	@Test
	public void testRemoveItem() {
		assertEquals(coke, sodaPopMachine.removeItem("A")); 
	}
	
	@Test(expected = VendingMachineException.class)
	public void testRemoveItem1RemoveTooMany() {
		sodaPopMachine.removeItem("A");
		assertNotEquals(coke, sodaPopMachine.removeItem("A")); 
	}

	@Test
	public void testInsertMoney() {
		sodaPopMachine.insertMoney(2);
		assertEquals(2.00, sodaPopMachine.balance, 0.0);
	}
	
	@Test
	public void testInsertMoney1AddtoBalance() {
		sodaPopMachine.balance = 1.00;
		sodaPopMachine.insertMoney(2);
		assertEquals(3.00, sodaPopMachine.balance, 0.0);
	}

	@Test
	public void testGetBalance() {
		sodaPopMachine.balance = 2.00;
		assertEquals(2.00, sodaPopMachine.getBalance(), 0.0);
	}

	@Test
	public void testMakePurchase() {
		//success
		sodaPopMachine.balance = 1.50;
		assertTrue(sodaPopMachine.makePurchase("A"));
		//failure out of stock
	}
	
	@Test
	public void testMakePurchase1NoBalance() {
		//failure not enough money
		sodaPopMachine.balance = 0;
		assertFalse(sodaPopMachine.makePurchase("A"));
	}
	
	@Test
	public void testMakePurchase2OutofStock() {
		//failure out of stock
		sodaPopMachine.balance = 3.99;
		assertFalse(sodaPopMachine.makePurchase("D"));	
	}
	
	@Test(expected = VendingMachineException.class)
	public void testMakePurchase2BadInput() {
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
