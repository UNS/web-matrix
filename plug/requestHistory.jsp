
<%@ page import = "java.sql.*" %>




<%
ResultSet rs = null;
 try {

         Class.forName("com.mysql.jdbc.Driver");

      }
      catch(ClassNotFoundException e) {
         e.printStackTrace();
      }
  Connection con = null;
      try {
         Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/matrix?useUnicode=true&characterEncoding=utf-8",
	 "matrix",
	 "jgNC4T");
         Statement stmt = conn.createStatement();
	rs = stmt.executeQuery("select max(PostID) from PostHistory");

if (rs.next()){

out.println("<table cellspacing='1' width='100%'>");
out.println("<TR>");
out.println("<TD align='center' width='110' bgcolor='#FFFFF1'>Предыдущие запросы:");
out.println("<TD align='left' bgcolor='#FFFFFF'>");

	rs = stmt.executeQuery("select * from postHistory where PostID<="+rs.getString("max(PostID)"));
rs.last();
rs.next();
int k=0;
	while(rs.previous()){
if (k++>=10) break;
			out.println("<TR><TD align='center' width=110 bgcolor='#FFFFF1'>");
			out.println("<TD align='left' bgcolor='#FFFFFF'>");
			out.println(rs.getString("PostBody").replaceAll("\r\n","<br>\r\n"));
			}
 	 }
}//if
      catch(SQLException sqe) {
	out.println(sqe);
	out.println(sqe.getMessage());

      }

%>
</table>
