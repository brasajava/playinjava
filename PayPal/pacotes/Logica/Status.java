package Logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;

public class Status extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException ,java.io.IOException {
	RequestDispatcher view = request.getRequestDispatcher("/paypal.jsp");    
    view.forward(request,response);
	}
}
