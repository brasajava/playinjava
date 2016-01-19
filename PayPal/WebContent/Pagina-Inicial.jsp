<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt-br" lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />	
		<meta http-equiv="content-language" content="pt-br" />
		<link rel="stylesheet" href="css/estilo.css" type="text/css" media="screen" title="no title" charset="utf-8"/>
		<title>titulo</title>
	</head>
	<body id="corpo">
		<div id="tudo">
		<div id="topo">
		<h1>Ambiente de teste PayPal</h1>
		<ul id="lista">
			<li><a href="#">ANAMACO</a></li>
			<li><a href="#">CCF</a></li>
			<li><a href="#">EFIGIE</a></li>
			<li><a href="#">PECEGE</a></li>
			<li><a href="#">UDOF</a></li>
			<li><a href="#">UNIESP</a></li>
			<li><a href="#">VETOR</a></li>
		</ul>
		<form action="" method="get" id="busca">
			<label>Busca<input type="text" name="busca"/></label>
			<input type="submit" value="ok" id="submit"/>
		</form>
		</div><!-- fim da div topo-->
		<form action="Pedido" id="botao" method="post">
			<div id="principal">
				<h2>Moeda</h2>
				<p>Por Favor selecione a moeda com qual deseja efetuar o pagamento</p>
				<div>
					Moeda:<select id="moeda" name="moeda">
					<option value="BRL">BRL</option>
					<option value="USD">USD</option>
					<option value="EUR">EUR</option>
						</select>
				</div>
				<h2>Produto/Quantidade(s)</h2>
				<p>Escolha o produto que deseja comprar e informe a quantidade</p>
	<div id="listas">
		<div id="lista1">
		Produto:<select id="produtos" name="produtos">
					<option value="Ação">Ação</option>
					<option value="computador">Computadores</option>
					<option value="carro">Carros</option>
				</select>
			Quantidade:<input type="text" id="quantidade" name="quantidade" size="5px"></input>
		</div>
		
		<div id="lista2">
		Produto:<select id="produto" name="produto">
					<option value="mouse">Mouse</option>
					<option value="matrícula">matrícula</option>
					<option value="gravata">Gravata</option>
				</select>
			Quantidade:<input type="text" id="quantidade2" name="quantidade2" size="5px"></input>
		</div>
	</div>			
				
			</div><!--fim da div principal-->
		</form>
		<div id="auxiliar">
			<img src="imagens/Apple.jpeg" alt="apple" width="300px" height="350px"/>
			<p><a href="javascript:document.getElementById('botao').submit();">Finalizar Pedido</a></p>
		</div><!--fim da div auxiliar-->
		<div id="rodape">
			<p>direitos reservados Ricardo Xavier</p>
		</div><!--fim da div rodapé-->
		</div><!--fim da div tudo-->
	</body>
</html>