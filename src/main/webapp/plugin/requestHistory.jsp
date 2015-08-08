
<%@page import="com.googlecode.objectify.ObjectifyService"%>
<%@page import="java.util.List"%>
<%@page import="com.appspot.wm.Record"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>



<%
	List<Record> records = ObjectifyService.ofy().load().type(Record.class).order("-date").limit(10).list();
	System.out.println("records size " + records.size());
	out.println("<table cellspacing='1' width='100%'>");
	out.println("<TR>");
	out.println("<TD align='center' width='110' bgcolor='#FFFFF1'>ÐÑÐµÐ´ÑÐ´ÑÑÐ¸Ðµ Ð·Ð°Ð¿ÑÐ¾ÑÑ:");
	out.println("<TD align='left' bgcolor='#FFFFFF'>");
	for (Record r : records) {
		if (r.postBody != null) {
		out.println("<TR><TD align='center' width=110 bgcolor='#FFFFF1'>");
		out.println("<TD align='left' bgcolor='#FFFFFF'>");
		out.println(r.postBody.replaceAll("\r\n", "<br>\r\n"));
		}
	}
%>
</table>
