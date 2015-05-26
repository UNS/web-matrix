import java.util.regex.Pattern;
import java.sql.*;

public class Test{


public int arg(int []i){
System.out.println(i[0]);
return i.length;
}

public String toString(){
String result = new String();
for (int i=1; i<=10; i++){
	for (int j=1; j<=10; j++){
	result += ((i-1)*10+j+"\u0009");
	}//getElement(i,j)
	result += "!" + "\n";
	}
System.out.println(result);
return result;
}


public void ch(){
int []ch = new int[100];
int k=0;
ch[0]=2;
boolean b;
for (int i=2; i< 100; i++){
b = true;
	for (int j=0; j< k; j++){
	if (i%ch[j]==0) b = false; 
	}
	if (b) {
		ch[k++]=i;
		System.out.print(" "+ k+" "+i);
		}
	}
}

public boolean equals(Object anObject){
return true;
}

public boolean equals(int i){
return true;
}

public static void main(String []args){



double d = 1;
System.out.println(Double.MIN_VALUE==0);


}


/*
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
            "jdbc:mysql://localhost/matrix?useUnicode=true&characterEncoding=utf-8");
         Statement stmt = conn.createStatement();

	rs = stmt.executeQuery("show tables");

while(rs.next()) System.out.println(rs.getString(1));
 	 }
      catch(SQLException sqe) {
	sqe.printStackTrace();
      }



}
*/
//Pattern p new Patern;

//System.out.println("Hi 15 /Pridfvet-23\r\nHi 15 /Pridfvet23".replaceAll("[[^/\r\n-]&&[\\D]]","0"));

}