package store;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	
	// Exported contants
	public static final String SHOPPING_CART = "ShoppingCart";

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // do nothing
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
    	HttpSession sc = arg0.getSession();
        sc.setAttribute("ShoppingCart", new ShoppingCart());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // do nothing
    }
	
}
