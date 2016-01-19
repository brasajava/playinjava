<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Filter.PayPal" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

PayPal paypal=(PayPal)request.getAttribute("paypal");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Pagina-Inicial.jsp">
<h1>Dados enviados do paypal</h1>
<p>Status da transação:<%=paypal.getStatusTransacao()%></p>
<p>Valor: <%=paypal.getValor() %></p>
<p>Email: <%=paypal.getReferencia() %></p>
<p>
<input type="submit" value="aperte"/>
</form>
</body>
</html>