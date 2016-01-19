package Filter;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.paypal.core.LoggingManager;
import com.paypal.ipn.IPNMessage;



@SuppressWarnings("serial")
public class PayPalFilter extends HttpServlet implements Filter {
	
	private int cont=0;


	/*protected void service(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException ,java.io.IOException{
	
	 Enumeration en = request.getParameterNames();  
	 StringBuffer strBuffer = new StringBuffer("cmd=_notify-validate");  
	 String parametros = null; 
	 int cont=0;
	 response.setContentType("text/html");//para não dar erro no paypal
       
     while(en.hasMoreElements()) {  
    	 parametros="";
         String paramName = (String)en.nextElement();  
         String paramValue = request.getParameter(paramName);  
         parametros = parametros +  paramName + "=" + URLEncoder.encode(paramValue); 
         strBuffer.append("&").append(paramName).append("=").append(URLEncoder.encode(paramValue));
         //System.out.println(parametros);
         cont++;
     } 
     
     //System.out.println("total de parametros: "+cont);
     System.out.println(strBuffer);
     
    URL u = new URL("https://www.sandbox.paypal.com/cgi-bin/webscr");
 	HttpsURLConnection uc = (HttpsURLConnection) u.openConnection();
 	uc.setDoOutput(true);
 	uc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
 	uc.setRequestProperty("Host", "www.paypal.com");
 	PrintWriter pw = new PrintWriter(uc.getOutputStream());
 	pw.println(strBuffer.toString());
 	pw.close();

 	BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
 	String res = in.readLine();
 	in.close();
 	
 	
	// validando notificação!!!!!
	if (res.equals("VERIFIED")) {
		System.out.println("sinal enviado do sandbox paypal");
		
	     String tipoPagamento = request.getParameter("payment_type");  
	     String dataTransacao = request.getParameter("payment_date");  
	     String statusTransacao = request.getParameter("payment_status");  
	     String valor = request.getParameter("mc_gross");  
	     String paymentCurrency = request.getParameter("mc_currency");  
	     String transacaoID = request.getParameter("txn_id");  
	     String receiverEmail = request.getParameter("receiver_email");  
	     String payerEmail = request.getParameter("payer_email"); 
	     String totalItens= request.getParameter("num_cart_items");
	     
	     double valorFinal = Double.parseDouble(valor);
	     
	     System.out.println(totalItens);
	     System.out.println(dataTransacao);
	     System.out.println(valorFinal);
	     System.out.println(statusTransacao+"\n\n");
	     
	     
	     PayPal paypal = new PayPal(transacaoID, payerEmail, receiverEmail, dataTransacao, tipoPagamento, statusTransacao, valorFinal);
	     request.setAttribute("paypal", paypal);
	     //getServletContext().setInitParameter("resposta", "teste");
	     
	     RequestDispatcher view = request.getRequestDispatcher("/paypal.jsp");    
	     view.forward(request,response); 
	     //response.sendRedirect("paypal.jsp");
		 
	} else if (res.equals("INVALID")) {
		System.out.println("sinal falso\n\n");
		// log for investigation
	} else {
		System.out.println("erro");
		System.out.println("não foi verificado!!!!");
	}
		
	}*/

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		Map<String,String> configurationMap =  (Map<String, String>) Configuration.getConfig();
		IPNMessage 	ipnlistener = new IPNMessage((HttpServletRequest) request,configurationMap);
		boolean isIpnVerified = ipnlistener.validate();
		String transactionType = ipnlistener.getTransactionType();
		Map<String,String> map = ipnlistener.getIpnMap();
	   Iterator<String> valores = 	map.values().iterator();
       Iterator<String> chaves = 	map.keySet().iterator();
	  while(valores.hasNext())
		  System.out.println(chaves.next()+":"+ valores.next());
		
