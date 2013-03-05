package login;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/createAccount")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
    	request.setAttribute("title", "Create Account");
    	request.setAttribute("header", "Create New Account");
    	request.setAttribute("prompt", "Please enter proposed name and password.");
    	request.setAttribute("action", "createAccount");
    	request.setAttribute("newAccountOption", false);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		AccountManager accounts = (AccountManager) sc.getAttribute(
									AccountManagerListener.ACCOUNT_MANAGER);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (accounts.createAccount(username, password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			request.setAttribute("username", username);
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("title", "Create Account");
	    	request.setAttribute("header", "The Name " + username + " Is Already In Use");
	    	request.setAttribute("prompt", "Please enter another name and password.");
	    	request.setAttribute("action", "createAccount");
	    	request.setAttribute("newAccountOption", false);
			dispatcher.forward(request, response);
		}
	}

}
