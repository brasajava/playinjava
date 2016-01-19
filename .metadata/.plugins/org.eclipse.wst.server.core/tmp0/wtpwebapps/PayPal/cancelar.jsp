<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type='text/javascript'>
var request = { getParameter: _getParameter };

function _getParameter(querystring)
{
var querystr = new Array();
loc = window.location.search.substr(1).split('&');
if ((loc!='')&&(loc!=null)) {
for (var icnt=0;icnt< loc.length;icnt++)
{
var q = loc[icnt].split('=');
querystr[q[0]] = q[1];
}
return querystr[querystring];
}
else
{
return(null);
}
}
</script> 
<script type="text/javascript">
	function voltar()
	{
		window.history.back();
	}
</script>
</head>
<body>
<form action="Pagina-Inicial.jsp">
	<h2>deseja realmente desistir da compra?</h2>
	<input type="submit" value="SIM"/>
    <input type="button"  value="NÃO" onclick="voltar();"/>
</form>
</body>
</html>