package login;

import java.util.*;

/**
 * Keeps track of accounts and passwords for this assignment.
 * !! Variables stored directly in this class, not in a DB.
 * !! Passwords stored unencrypted as plain text.
 * 
 * @author alexanderembiricos
 */
public class AccountManager {
	
	// Instance variables
	private Map<String, String> accounts;
	

	/*
	 * Initialize instance variables and set up the class with 
	 * testing accounts.
	 */
	public AccountManager() {
		accounts = new HashMap<String, String>();
		putDefaultAccounts();
	}
	
	/*
	 * Adds 2 accounts for testing as per the handout:
	 * "Patrick" -> "1234"
	 * "Molly" -> "FloPup"
	 */
	private void putDefaultAccounts() {
		accounts.put("Patrick", "1234");
		accounts.put("Molly", "FloPup");
	}
	
	/**
	 * Returns whether or not this AccountManager contains an account for the
	 * given username
	 * 
	 * @param username to check against
	 * @return a boolean indicating the existence of an account with that username
	 */
	public boolean userExists(String username) {
		return accounts.containsKey(username);
	}
	
	/**
	 * Returns whether or not the password given matches with the account
	 * corresponding to the given username.
	 * If there is no account for that username, also returns false.
	 * 
	 * @param username to check against
	 * @param password to check
	 * @return true if the account exists and the password matches.
	 * 			False if either condition is violated.
	 */
	public boolean passwordMatches(String username, String password) {
		return userExists(username)  &&  accounts.get(username).equals(password);
	}

	/**
	 * Creates an account with the given parameters, and returns true on success.
	 * Iff an account with that username already exists, does nothing and returns false.
	 * 
	 * @param username
	 * @param password
	 * @return true on success
	 */
	public boolean createAccount(String username, String password) {
		if (userExists(username)) return false;
		
		accounts.put(username, password);
		return true;
	}
}
