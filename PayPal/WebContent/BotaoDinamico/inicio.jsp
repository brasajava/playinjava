<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/Cookie.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript">   
            jQuery(document).ready(function(){
                //Pegamos o formulário do botão
                var wpsBn = jQuery('#formulario');
 
                //Interceptamos o clique no botão
                wpsBn.click(function(e){
                    //Evitamos o comportamento padrão, de submeter o formulário
                    e.preventDefault();
 
                    //Mostramos a mensagem de redirecionamento
                    jQuery('<div class="sa_payPal_overlay" style="visibility:visible;position:fixed; width:100%; height:100%; filter:progid:DXImageTransform.Microsoft.Gradient(GradientType=1, StartColorStr=\'#88ffffff\', EndColorStr=\'#88ffffff\'); background: rgba(255,255,255,0.8); top:0; left:0; z-index: 999999;"><div style=" background: #FFF; background-image: linear-gradient(top, #FFFFFF 45%, #E9ECEF 80%);background-image: -o-linear-gradient(top, #FFFFFF 45%, #E9ECEF 80%);background-image: -moz-linear-gradient(top, #FFFFFF 45%, #E9ECEF 80%);background-image: -webkit-linear-gradient(top, #FFFFFF 45%, #E9ECEF 80%);background-image: -ms-linear-gradient(top, #FFFFFF 45%, #E9ECEF 80%);background-image: -webkit-gradient(linear, left top,left bottom,color-stop(0.45, #FFFFFF),color-stop(0.8, #E9ECEF));display: block;margin: auto;position: fixed; margin-left:-220px; left:45%;top: 40%;text-align: center;color: #2F6395;font-family: Arial;padding: 15px;font-size: 15px;font-weight: bold;width: 530px;-webkit-box-shadow: 3px 2px 13px rgba(50, 50, 49, 0.25);box-shadow: rgba(0, 0, 0, 0.2) 0px 0px 0px 5px;border: 1px solid #CFCFCF;border-radius: 6px;"><img style="display:block;margin:0 auto 10px" src="https://www.paypalobjects.com/en_US/i/icon/icon_animated_prog_dkgy_42wx42h.gif"><h2>Aguarde alguns segundos.</h2> <p style="font-size:13px; color: #003171; font-weight:400">Você está sendo redirecionado para um ambiente seguro do PayPal<br /> para finalizar seu pagamento.</p><div style="margin:30px auto 0;"><img src="https://www.paypal-brasil.com.br/logocenter/util/img/logo_paypal.png"/></div></div></div>').appendTo('body');
 
                    //Submetemos o formulário após a exibição da mensagem
                    wpsBn.submit();
                });
            });
        </script>
<link rel="stylesheet" type="text/css" href="css/Botao.css"></link>
</head>
   <!--  <script>GerarCookie('Dados','4050','5');</script>-->
<body>
<% 
LinkedList<?> compra=(LinkedList<?>) request.getAttribute("compra");
%>
<div>
	<h1>Confirmação do pedido</h1>
	<div id="produtos">
		<h2>produtos</h2>
		<p> <%=compra.get(4) %></p>
		<p><%=compra.get(1) %></p>
	</div>
	<div id="quantidades">
		<h2>quantidade</h2>
		<p><%=compra.get(2) %></p>
		<p><%=compra.get(3) %></p>
	</div>
</div>
	<form method="post" action="https://sandbox.paypal.com/cgi-bin/webscr" style="top: 0px;" class="paypal-button" accept-charset="ISO-8859-1" id="formulario">
		<input type="hidden" name="cmd" value="_cart"> 
		<input type="hidden" name="upload" value="1">
		<input type="hidden" name="lc" value="BR">
		<ul>
			<li style="list-style-type: none">
				<input type="hidden" name="quantity_2" value=<%=compra.get(3) %>>
				<input type="hidden" name="item_name_2" value=<%=compra.get(4) %>> 
				<input type="hidden" name="item_number_2" value=id_<%=compra.get(4)%>>
				<input type="hidden" name="amount_2" value="3.00">
			</li>
			<li style="list-style-type: none">
				<input type="hidden" name="quantity_1" value=<%=compra.get(2) %>>
				<input type="hidden" name="item_name_1" value=<%=compra.get(1) %>>
				<input type="hidden" name="item_number_1" value=id_<%=compra.get(1) %>>
				<input type="hidden" name="amount_1" value="0.60">
			</li>
		</ul>
		<button type="submit" class="paypal-button large" >Comprar Agora</button>
		<input type="hidden" name="business" value="comerciante@email.com">
		<input type="hidden" name="charset" value="ISO-8859-1">
	    <input type="hidden" name="currency_code" value=<%=compra.get(0) %>>
	    <input type="hidden" name="lc" value="BR">
	   <input type="hidden" name="notify_url" value="http://95.62.66.227:8080/PayPal/Check"> 
	    <input type="hidden" name="cancel_return" value="http://localhost:8080/PayPal/cancelar.jsp">
		<input type="hidden" name="return" value="http://localhost:8080/PayPal/Final.jsp">
		<input type="hidden" id="teste" name="invoice" value="">
	</form>
<script>LerCookie('Dados');</script>
</body>
</html>