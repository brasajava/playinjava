<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <%@ page import="java.util.*" %>  
    <%@ page import="java.net.*" %>  
    <%@ page import="java.io.*" %>  
      
    <%  
        System.out.println("Entrou!!!");  
        // read post from PayPal system and add 'cmd'  
        Enumeration<String> en = request.getParameterNames();  
        String str = "cmd=_notify-validate";  
          
        while(en.hasMoreElements()) {  
            String paramName = (String)en.nextElement();  
            String paramValue = request.getParameter(paramName);  
            str = str + "&" + paramName + "=" + URLEncoder.encode(paramValue,"UTF-8");  
        }  
      
        // post back to PayPal system to validate  
        // NOTE: change http: to https: in the following URL to verify using SSL (for increased security).  
        // using HTTPS requires either Java 1.4 or greater, or Java Secure Socket Extension (JSSE)  
        // and configured for older versions.  
        URL u = new URL("https://www.sandbox.paypal.com/cgi-bin/webscr");  
        URLConnection uc = u.openConnection();  
        uc.setDoOutput(true);  
        uc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
        PrintWriter pw = new PrintWriter(uc.getOutputStream());  
        pw.println(str);  
        pw.close();  
      
        BufferedReader in = new BufferedReader(  
        new InputStreamReader(uc.getInputStream()));  
        String res = in.readLine();  
        in.close();  
      
        // assign posted variables to local variables  
        String itemName = request.getParameter("item_name");  
        String itemNumber = request.getParameter("item_number");  
        String paymentStatus = request.getParameter("payment_status");  
        String paymentAmount = request.getParameter("mc_gross");  
        String paymentCurrency = request.getParameter("mc_currency");  
        String txnId = request.getParameter("txn_id");  
        String receiverEmail = request.getParameter("receiver_email");  
        String payerEmail = request.getParameter("payer_email");  
          
        //check notification validation  
        if(res.equals("VERIFIED")) {  
            // check that paymentStatus=Completed  
            // check that txnId has not been previously processed  
            // check that receiverEmail is your Primary PayPal email  
            // check that paymentAmount/paymentCurrency are correct  
            // process payment  
            System.out.println(paymentStatus);  
        }  
        else if(res.equals("INVALID")) {  
            // log for investigation 
            System.out.println("invalido");
            System.out.println(paymentStatus); 
            System.out.println(res);  
        }  
        else {  
        	System.out.println("erro"); 
        }  
    %>  

</body>
</html>