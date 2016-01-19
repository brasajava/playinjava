<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Pal</title>
<script type="text/javascript">
	function atributos()
	{
		var x=document.getElementsByTagName("input");
		var produto=parseInt(document.getElementById("produtos").value);
		var moeda=parseInt(document.getElementById("moeda").value);
		var quantidade=document.getElementById("quantidade").value;
		
		switch (moeda)
		{
		case 0:
			x[5].value="BRL";
			break;
		case 1:
			x[5].value="USD";
			break;
		case 2:
			x[5].value="EUR";
			break;
		}
		
		switch (produto)
		{
		case 0:
			x[4].value=1.50;
			x[2].value="camisa";
			break;
		case 1:
			x[4].value=90.00;
			x[2].value="computador";
			break;
		case 2:
			x[4].value=300.00;
			x[2].value="carro";
			break;
		}
		x[3].value=quantidade;
		form.submit();
	}
</script>
<style type="text/css">
	
.paypal-button {
    white-space: nowrap;
}
.paypal-button button {
    background: none repeat scroll 0 0 #FFA823;
    border: 1px solid #FFA823;
    border-radius: 13px 13px 13px 13px;
    color: #0E3168;
    cursor: pointer;
    font-family: "Arial",bold,italic;
    font-style: italic;
    font-weight: bold;
    overflow: hidden;
    position: relative;
    text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
    white-space: nowrap;
    z-index: 0;
}
.paypal-button button:before {
    background: -moz-linear-gradient(center top , #FFAA00 0%, #FFAA00 80%, #FFF8FC 100%) repeat scroll 0 0 transparent;
    border-radius: 11px 11px 11px 11px;
    content: " ";
    height: 100%;
    left: 0;
    position: absolute;
    top: 0;
    width: 100%;
    z-index: -2;
}
.paypal-button button:after {
    background: -moz-linear-gradient(center top , #FEFEFE 0%, #FED994 100%) repeat scroll 0 0 transparent;
    border-radius: 40px 40px 38px 38px;
    content: " ";
    height: 60%;
    left: 0;
    position: absolute;
    top: 0;
    transform: translateX(1%);
    width: 98%;
    z-index: -1;
}
.paypal-button button.small {
    font-size: 12px;
    padding: 3px 15px;
}
.paypal-button button.large {
    font-size: 14px;
    padding: 4px 19px;
}
</style>
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
	<form class="paypal-button" method="post" action="https://sandbox.paypal.com/cgi-bin/webscr" target="_top">
		<input type="hidden" name="button" value="buynow">
		<input type="hidden" name="item_name" value="camisa">
		<input type="hidden" name="quantity" value="2">
		<input type="hidden" name="amount" value="1.50">
		<input type="hidden" name="currency_code" value="BRL">
		<input type="hidden" name="shipping" value="0.00">
		<input type="hidden" name="tax" value="0.00">
		<input type="hidden" name="return" value="http://localhost:8081/PayPal/retorno.jsp"/>  
		<input type="hidden" name="notify_url" value="http://localhost:8081/PayPal/retorno.jsp">
		<input type="hidden" name="RETURNURL" value="http://localhost:8081/PayPal/retorno.jsp">
		<input type="hidden" name="PAYMENTREQUEST_0_INVNUM" value="1234">
		<input type="hidden" name="env" value="sandbox">
		<input type="hidden" name="cmd" value="_xclick">
		<input type="hidden" name="business" value="r-xsilva-facilitator@ig.com.br">
		<input type="hidden" name="bn" value="JavaScriptButton_buynow">
		<button class="paypal-button large" name="METHOD" value="SetExpressCheckout" onclick="atributos();">Comprar agora</button>
	</form>
	
	
</body>
</html>




