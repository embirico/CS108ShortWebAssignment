package store;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Encapsulates creating a connection to the database, but returns SQL
 * statements directly to those wishing to communicate with the database.
 */
public class DBConnection {

	// Instance variables
	private static Statement stmt;
	
	// Exported constants
	public static final String TABLE_NAME = "products";
	
	// Constructor
	static {
		try {
			stmt = MyDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_UPDATABLE);
			stmt.executeQuery("USE " + "c_cs108_embirico");
		} catch (SQLException e) {
			System.err.println("DBConnection: database access error");
			e.printStackTrace();
		}
	}
	
	// Output
	/**
	 * Encapsulates creating a connection to the database, but returns SQL
	 * statements directly to those wishing to communicate with the database.
	 * 
	 * @return the SQL statement
	 */
	public static Statement getStatement() {
		return stmt;
	}
	
	/**
	 * Close the database connection
	 */
	public static void close() {
		MyDB.close();
	}

}
