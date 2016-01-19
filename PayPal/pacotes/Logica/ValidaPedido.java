package Logica;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ValidaPedido extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String quantidade=(String) request.getParameter("quantidade");
		String produto=(String) request.getParameter("produtos");
		String moeda=(String) request.getParameter("moeda");
		String quantidade2= (String) request.getParameter("quantidade2");
		String produto2= (String) request.getParameter("produto");
		String teste = getServletConfig().getInitParameter("teste");
		//System.out.println(teste);
		
		List<Object> compra= new LinkedList<>();
		compra.add(moeda);
		compra.add(produto);
		compra.add(quantidade);
		compra.add(quantidade2);
		compra.add(produto2);
		request.setAttribute("compra", compra);
		
		/*response.setContentType("text/html");
		PrintWriter out=  response.getWriter();
		out.append("<html>");
		out.append("<body>");
		out.append(valor);
		out.append("</body>");
		out.append("</html>");*/
		
		RequestDispatcher view = request.getRequestDispatcher("BotaoDinamico/inicio.jsp");    
	    view.forward(request,response); 
		//response.sendRedirect("BotaoDinamico/inicio.jsp");
		
	}
/*	
	@Override
	public void init() throws ServletException {
		System.out.println("metodo init chamado pelo container");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("metodo service chamado pelo container");
		super.service(arg0, arg1);
		destroy();
	}
	
	@Override
	public void destroy() {
		System.out.println("metodo destroy chamado pelo container");
		super.destroy();
	}*/

}