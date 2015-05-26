package ru.juga.dev.matrix.webapp.filter;


import java.util.StringTokenizer;
import matrix.*;


public class MatrixPOST{

public static Matrix parse(String str){


int m=0;
int n=0;


String []resultStr = null;

str = str.replaceAll("[[^/\r\n-]&&[\\D]]"," ");
str = str.replaceAll("-"," -");
str = str.replaceAll("-\\D"," ");


StringTokenizer stroki = new StringTokenizer(str, "\r\n");
m = stroki.countTokens();
StringTokenizer []el = new StringTokenizer[m];
for (int i = 0, t =0; i < m; i++){
		el[i] = new StringTokenizer(stroki.nextToken());
		t = el[i].countTokens();

		if (t==0) {
			  i--; // удаление текущей строки т. к. нет эл-ов
			  m--; 
			  }
			  else if (t > n) n = t;
}//for
	resultStr = new String[m*n];
for (int j = 0, t=0, ct; j < m; j++){
ct = el[j].countTokens();
	while(el[j].hasMoreTokens()) resultStr[t++] = el[j].nextToken();

	if (ct<n) 
		for(int i=1; i<=n-ct; i++){
		resultStr[t++] = "0";
		}
}
if (m*n==0) return null;
	try{
	Matrix result = new Matrix(m,n,resultStr);
	return result;
	}catch(Exception ex){
	return null;
	}
}

}