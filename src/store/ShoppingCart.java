package store;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*
 * Stores productid's rather than Products as keys for quick adding, at the cost
 * of slower access.
 */
public class ShoppingCart {

	// Instance variables
	private Map<String, Integer> cart; // Product -> quantity
	
	// Constructor
	public ShoppingCart() {
		cart = new HashMap<String, Integer>();
	}
	
	/**
	 * Computes the total cost of the shopping cart
	 * 
	 * @param the total cost as a BigDecimal
	 */
	public BigDecimal getTotalCost() {
		BigDecimal total = BigDecimal.ZERO;
		for (String productid: cart.keySet()) {
			BigDecimal productPrice = new Product(productid).price;
			total = total.add(productPrice.multiply(BigDecimal.valueOf(cart.get(productid))));
		}
		return total;
	}
	
	/**
	 * Returns a map describing the contents of the cart.
	 * key: productid
	 * value: quantity
	 * 
	 * @return the map
	 */
	public Map<String, Integer> getCart() {
		return cart;
	}
	
	/**
	 * Adds an item to the shopping cart if the cart doesn't contain it,
	 * or increments the quantity by 1 if it is contained.
	 * 
	 * @param productid of the product to add
	 */
	public void addToCart(String productid) {
		if (cart.containsKey(productid)) {
			cart.put(productid, cart.get(productid)+1);
		} else {
			cart.put(productid, 1);
		}
	}
	
	/**
	 * Updates the cart to include the given number of the given product.
	 * Setting the quantity to 0 removes the product from the map.
	 * 
	 * @param productid product to change quantity of
	 * @param newQuantity - the new quantity
	 */
	public void setQuantity(String productid, int newQuantity) {
		if (newQuantity == 0) {
			cart.remove(productid);
		} else {
			cart.put(productid, newQuantity);
		}
	}

}
