<table cellspacing="1" width="100%">
<TR>
<TD align="center" width="110" bgcolor="#FFFFF1">������� 
<TD align="left" bgcolor="#FFFFFF">
<util:printMatrix matrix='<%= A %>' cellpadding="5"/>
<TR>
<TD align="center" width="110" bgcolor="#FFFFF1"> ���� ������� 
<TD align="left" bgcolor="#FFFFFF"> &nbsp&nbsp <%= A.getRang() %>
<%if (A.isKvadrat()){
Q det = A.getDet();
%>
<TR>
<TD align="center" width="110" bgcolor="#FFFFF1"> ������������ 
<TD align="left" bgcolor="#FFFFFF"> &nbsp&nbsp <%= det %>

<%if (!det.equals(new Q("0"))){%>
<TR>
<TD align="center" width="110" bgcolor="#FFFFF1"> �������� �������
<TD align="left" bgcolor="#FFFFFF">
<util:printMatrix matrix='<%= Matrix.reverse(A) %>' cellpadding="5"/>
<%}}%>


</table>