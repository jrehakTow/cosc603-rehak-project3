package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class VendingMachineItemTest.
 * @author James Rehak
 */
public class VendingMachineItemTest {
	
	/** Declare vending machine item object The coke. */
	VendingMachineItem coke;
	
	/** Declare vending machine item object The pesi. */
	VendingMachineItem pesi;
	
	/** Declare vending machine item object The null name. */
	VendingMachineItem nullName;
	
	/** Declare vending machine item object The empty name. */
	VendingMachineItem emptyName;
	
	/** Declare vending machine item object The white space. */
	VendingMachineItem whiteSpace;

	/**
	 * Instantiate the coke item object
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		coke = new VendingMachineItem("coke", 1.50);
	}

	/**
	 * Tear down. Set coke item object to null. 
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		coke = null;
	}

	/**
	 * Test vending machine item.
	 * Assert coke object created.
	 */
	@Test
	public void testVendingMachineItem() {
		assertNotNull(coke);
	}
	
	/**
	 * Test vending machine item1 less than zero.
	 * Attempt creation of item with negative price
	 * Assert item with negative price not created.
	 */
	@Test(expected = VendingMachineException.class)
	public void testVendingMachineItem1LessThanZero() {
		pesi = new VendingMachineItem("pesi", -1);
		assertNull(pesi);
	}
	
	/**
	 * Test vending machine item2 null name.
	 * Attempt creation of item with name set to null.
	 * Assert item not created.
	 */
	@Test(expected = VendingMachineException.class)
	public void testVendingMachineItem2NullName() {
		nullName = new VendingMachineItem(null, 1);
		assertNull(nullName);
	}
	
	/**
	 * Test vending machine item3 no name.
	 * Attempt creation of item with empty name.
	 * Assert item not created. 
	 */
	@Test(expected = VendingMachineException.class)
	public void testVendingMachineItem3NoName() {
		emptyName = new VendingMachineItem("", 1);
		assertNull(emptyName);
	}
	
	/**
	 * Test vending machine item4 whitespace.
	 * Attempt creation of item with name set to space character
	 * Assert item not created. 
	 */
	@Test(expected = VendingMachineException.class)
	public void testVendingMachineItem4Whitespace() {
		whiteSpace = new VendingMachineItem(" ", 1);
		assertNull(whiteSpace);
	}

	/**
	 * Test get name.
	 * Assert name equals the name set to the object. 
	 */
	@Test
	public void testGetName() {
		assertEquals("coke", coke.getName());
	}

	/**
	 * Test get price.
	 * Assert getPrice gets the correct price. 
	 */
	@Test
	public void testGetPrice() {
		assertEquals(1.50, coke.getPrice(), 0.0);
	}

}
