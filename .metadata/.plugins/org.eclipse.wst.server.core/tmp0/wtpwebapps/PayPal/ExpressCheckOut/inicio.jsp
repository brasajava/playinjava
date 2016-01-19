<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function teste()
	{
		var x=document.getElementsByTagName("input");
		x[6].value="SetExpressCheckout";
		document.getElementById("formulario").submit();
	}
</script>
</head>
<body>
	<div>
	  Moeda:<select id="moeda">
				<option value="0">BRL</option>
				<option value="1">USD</option>
				<option value="2">EUR</option>
			</select>
	</div>
	<div>
	Produto:<select id="produtos">
				<option value="0">Camisas</option>
				<option value="1">Computadores</option>
				<option value="2">Carros</option>
			</select>
		Quantidade:<input type="text" id="quantidade"></input>
	</div>
	<form method="post" action="https://api-3t.sandbox.paypal.com/nvp" target="_top" id="formulario">
		<input type="hidden" name="USER" value="steve_api1.loja.com">
		<input type="hidden" name="PWD" value="1368811655">
		<input type="hidden" name="SIGNATURE" value="AYacq1YPCqKd7UAo1WAWgSRsY-VNAgb3Mj96I7myUDv4WRYc7BJrwjX5">
		<input type="hidden" name="VERSION" value="93.0">
		<input type="hidden" name="SUBJECT" value="steve@loja.com">
		<input type="submit" name="METHOD" value="SetExpressCheckout">
		<input type="hidden" name="PAYMENTREQUEST_0_PAYMENTACTION" value="Sale">
		<input type="hidden" name="PAYMENTREQUEST_0_AMT" value="3.00">
		<input type="hidden" name="PAYMENTREQUEST_0_CURRENCYCODE" value="BRL">
		<input type="hidden" name="PAYMENTREQUEST_0_ITEMAMT" value="3.00">
		<input type="hidden" name="PAYMENTREQUEST_0_INVNUM" value="111-11">
		<input type="hidden" name="L_PAYMENTREQUEST_0_NAME0" value="camisa">
		<input type="hidden" name="L_PAYMENTREQUEST_0_DESC0" value="Camisa polo">
		<input type="hidden" name="L_PAYMENTREQUEST_0_AMT0" value="1.50">
		<input type="hidden" name="L_PAYMENTREQUEST_0_QTY0" value="2">
		<input type="hidden" name="L_PAYMENTREQUEST_0_ITEMAMT" value="1.50">
		<input type="hidden" name="RETURNURL" value="http://localhost:8081/PayPal/retorno.jsp">
		<input type="hidden" name="CANCELURL" value="http://PayPalPartner.com.br/CancelaFrete">
		<input type="hidden" name="BUTTONSOURCE" value = "BR_EC_EMPRESA">
	</form>
</body>
</html>