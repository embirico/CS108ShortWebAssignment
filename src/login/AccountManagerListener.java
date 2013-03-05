package login;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AccountManagerListener
 *
 */
@WebListener
public class AccountManagerListener implements ServletContextListener {

	public static final String ACCOUNT_MANAGER = "AccountManager";
	
    /**
     * Default constructor. 
     */
    public AccountManagerListener() {
        // nothing required here
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext sc = arg0.getServletContext();
        sc.setAttribute("AccountManager", new AccountManager());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	// do nothing
    }
	
}
