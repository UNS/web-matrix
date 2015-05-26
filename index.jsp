<html>
<body  bgcolor="#4C6C8F" link="#FFFFFG" vlink="#FFFFFG" alink="red">
<%@ taglib uri='mtx' prefix='util' %>

<%@ page import="ru.juga.dev.matrix.math.matrix.*" %>
<%@ page import="ru.juga.dev.matrix.webapp.db.*" %>
<%@ page import="ru.juga.dev.matrix.webapp.filter.*" %>


<%@ page contentType="text/html; charset=windows-1251" %>
<% 
Matrix A = null;
if (request.getParameter("inp_mtx")!=null){
A = MatrixPOST.parse(request.getParameter("inp_mtx")); 
DB thread = new DB(request.getParameter("inp_mtx"));
thread.start();
	}
%>
<!-- &nbsp&nbsp&nbspВведите элементы матрицы, через пробел.-->
<table width="100%" border="5" cellspacing="0" cellpadding="1" frame="below">
<tr>
<TD width="110" align="center" bgcolor="#FFFFFF"> <A HREF="http://matrix.dev.juga.ru/"> <img src="img/lab2.jpg" vspace="0" hspace="0"> </A>
<TD width="200" align="left"  bgcolor="#FFFFFG">
<form name="sendform" action="index.jsp" method="post">
<textarea name="inp_mtx" Rows="7" Cols="35">
<%if (A!=null){%>
<%= A %>
<%}%>
</textarea>
<TD  align="center"  bgcolor="#FFFFFG" valign="bottom">
 &nbsp&nbsp&nbspВведите элементы матрицы, через пробел.
<br>
<br>
<input type="submit" value="Вычислить">

</form>
</table>
<%
if (A!=null) 	{
%>
		<%@ include file='plugin/mtxProperty.jsp'%> 
 <% 
		}else {
 %>
		<%@ include file='plugin/requestHistory.jsp'%> 
<% 		} 
%>

<br>
<br>
<br>

<table cellspacing="1" width="100%">
<TR><Td>
<!--begin of Top100 logo-->
<a href="http://top100.rambler.ru/top100/">
<img src="http://top100-images.rambler.ru/top100/w1.gif" alt="Rambler's Top100" width=88 height=31 border=0></a>
<!--end of Top100 logo -->
<Td align="right">
<address><A HREF="mailto:nikolais@mail.ru">remaL©2004</A></address>
<TR>
</table>
<!--begin of Rambler's Top100 code -->
<a href="http://top100.rambler.ru/top100/">
<img src="http://counter.rambler.ru/top100.cnt?642655" alt="" width=1 height=1 border=0></a>
<!--end of Top100 code-->
</body>
</html>