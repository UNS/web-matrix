<html>
    <body  bgcolor="#4C6C8F" link="#FFFFFG" vlink="#FFFFFG" alink="red">
        <%@ taglib uri='mtx' prefix='util' %>

        <%@ page import="com.appspot.wm.*" %>
	<%@ page import="com.googlecode.objectify.Key" %>
	<%@ page import="com.googlecode.objectify.ObjectifyService" %>


        <%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
        <% 
        Matrix A = null;
	String inp_mtx = request.getParameter("inp_mtx");
        if (inp_mtx != null) {
		A = MatrixPOST.parse(inp_mtx);
		Record record = new Record(inp_mtx, A);
		ObjectifyService.ofy().save().entity(record).now();
        }
        %>
        <!-- &nbsp&nbsp&nbspВведите элементы матрицы, через пробел.-->
	<form name="sendform" action="index.jsp" method="post">
	    <table width="100%" border="5" cellspacing="0" cellpadding="1" frame="below">
		<tr>
		    <TD width="110" align="center" bgcolor="#FFFFFF"> <A HREF="http://matrix.dev.juga.ru/"> <img src="img/lab2.jpg" vspace="0" hspace="0"> </A>
		    <TD width="200" align="left"  bgcolor="#FFFFFG">

			<textarea name="inp_mtx" Rows="7" Cols="35"><%if(A!=null) {%><%=A%><%}%></textarea>
		    <TD  align="center"  bgcolor="#FFFFFG" valign="bottom">
			&nbsp&nbsp&nbspВведите элементы матрицы, через пробел.
			<br>
			<br>
			<input type="submit" value="Вычислить">


	    </table>
	</form>
        <%
        if (A!=null) 	{
        %>
        <table cellspacing="1" width="100%">
	    <TR>
		<TD align="center" width="110" bgcolor="#FFFFF1">Матрица 
		<TD align="left" bgcolor="#FFFFFF">
	    <util:printMatrix matrix='<%= A%>' cellpadding="5"/>
	    <TR>
		<TD align="center" width="110" bgcolor="#FFFFF1"> Ранг матрицы 
		<TD align="left" bgcolor="#FFFFFF"> &nbsp&nbsp <%= A.getRang() %>
		    <%if (A.isKvadrat()){
		    Q det = A.getDet();
		    %>
	    <TR>
		<TD align="center" width="110" bgcolor="#FFFFF1"> Определитель 
		<TD align="left" bgcolor="#FFFFFF"> &nbsp&nbsp <%= det %>

		    <%if (!det.equals(new Q("0"))){%>
	    <TR>
		<TD align="center" width="110" bgcolor="#FFFFF1"> Обратная матрица
		<TD align="left" bgcolor="#FFFFFF">
	    <util:printMatrix matrix='<%= Matrix.reverse(A) %>' cellpadding="5"/>
	    <%}}%>
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
		    <Td align="right">
			<address><A HREF="mailto:nikolais@mail.ru">remaL©2004</A></address>
		<TR>
	    </table>
	    <!-- Yandex.Metrika counter -->
	    <script type="text/javascript">
                    (function (d, w, c) {
                        (w[c] = w[c] || []).push(function () {
                            try {
                                w.yaCounter31851751 = new Ya.Metrika({
                                    id: 31851751,
                                    clickmap: true,
                                    trackLinks: true,
                                    accurateTrackBounce: true,
                                    webvisor: true
                                });
                            } catch (e) {
                                    }
                        });

                        var n = d.getElementsByTagName("script")[0],
                                s = d.createElement("script"),
                                f = function () {
                                            n.parentNode.insertBefore(s, n);
                                    };
                        s.type = "text/javascript";
                        s.async = true;
                        s.src = "https://mc.yandex.ru/metrika/watch.js";

                        if (w.opera == "[object Opera]") {
                            d.addEventListener("DOMContentLoaded", f, false);
                        } else {
                                    f();
                            }
                    })(document, window, "yandex_metrika_callbacks");
	    </script>
	    <noscript><div><img src="https://mc.yandex.ru/watch/31851751" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
	    <!-- /Yandex.Metrika counter -->
    </body>
</html>