		LoggingManager.info(PayPalFilter.class, "******* IPN (name:value) pair : "+ map + "  " +
				"######### TransactionType : "+transactionType+"  ======== IPN verified : "+ isIpnVerified);
		
		 
		 Enumeration<String> en = request.getParameterNames();  
		 StringBuffer strBuffer = new StringBuffer("cmd=_notify-validate");  
		 String parametros = null; 
		 setCont(0);
		 response.setContentType("text/html");//para não dar erro no paypal
	       
	     while(en.hasMoreElements()) {  
	    	 parametros="";
	         String paramName = (String)en.nextElement(); 
	         String paramValue = request.getParameter(paramName);  
	         parametros = parametros +  paramName + "=" + paramValue;
	         strBuffer.append("&").append(paramName).append("=").append(paramValue);
	         setCont(getCont() + 1);
	     } 

	  String url= "https://www.sandbox.paypal.com/cgi-bin/webscr?"+strBuffer.toString();
	  URL teste = new URL(url);
	  
	    HttpsURLConnection uc1 = (HttpsURLConnection) teste.openConnection();
	    uc1.setDoOutput(true);
	 	uc1.setRequestMethod("POST");
	 	uc1.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	 	uc1.setRequestProperty("Host", "www.sandbox.paypal.com");
	 	PrintWriter pw1 = new PrintWriter(uc1.getOutputStream());
	 	pw1.println(strBuffer.toString());
	 	pw1.close();
	 	BufferedReader in = new BufferedReader(new InputStreamReader(uc1.getInputStream()));
	 	String str = in.readLine();
	 	in.close();
	    
	    if(str.equals("VERIFIED")){
	    	System.out.println("deu certo !!!!!");
	    }
	    
	    URL u = new URL("https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_notify-validate&tax2=0.00&residence_country=BR&tax1=0.00&num_cart_items=2&address_city=Rio De Janeiro&first_name=Ricardo&payer_id=DT3K6P4SX94XJ&mc_fee=0.52&txn_id=5HY59970W4868412P&receiver_email=comerciante@email.com&custom=&payment_date=10:32:35 Jun 22, 2015 PDT&payment_fee=&address_country_code=BR&charset=UTF-8&payment_gross=&item_name2=mouse&address_zip=22021-001&item_name1=computador&ipn_track_id=de347e3c378a3&mc_handling=0.00&mc_handling1=0.00&tax=0.00&mc_handling2=0.00&address_name=Ricardo Silva&last_name=Silva&receiver_id=VEP53CL7VAEUU&verify_sign=A5ebgvy.tS9prazr3MEHHpWeioXTAN8CAbQzZEymqvXheUK-S2ayWp.y&address_country=Brazil&business=comerciante@email.com&address_status=unconfirmed&payment_status=Pending&transaction_subject=&protection_eligibility=Ineligible&payer_email=fregues@email.com&notify_version=3.8&txn_type=cart&test_ipn=1&payer_status=verified&mc_shipping=0.00&mc_gross=3.60&mc_currency=BRL&mc_gross_1=0.60&mc_gross_2=3.00&mc_shipping2=0.00&mc_shipping1=0.00&item_number2=id_mouse&item_number1=id_computador&quantity1=1&quantity2=1&address_state=RJ&pending_reason=paymentreview&payment_type=instant&address_street=1234 Rua Main");
	 	HttpsURLConnection uc = (HttpsURLConnection) u.openConnection();
	 	uc.setDoOutput(true);
	 	uc.setRequestMethod("POST");
	 	uc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	 	uc.setRequestProperty("Host", "www.sandbox.paypal.com");
	 	PrintWriter pw = new PrintWriter(uc.getOutputStream());
	 	pw.println(strBuffer.toString());
	 	pw.close();
	 	
