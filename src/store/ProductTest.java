package store;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;

public class ProductTest {

	// Instance variables
	ProductCatalog pc;
	List<Product> products;
	
	@Before
	public void setUp() throws Exception {
		pc = new ProductCatalog();
		products = pc.getProductsList();
	}

	@Test
	public void test() {
		assertEquals(14, pc.getProductIDsList().size());
		assertEquals(14, products.size());
		
		Product classicHoodie = products.get(0);
		assertEquals("HC", classicHoodie.productid);
		assertEquals("Classic Hoodie", classicHoodie.name);
		assertEquals("Hoodie.jpg", classicHoodie.imagefile);
		assertEquals(0, BigDecimal.valueOf(40).compareTo(classicHoodie.price));
	}
	
	@Test
	public void test2() {
		assertEquals("Seal Tee", new Product(pc.getProductIDsList().get(3)) .name);
	}

	@AfterClass
	public static void cleanUp() {
		DBConnection.close();
	}
}
