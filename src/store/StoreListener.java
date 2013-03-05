package store;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class StoreListener
 * Initializes and stores a ProductCatalog.
 * Closes the database connection upon context destruction.
 *
 */
@WebListener
public class StoreListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public StoreListener() {
        // Do nothing
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	ServletContext sc = arg0.getServletContext();
        sc.setAttribute("ProductCatalog", new ProductCatalog());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        DBConnection.close();
    }
	
}
