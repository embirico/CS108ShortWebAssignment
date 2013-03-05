package store;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
        super();
        // do nothing
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute(SessionListener.SHOPPING_CART);
		
		Map<String, String[]> paramMap = request.getParameterMap();
		for (String productid: paramMap.keySet()) {
			cart.setQuantity( productid, Integer.parseInt(paramMap.get(productid)[0]) );
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("shoppingCart.jsp");
		dispatcher.forward(request, response);
	}

}
