package login;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountManagerTest {

	// Instance variables
	AccountManager accounts;
	
	@Before
	public void setUp() throws Exception {
		accounts = new AccountManager();
	}

	@Test
	public void test() {
		assertTrue(accounts.userExists("Patrick"));
		assertTrue(accounts.userExists("Molly"));
		assertFalse(accounts.userExists("Batman"));
		
		assertTrue(accounts.passwordMatches("Molly", "FloPup"));
		assertFalse(accounts.passwordMatches("Patrick", "FloPup"));
		
		assertTrue(accounts.createAccount("Robin", "egg"));
		assertTrue(accounts.passwordMatches("Robin", "egg"));
	}

}
