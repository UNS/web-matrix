package ru.juga.dev.matrix.webapp.db;

import java.sql.*;


public class DB extends Thread{
private String strValue;

public DB(String str){
strValue = str.replaceAll("[<>]","±");
}

public synchronized void run(){
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
		"jgNC4T"
		);

         Statement stmt = conn.createStatement();
String query = "INSERT INTO postHistory (PostBody) VALUES (\""+ strValue +"\")";
stmt.execute(query);
con.close();
	}
      catch(SQLException sqe) {
	sqe.printStackTrace();
      }
}

}