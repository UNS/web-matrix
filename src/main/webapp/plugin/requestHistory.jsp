
<%@page import="com.appspot.wm.MatrixPOST"%>
<%@page import="com.googlecode.objectify.ObjectifyService"%>
<%@page import="java.util.List"%>
<%@page import="com.appspot.wm.Record"%>
<%@taglib uri='mtx' prefix='util' %>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<table cellspacing='1' width='100%'>
	<TR>
	<TD align='center' width='110' bgcolor='#FFFFF1'>Предыдущие запросы:
	<TD align='left' bgcolor='#FFFFFF'>
	    <%
		    List<Record> records = ObjectifyService.ofy().load().type(Record.class).order("-date").limit(10).list();
		    for (Record r : records) {
			    if (r.hasMtx & (r.postBody != null)) {
				    pageContext.setAttribute("mtx", MatrixPOST.parse(r.postBody));
	    %>
	<TR>
	<TD align='center' width=110 bgcolor='#FFFFF1'>
	<TD align='left' bgcolor='#FFFFFF'> 
		<util:printMatrix matrix="${mtx}" cellpadding="5"/>
    <%
		    }
	    }
    %>
</table>
