
<%@ page import = "java.sql.*" %>




<%
ResultSet rs = null;
 try {

         Class.forName("com.mysql.jdbc.Driver");

      }
      catch(ClassNotFoundException e) {
        e.printStackTrace();
	out.println(e);
	out.println(e.getMessage());
      }
  Connection con = null;
      try {
         Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/matrix?useUnicode=true&characterEncoding=utf-8",
	 "matrix",
	 "jgNC4T");
         Statement stmt = conn.createStatement();

out.println("<table cellspacing='1' width='100%'>");
out.println("<TR>");
out.println("<TD align='center' width='110' bgcolor='#FFFFF1'>Предыдущие запросы:");
out.println("<TD align='left' bgcolor='#FFFFFF'>");

	rs = stmt.executeQuery("select * from postHistory");
rs.last();
rs.next();
int k=0;
	while(rs.previous()){

			out.println("<TR><TD align='center' width=110 bgcolor='#FFFFF1'>");
			out.println("<TD align='left' bgcolor='#FFFFFF'>");
			out.println(rs.getString("PostBody").replaceAll("\r\n","<br>\r\n"));
			}
 	
}
      catch(SQLException sqe) {
	out.println(sqe);
	out.println(sqe.getMessage());

      }

%>
</table>
