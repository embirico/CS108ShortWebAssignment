package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.AccountManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
    	request.setAttribute("title", "Welcome");
    	request.setAttribute("header", "Welcome to Homework 5");
    	request.setAttribute("prompt", "Please log in.");
    	request.setAttribute("action", "login");
    	request.setAttribute("newAccountOption", true);
		dispatcher.forward(request, response);
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		AccountManager accounts = (AccountManager) sc.getAttribute(
									AccountManagerListener.ACCOUNT_MANAGER);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (accounts.passwordMatches(username, password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			request.setAttribute("username", username);
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("title", "Information Incorrect");
	    	request.setAttribute("header", "Please try again");
	    	request.setAttribute("prompt", "Either your user name or password is incorrect. " +
	    									"Please try again.");
	    	request.setAttribute("action", "login");
	    	request.setAttribute("newAccountOption", true);
			dispatcher.forward(request, response);
		}
	}

}
