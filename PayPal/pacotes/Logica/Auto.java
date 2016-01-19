package Logica;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Auto extends HttpServlet{
	
	

	private int cont;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		 StringBuffer strBuffer = new StringBuffer("");  
		 String parametros = null; 
		 setCont(0);
		 response.setContentType("text/html");//para não dar erro no paypal
		
		Enumeration<String> en = request.getParameterNames();  
		
		while(en.hasMoreElements()) {  
	    	 parametros="";
	         String paramName = (String)en.nextElement(); 
	         String paramValue = request.getParameter(paramName);  
	         parametros = parametros +  paramName + "=" + URLEncoder.encode(paramValue,"UTF-8"); 
	         strBuffer.append("&").append(paramName).append("=").append(URLEncoder.encode(paramValue,"UTF-8"));
	         System.out.println(parametros);
	         setCont(getCont() + 1);
	     } 
		
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

}