	 	BufferedReader in1 = new BufferedReader(new InputStreamReader(uc.getInputStream()));
	 	String res = in1.readLine();
	 	in.close();
	 	
	 	
		// validando notificação!!!!!
		if (res.equals("VERIFIED")) {
			System.out.println("sinal enviado do sandbox paypal");
			
		     String tipoPagamento = request.getParameter("payment_type");  
		     String dataTransacao = request.getParameter("payment_date");  
		     String statusTransacao = request.getParameter("payment_status");  
		     String valor = request.getParameter("mc_gross");   
		     String transacaoID = request.getParameter("txn_id");  
		     String receiverEmail = request.getParameter("receiver_email");  
		     String payerEmail = request.getParameter("payer_email"); 
		     //String totalItens= request.getParameter("num_cart_items");
		     //String nome= request.getParameter("item_name1");
		     
		     //System.out.println(nome);
		     double valorFinal = Double.parseDouble(valor);
		     
		    /* System.out.println(totalItens);
		     System.out.println(dataTransacao);
		     System.out.println(valorFinal);
		     System.out.println(statusTransacao+"\n\n");*/
		     
		     
		     PayPal paypal = new PayPal(transacaoID, payerEmail, receiverEmail, dataTransacao, tipoPagamento, statusTransacao, valorFinal);
		     request.setAttribute("paypal", paypal);
		     //getServletContext().setInitParameter("resposta", "teste");
		     
		     RequestDispatcher view = request.getRequestDispatcher("/paypal.jsp");    
		     view.forward(request,response); 
		     //response.sendRedirect("paypal.jsp");
			 
		} else if (res.equals("INVALID")) {
			System.out.println("sinal falso\n\n");
			RequestDispatcher view = request.getRequestDispatcher("/Falso.jsp");    
		    view.forward(request,response); 
		} else {
			System.out.println("erro");
			System.out.println("não foi verificado!!!!");
		}
		
	
			
		}
	
	public static boolean validarPedido(HttpServletRequest request) throws Exception{
		
	    URL teste = new URL("https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_notify-validate&mc_gross=1.00&invoice=21089&protection_eligibility=Eligible&address_status=unconfirmed&item_number1=1603&payer_id=EAQPJD8JBX84W&tax=0.00&address_street=Avenida+2+A++955++%0D%0ACidade+Nova&payment_date=07%3A39%3A14+Aug+29%2C+2014+PDT&payment_status=Completed&charset=windows-1252&address_zip=13506-780&mc_shipping=0.00&mc_handling=0.00&first_name=Roberto&mc_fee=0.66&address_country_code=BR&address_name=Roberto+Issamo+Kiyoto&notify_version=3.8&custom=&payer_status=unverified&business=financeiro%40cbcon.com.br&address_country=Brazil&num_cart_items=1&mc_handling1=0.00&address_city=Rio+Claro&verify_sign=A6YtnqfOWJ6HMEdspgmAUa6LGE0nAVWP3kt5BX7Nu2D8ZkkcPLotRqBe&payer_email=robertokiyoto%40gmail.com&mc_shipping1=0.00&tax1=0.00&txn_id=86B09967HT8416935&payment_type=instant&last_name=Issamo+Kiyoto&address_state=SP&item_name1=Curso+PayPal&receiver_email=financeiro%40cbcon.com.br&payment_fee=&quantity1=1&receiver_id=5R3H8WRNM3RBU&txn_type=cart&mc_gross_1=1.00&mc_currency=BRL&residence_country=BR&transaction_subject=&payment_gross=&ipn_track_id=7708241188053");
	    HttpsURLConnection uc1 = (HttpsURLConnection) teste.openConnection();
	    BufferedReader in1 = new BufferedReader(new InputStreamReader(uc1.getInputStream())); 
	    String str = in1.readLine();
	    in1.close();
	    
	    if(str.equals("VERIFIED")){
	    	System.out.println("sinal verificado e verdadeiro do paypal !!!!!");
	    	return true;
	    }
	 	
	    else
	    	return false;
		
	}
		

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}


	public int getCont() {
		return cont;
	}


	public void setCont(int cont) {
		this.cont = cont;
	}
} 
