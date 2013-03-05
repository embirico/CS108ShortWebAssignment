package store;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product {
	
	// Exported variables
	public final String productid;
	public final String name;
	public final String imagefile;
	public final BigDecimal price;
	
	// Instance variables
	private static Statement stmt;
	
	// Constants
	@SuppressWarnings("unused")
	private static final int PRODUCTID_COL = 1;
	private static final int NAME_COL = 2;
	private static final int IMAGEFILE_COL = 3;
	private static final int PRICE_COL = 4;
	

	public Product(String productid) {
		// Temp variables in case of error
		String tname = "";
		String timagefile = "";
		BigDecimal tprice = BigDecimal.ZERO;
		
		stmt = DBConnection.getStatement();
		String sqlStr = "SELECT * FROM " + DBConnection.TABLE_NAME + 
					" WHERE productid = \"" + productid + "\"";
		try {
			ResultSet rs = stmt.executeQuery(sqlStr);
			rs.first();
			tname = rs.getString(NAME_COL);
			timagefile = rs.getString(IMAGEFILE_COL);
			tprice = rs.getBigDecimal(PRICE_COL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.productid = productid;
		this.name = tname;
		this.imagefile = timagefile;
		this.price = tprice;
	}

}
