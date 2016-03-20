package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class VendingMachineTest.
 * @author James Rehak
 */
public class VendingMachineTest {
	
	/** The soda pop machine. */
	VendingMachine sodaPopMachine; 
	
	/** The coke. */
	//declare items for vending machine
	VendingMachineItem coke;
	
	/** The pesi. */
	VendingMachineItem pesi;
	
	/** The dr pepper. */
	VendingMachineItem drPepper;
	
	/** The jolt. */
	VendingMachineItem jolt;
	
	/** The code. */
	String[] code = {"A", "B", "C", "D"};
	
	/** The soda. */
	VendingMachineItem[] soda;

	/**
	 * Sets up soda pop machine object and Items:
	 * coke, pesi, Dr. Pepper, and jolt.
	 * 
	 *  Add coke, pesi, and Dr. Pepper to vending machine
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		sodaPopMachine = new VendingMachine();
		coke = new VendingMachineItem("coke", 1.50);
		pesi = new VendingMachineItem("pesi", 1.25);
		drPepper = new VendingMachineItem("Dr. Pepper", 1.34);
		jolt = new VendingMachineItem("jolt", 3.99);
		
		VendingMachineItem[] soda = {coke, pesi, drPepper, jolt};
		this.soda = soda;
		
		//add items
		sodaPopMachine.addItem(coke, "A");
		sodaPopMachine.addItem(pesi, "B");
		sodaPopMachine.addItem(drPepper, "C");
	}

	/**
	 * Tear down.
	 * Set all items to null. Remove soda pop machine. 
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		sodaPopMachine = null;
		for(int i = 0; i<soda.length; i++){
			soda[i] = null;
		}
	}

	/**
	 * Test vending machine.
	 * Assert vending machine object instantiated. 
	 */
	@Test
	public void testVendingMachine() {
		assertNotNull(sodaPopMachine); //make sure soda machine created
	}

	/**
	 * Test add item, Normal operation. 
	 * Precondition: Fulfilled
	 * Postcondition: Fulfilled. 
	 */
	@Test
	public void testAddItem() {
		//add item normal. 
		sodaPopMachine.addItem(jolt, "D");
		assertSame(jolt, sodaPopMachine.getItem("D"));
	}
	
	/**
	 * Test add item1 bad code.
	 * Precondition: Failed, code out of bounds
	 * Postcondition: Assert item not created.
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItem1BadCode() {
		//add item wrong code
		sodaPopMachine.addItem(pesi, "E");
		assertNotSame(pesi, sodaPopMachine.getItem("E"));
	}
	
	/**
	 * Test add item2 slot occupied.
	 * Precondition: Failed, slot to be used is occupied.
	 * Postcondition: Assert original item not replaced. 
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItem2SlotOccupied() {
		//add too many times
		sodaPopMachine.addItem(jolt, "A");	
		assertSame(coke, sodaPopMachine.getItem("A"));
	}
	
	/**
	 * Test add item3 lower case code.
	 * Precondition: Failed, item code not correct case.
	 * Postcondition: Assert item with lower case code not used. Exception thrown.
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItem3LowerCaseCode() {
		sodaPopMachine.addItem(jolt, "d");	
		//assertNotEquals(jolt, sodaPopMachine.getItem("D"));
		assertNull(sodaPopMachine.getItem("D"));
		assertNull(sodaPopMachine.getItem("d"));
	}
	
	/**
	 * Test add item4 same item multiple slots.
	 * Precondition: Fulfilled
	 * Postcondition: Fulfilled, Assert same item type in two different slots
	 */
	@Test
	public void testAddItem4SameItemMultiSlot() {
		sodaPopMachine.addItem(pesi, "D");
		assertSame(pesi, sodaPopMachine.getItem("B"));
		assertSame(pesi, sodaPopMachine.getItem("D"));
	}

	/**
	 * Test add item5 empty to full. 
	 * Remove all items and then fill all slots.
	 * Precondition: Fulfilled.
	 * Postcondition: Assert all items are stocked.
	 */
	@Test
	public void testAddItem5EmptyToFull() {
		//remove all 3
		for(int i = 0; i < soda.length-1; i++){
			sodaPopMachine.removeItem(code[i]);
		}
		//fill
		for(int i = 0; i < soda.length; i++){	
			sodaPopMachine.addItem(soda[i], code[i]);
			assertSame(soda[i], sodaPopMachine.getItem(code[i]));
		}
	}

	/**
	 * Test remove item.
	 * Precondition: Fulfilled, Item in slot.
	 * Postcondition: Assert item is removed. 
	 */
	@Test
	public void testRemoveItem() {
		assertSame(coke, sodaPopMachine.removeItem("A")); 
	}
	
	/**
	 * Test remove item1 remove too many. 
	 * Attempt remove item from empty slot.
	 * Precondition: Remove item from slot. 
	 * Postcondition: Assert no item is removed from empty slot. Exception thrown.
	 */
	@Test(expected = VendingMachineException.class)
	public void testRemoveItem1RemoveTooMany() {
		sodaPopMachine.removeItem("A");
		assertNotSame(coke, sodaPopMachine.removeItem("A")); 
	}
	
	/**
	 * Test remove item2 all gone.
	 * Remove all items from vending machine.
	 * Precondition: Vending machine is full. 
	 * Postcondition: assert vending machine is empty. 
	 */
	@Test
	public void testRemoveItem2AllGone() {	
		sodaPopMachine.addItem(jolt, "D");
		
		for(int i = 0; i < soda.length; i++){
			sodaPopMachine.removeItem(code[i]);

			assertNotSame(soda[i], sodaPopMachine.getItem(code[i]));
			assertNull(sodaPopMachine.getItem(code[i]));
		}
	}
	
