
<%@page import="java.util.List"%>
<%@page import="com.appspot.wm.Record"%>
<%@page import="com.googlecode.objectify.ObjectifyService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>


  <body  bgcolor="#4C6C8F" link="#FFFFFG" vlink="#FFFFFG" alink="red">
<%
		List<Record> records = ObjectifyService.ofy().load().type(Record.class).order("-date").list();
		System.out.println(records.size());
		out.println("<table cellspacing='1' width='100%'>");
		out.println("<TR>");
		out.println("<TD align='center' width='110' bgcolor='#FFFFF1'>ÐÑÐµÐ´ÑÐ´ÑÑÐ¸Ðµ Ð·Ð°Ð¿ÑÐ¾ÑÑ:");
		out.println("<TD align='left' bgcolor='#FFFFFF'>");
		for (Record r : records) {
			System.out.println(r.id);
			out.println("<TR><TD align='center' width=110 bgcolor='#FFFFF1'>");
			out.println("<TD align='left' bgcolor='#FFFFFF'>");
			if (r.postBody != null)
				out.println(r.postBody.replaceAll("\r\n", "<br>\r\n"));
			else
				out.println(r.date);
		}
%>
</table>
