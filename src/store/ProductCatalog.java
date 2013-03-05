package store;

import java.sql.*;
import java.util.*;

import store.DBConnection;

public class ProductCatalog {
	
	// Instance variables
	private static Statement stmt;
	private List<String> productIDs;

	// Constructor
	public ProductCatalog() {
		stmt = DBConnection.getStatement();
		productIDs = new ArrayList<String>();
		fillProductIDsList();
	}
	
	/*
	 * Fill <code>productIDs</code> with the ids from the table.
	 */
	private void fillProductIDsList() {
		String sqlStr = "SELECT productid FROM " + DBConnection.TABLE_NAME;
		try {
			ResultSet rs = stmt.executeQuery(sqlStr);
			rs.first();
			do {
				productIDs.add(rs.getString(1));
			} while (rs.next());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a list of all the productIDs in the database.
	 * 
	 * @return a list of all the productIDs in the database.
	 */
	public List<String> getProductIDsList() {
		return productIDs;
	}
	
	/**
	 * Returns a list of all the products in the database.
	 * 
	 * @return a list of all the products in the database.
	 */
	public List<Product> getProductsList() {
		List<Product> products = new ArrayList<Product>();
		for (String productID: productIDs) {
			products.add(new Product(productID));
		}
		return products;
	}

}
