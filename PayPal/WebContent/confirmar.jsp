<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@ page import="javax.net.ssl.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Dados da compra</h2>
		<p>
			PAYMENTREQUEST_0_AMT=22.00<br>
			PAYMENTREQUEST_0_CURRENCYCODE=BRL<br>
			PAYMENTREQUEST_0_ITEMAMT=22.00<br>
			PAYMENTREQUEST_0_INVNUM=9<br>
			L_PAYMENTREQUEST_0_NAME0=Item A<br>
			L_PAYMENTREQUEST_0_DESC0=Produto A - 110V<br>
			L_PAYMENTREQUEST_0_AMT0=11.00<br>
			L_PAYMENTREQUEST_0_QTY0=1<br>
			L_PAYMENTREQUEST_0_ITEMAMT=11.00<br>
			L_PAYMENTREQUEST_0_NAME1=Item B<br>
			L_PAYMENTREQUEST_0_DESC1=Produto B - 220V<br>
			L_PAYMENTREQUEST_0_AMT1=11.00<br>
			L_PAYMENTREQUEST_0_QTY1=1<br>
		</p>
		
		<%
		Enumeration<String> en = request.getParameterNames(); 
		String str = "";  
		int i=0;
		  while(en.hasMoreElements()) {  
	            String paramName = (String)en.nextElement();  
	            String paramValue = request.getParameter(paramName);  
	            str = str + paramName + "=" + URLEncoder.encode(paramValue,"UTF-8");  
	            System.out.println(str);
	            str="";
	            //if(!(URLEncoder.encode(paramValue).equals("")))
	            	i++;
	        }  
		  System.out.println(i);
		
		
		%>
		   		
		<form method="post" action="https://api-3t.sandbox.paypal.com/nvp" target="_top">
			<input type="hidden" name="USER" value="r-xsilva-facilitator_api1.ig.com.br">
			<input type="hidden" name="PWD" value="1366977240">
			<input type="hidden" name="SIGNATURE" value="AFcWxV21C7fd0v3bYYYRCpSSRl31A-Soi0kN1Yqi4W.0lFNwJkp2.L9L">
			<input type="hidden" name="VERSION" value="93.0">
			<input type="hidden" name="SUBJECT" value="r-xsilva-facilitator@ig.com.br">
			<input type="submit" name="METHOD" value="DoExpressCheckoutPayment">
			<input type="hidden" name="TOKEN" value=<%=request.getParameter("token")%>>
			<input type="hidden" name="PAYERID" value=<%=request.getParameter("PayerID") %>>
			<input type="hidden" name="NOTIFYURL" value="http://177.101.60.34/tecedu-prod/servlet/Controller">
			<input type="hidden" name="PAYMENTREQUEST_0_PAYMENTACTION" value="SALE">
			<input type="hidden" name="PAYMENTREQUEST_0_AMT" value="22.00">
			<input type="hidden" name="PAYMENTREQUEST_0_CURRENCYCODE" value="BRL">
			<input type="hidden" name="PAYMENTREQUEST_0_ITEMAMT" value="22.00">
			<input type="hidden" name="PAYMENTREQUEST_0_INVNUM" value="1234-21">
			<input type="hidden" name="PAYMENTREQUEST_0_CUSTOM" value="teste de custom">
			<input type="hidden" name="L_PAYMENTREQUEST_0_NAME0" value="Item A">
			<input type="hidden" name="L_PAYMENTREQUEST_0_DESC0" value="Produto A - 110V">
			<input type="hidden" name="L_PAYMENTREQUEST_0_NUMBER0" value="id_camisa">
			<input type="hidden" name="L_PAYMENTREQUEST_0_AMT0" value="11.00">
			<input type="hidden" name="L_PAYMENTREQUEST_0_QTY0" value="1">
			<input type="hidden" name="L_PAYMENTREQUEST_0_ITEMAMT" value="11.00">
			<input type="hidden" name="L_PAYMENTREQUEST_0_NAME1" value="Item B">
			<input type="hidden" name="L_PAYMENTREQUEST_0_DESC1" value="Produto B - 220V">
			<input type="hidden" name="L_PAYMENTREQUEST_0_AMT1" value="11.00">
			<input type="hidden" name="L_PAYMENTREQUEST_0_QTY1" value="1">
			<input type="hidden" name="PAYMENTREQUEST_0_SHIPTONAME" value="Comprador comprador">
			<input type="hidden" name="PAYMENTREQUEST_0_SHIPTOSTREET" value="R1 Main St">
			<input type="hidden" name="PAYMENTREQUEST_0_SHIPTOCITY" value="San Jose">
			<input type="hidden" name="PAYMENTREQUEST_0_SHIPTOSTATE" value="CA">
			<input type="hidden" name="PAYMENTREQUEST_0_SHIPTOZIP" value="95131">
			<input type="hidden" name="PAYMENTREQUEST_0_SHIPTOCOUNTRYCODE" value="US">
		</form>
</body>
</html>