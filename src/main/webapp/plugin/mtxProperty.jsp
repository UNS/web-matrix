
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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