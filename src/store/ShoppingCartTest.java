package store;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

	// Instance variables
	ProductCatalog pc;
	List<Product> products;
	ShoppingCart cart;
	
	@Before
	public void setUp() throws Exception {
		pc = new ProductCatalog();
		products = pc.getProductsList();
		cart = new ShoppingCart();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DBConnection.close();
	}

	@Test
	public void test() {
		assertEquals(0, BigDecimal.ZERO.compareTo(cart.getTotalCost()));
		
		cart.addToCart("HC");
		assertEquals(0, BigDecimal.valueOf(40).compareTo(cart.getTotalCost()));
		
		cart.addToCart("HC");
		assertEquals(0, BigDecimal.valueOf(80).compareTo(cart.getTotalCost()));
		
		cart.setQuantity("HC", 0);
		assertEquals(0, BigDecimal.ZERO.compareTo(cart.getTotalCost()));
		
		cart.setQuantity("HC", 3);
		assertEquals(0, BigDecimal.valueOf(120).compareTo(cart.getTotalCost()));
	}

}