	/**
	 * Test remove item3 bad input.
	 * Precondition: Failed, item code incorrect
	 * Postcondition: Exception thrown, Assert item not removed.
	 */
	@Test(expected = VendingMachineException.class)
	public void testRemoveItem3BadInput() {
		sodaPopMachine.removeItem("E");
		assertNull(sodaPopMachine.getItem("E"));
	}

	/**
	 * Test insert money, normal operation.
	 * Precondition: Fulfilled, Balance = 0, insert $2.00.
	 * Postcondition: Assert balance equals money inserted.
	 */
	@Test
	public void testInsertMoney() {
		sodaPopMachine.insertMoney(2.00);
		assertEquals(2.00, sodaPopMachine.balance, 0.0);
	}
	
	/**
	 * Test insert money1 add to balance, normal operation.
	 * Precondition: Fulfilled, initial balance equals $1.00, insert $2.00
	 * Postcondition: Assert balance equals $3.00
	 */
	@Test
	public void testInsertMoney1AddtoBalance() {
		sodaPopMachine.balance = 1.00;
		sodaPopMachine.insertMoney(2);
		assertEquals(3.00, sodaPopMachine.balance, 0.0);
	}
	
	/**
	 * Test insert money2 negative input.
	 * Precondition: Failed, insert negative amount of money.
	 * Postcondition: Exception thrown, assert balance not changed. 
	 */
	@Test(expected = VendingMachineException.class)
	public void testInsertMoney2NegativeINput() {
		sodaPopMachine.insertMoney(-1);
		assertEquals(0, sodaPopMachine.balance, 0.0);
	}

	/**
	 * Test get balance.
	 * Precondition: Fulfilled, set balance to $2.00
	 * Postcondition: Assert getBalance same amount. 
	 */
	@Test
	public void testGetBalance() {
		sodaPopMachine.balance = 2.00;
		assertEquals(2.00, sodaPopMachine.getBalance(), 0.0);
	}
	
	/**
	 * Test get balance1 test initial balance is zero.
	 * Precondition: Fulfilled, vending machine instantiated. 
	 * Postcondition: Assert getBalance returns zero. 
	 */
	@Test
	public void testGetBalance1Intial() {
		assertEquals(0, sodaPopMachine.getBalance(), 0.0);
	}

	/**
	 * Test make purchase, normal operation
	 * Precondition: Fulfilled, set vending machine balance to $1.50
	 * Postcondition: Assert purchase succeeds. 
	 */
	@Test
	public void testMakePurchase() {
		//success
		sodaPopMachine.balance = 1.50;
		assertTrue(sodaPopMachine.makePurchase("A"));
	}
	
	/**
	 * Test make purchase1 no balance. Not enough money to make purchase.
	 * Precondition: Failed, vending machine balance under item price.
	 * Postcondition: Assert purchase fails. 
	 */
	@Test
	public void testMakePurchase1NoBalance() {
		//failure not enough money
		sodaPopMachine.balance = 0;
		assertFalse(sodaPopMachine.makePurchase("A"));
	}
	
	/**
	 * Test make purchase2 out of stock. Attempt purchase of out of stock item
	 * Precondition: Failed, no item in slot. 
	 * Postcondition: Assert purchase fails. 
	 */
	@Test
	public void testMakePurchase2OutofStock() {
		//failure out of stock
		sodaPopMachine.balance = 3.99;
		assertFalse(sodaPopMachine.makePurchase("D"));	
	}
	
	/**
	 * Test make purchase3 bad input.
	 * Precondition: Failed, input code incorrect.
	 * Postcondition: Assert purchase fails. 
	 */
	@Test(expected = VendingMachineException.class)
	public void testMakePurchase3BadInput() {
		//failure bad code
		assertFalse(sodaPopMachine.makePurchase("E"));
	}
	
	/**
	 * Test make purchase4 higher balance.
	 * Precondition: Fulfilled, balance above item price
	 * Postcondition: Assert purchase succeeds. Assert new correct balance. 
	 */
	@Test
	public void testMakePurchase4HigherBalance() {
		//failure out of stock
		sodaPopMachine.balance = 2.00;
		assertTrue(sodaPopMachine.makePurchase("A"));
		assertEquals(0.50, sodaPopMachine.balance, 0.0);
	}
	
	/**
	 * Test make purchase5 double purchase.
	 * Precondition: Failed, item out of stock after purchase
	 * Postcondition: Assert second purchase fails and balance unchanged.  
	 */
	@Test
	public void testMakePurchase5DoublePurchase() {
		sodaPopMachine.balance = 3.00;
		assertTrue(sodaPopMachine.makePurchase("A"));
		assertEquals(1.50, sodaPopMachine.balance, 0.0);
		
		//failure out of stock
		assertNull(sodaPopMachine.getItem("A"));
		assertFalse(sodaPopMachine.makePurchase("A"));
		assertEquals(1.50, sodaPopMachine.balance, 0.0);
	}

	/**
	 * Test return change. Normal operation
	 * Precondition: Fulfilled. Vending machine balance set to $0.50
	 * Postcondition: Assert Balance equals $0.0, change return equals $0.50
	 */
	@Test
	public void testReturnChange() {
		sodaPopMachine.balance = 0.50;
		assertEquals(0.50, sodaPopMachine.returnChange(), 0.0);
		
		assertEquals(0, sodaPopMachine.balance, 0);
	}
	
	/**
	 * Test return change1 no change.
	 * Precondition: Fulfilled, balance at initialized amount of zero 
	 * Postcondition: Assert no change returned. 
	 */
	@Test
	public void testReturnChange1NoChange() {
		assertEquals(0.0, sodaPopMachine.returnChange(), 0.0);
	}


}
