
/*
Exemplo:
- Cria o cookie 'CookieTeste' com o valor 'HellowWorld!' que ir� expirar quando o browser for fechado.
GerarCookie('CookieTeste', 'HellowWorld!', 0);
- L� o conte�do armazenado no cookie.
LerCookie('CookieTeste');
- Excl�i o cookie.
ExcluirCookie('CookieTeste');
*/
 
// Fun��o para criar o cookie.
// Para que o cookie seja destru�do quando o brawser for fechado, basta passar 0 no parametro lngDias.
function GerarCookie(strCookie, strValor, lngDias)
{
var dtmData = new Date();
var strExpires = "";
 
if(lngDias)
{
dtmData.setTime(dtmData.getTime() + (lngDias * 24 * 60 * 60 * 1000));

strExpires = "; expires=" + dtmData.toGMTString();
}
else
{
//var strExpires = "";
}
document.cookie = strCookie + "=" + strValor + strExpires + "; path=/";
}
 
// Fun��o para ler o cookie.
function LerCookie(strCookie)
{
var strNomeIgual = strCookie + "=";
var arrCookies = document.cookie.split(';');
 
for(var i = 0; i < arrCookies.length; i++)
{
var strValorCookie = arrCookies[i];
while(strValorCookie.charAt(0) == ' ')
{
strValorCookie = strValorCookie.substring(1, strValorCookie.length);
}
if(strValorCookie.indexOf(strNomeIgual) == 0)
{
var conteudo=strValorCookie.substring(strNomeIgual.length, strValorCookie.length);
var valor=parseInt(conteudo);
document.getElementById('teste').value=valor+1;
GerarCookie(strCookie,valor+1,'5');
return;
}
}
return null;
}
 
// Fun��o para excluir o cookie desejado.
function ExcluirCookie(strCookie)
{
GerarCookie(strCookie, '', -1);
}
