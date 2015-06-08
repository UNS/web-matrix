package ru.juga.dev.matrix.math.matrix;

import junit.framework.*;


public class TestMatrix extends TestCase{

public void testForever(){
Matrix A = new Matrix(2,2);
assertEquals(A instanceof Matrix, true);
}



public void testCreate(){

Matrix A = new Matrix("3;3;1;2;3;4;5;6;7;8;9");

for(int i=1 ; i<=3; i++){
		for(int j=1 ; j<=3; j++){
		assertEquals(A.getElement(i,j).getInt(),j+3*(i-1));
		}}
}

public void testCreateByArray(){

Matrix A = new Matrix(3,3,"1;2;3;4;5;6;7;8;9".split(";"));

for(int i=1 ; i<=3; i++){
		for(int j=1 ; j<=3; j++){
		assertEquals(A.getElement(i,j).getInt(),j+3*(i-1));
		}}
}

public void testEquals(){

Matrix A = new Matrix("3;3;1;2;3;4;5;6;7;8;9");
Matrix B = new Matrix("3;3;1;2;3;4;5;6;7;8;9");
assertEquals(A.equals(B), true);
assertEquals(new Matrix("2;2;1/-4;2;-3;4"), new Matrix("2;2;-2/8;2;-3;4"));

}


public void testValue(){

Matrix A = new Matrix(5,5);
Matrix B = new Matrix(5,5);
	for(int i=1 ; i<=5; i++){
		for(int j=1 ; j<=5; j++){
	A.setElement(i,j,i*j);
	B.setElement(i,j,A.getElement(i,j));
	assertEquals(A.getElement(i,j), B.getElement(i,j));
	}}
}

public void testGetMinor(){
int i,j;
int []x;
int []y;
Matrix A = new Matrix(5,5);
Matrix minor;

for(i=1 ; i<=5; i++){
		for(j=1 ; j<=5; j++){
		A.setElement(i,j,j+5*(i-1));
		}}

// 1*1 минор
x = new int[1];
y = new int[1];
for(i=1 ; i<=5; i++){
		for(j=1 ; j<=5; j++){
		x[0]=i;
		y[0]=j;
		minor = A.getMinor(x,y);
		assertEquals(minor.getM()==1,true);
		assertEquals(minor.getN()==1,true);
		assertEquals((minor.getIntValue(1,1)==j+5*(i-1)),true);
		}}

x = new int[2];
y = new int[2];

for(i=1 ; i<=5; i++){
		for(j=i+1 ; j<=5; j++){
		x[0]=i; x[1]=j;
		y[0]=i; y[1]=j;
		minor = A.getMinor(x,y);

		assertEquals(minor.getM()==2,true);
		assertEquals(minor.getN()==2,true);
		assertEquals((minor.getIntValue(1,1)==i+5*(i-1)),true);
		assertEquals((minor.getIntValue(1,2)==j+5*(i-1)),true);
		assertEquals((minor.getIntValue(2,1)==i+5*(j-1)),true);
		assertEquals((minor.getIntValue(2,2)==j+5*(j-1)),true);
		}}

x = new int[3];
y = new int[3];
x[0]=1;x[1]=3;x[2]=5;
y[0]=1;y[1]=3;y[2]=5;
minor = A.getMinor(x,y);
	assertEquals(minor.getM()==3,true);
	assertEquals(minor.getN()==3,true);
for(i=1 ; i<=5; i+=2){
		for(j=1 ; j<=5; j+=2){
		assertEquals((minor.getIntValue((i+1)/2,(j+1)/2)==j+5*(i-1)),true);
		}}
}

// получение минора вычёркиванием указаных строк, столбцов
public void testGetAdvMinor(){
int []y = new int[2];
int []x = new int[2];
y[0]=1;y[1]=2;
x[0]=1;x[1]=2;

assertEquals((new Matrix("2;2;1;2;3;4")).getAdvMinor(1,1),new Matrix("1;1;4"));
assertEquals((new Matrix("3;3;1;2;3;4;5;6;7;8;9")).getAdvMinor(y,x),
	      new Matrix("1;1;9"));

}


//определитель
public void testDeterminat(){
//assertEquals((new Matrix("1/2;4;1/5;2")).getDet(), new Q("1/5"));//!!!!!!!!!!!!!!1

assertEquals(new Matrix("1;1;1").getDet(), new Q("1"));
assertEquals((new Matrix("2;2;1;2;3;4")).getDet(), new Q("-2"));

Matrix B = new Matrix(5,5);
for(int i=1 ; i<=5; i++){
		for(int j=1 ; j<=5; j++){
		B.setElement(i,j,j+5*(i-1));
		}}
assertEquals(B.getDet(), new Q("0"));

Matrix A = new Matrix("4;4;3;1;1;1;2;1;1;1;-8;5;9;5;-3;2;-2;-1");

assertEquals(A.getDet(),new Q("-12"));
}



public void testRang(){
Matrix A = new Matrix("4;5;2;-4;3;1;0;1;-2;1;-4;2;0;1;-1;3;1;4;-7;4;-4;5");
Matrix B = new Matrix("3;4;2;1;-2;3;-2;9;-4;7;-4;3;1;-1");
Matrix C = new Matrix("4;5;1;2;3;-2;0;2;3;1;-1;1;1;3;8;-5;-1;1;1;-2;1;1");
Matrix D = new Matrix("4;7;2;3;1;-2;-1;2;2;1;2;-1;-1;-1;-1;3;4;5;5;-4;-1;8;0;-1;0;-5;1;-1;-7;5");
Matrix E = new Matrix("5;6;2;-1;3;-2;1;2;-3;2;-1;1;-2;1;1;2;2;1;3;2;-1;-1;5;-5;-4;6;-5;11;1;7;4;6");
//!!

assertEquals(A.getRang()==3,true);
assertEquals(B.getRang()==2,true);
assertEquals(C.getRang()==2,true);
assertEquals(D.getRang()==2,true);
assertEquals((new Matrix("1;1;1")).getRang()==1,true);


}


// транспорирование
public void testTranspor(){
Matrix A = new Matrix(5,5);
for(int i=1 ; i<=5; i++){
		for(int j=1 ; j<=5; j++){
		A.setElement(i,j,j+5*(i-1));
		}}
A = Matrix.T(A);
for(int i=1 ; i<=5; i++){
		for(int j=1 ; j<=5; j++){
		assertEquals(A.getElement(j,i),new Q(j+5*(i-1)));
		}}
}


// обратная матрица
public void testReverse(){
Matrix A = new Matrix("2;2;1;2;3;4");
assertEquals(Matrix.mult(A,Matrix.reverse(A)),Matrix.createE(2));

Matrix B = new Matrix("3;3;-1;2;3;-6;5;-4;7;8;9");
assertEquals(Matrix.mult(B, Matrix.reverse(B)),
	     Matrix.mult(Matrix.reverse(B), B));

assertEquals(Matrix.reverse(new Matrix("1;1;1")), new Matrix("1;1;1"));
}



public void testSum(){
Matrix A = new Matrix("2;2;4;3;2;1");
Matrix B = new Matrix("2;2;1;2;3;4");
Matrix C = new Matrix("2;2;5;5;5;5");
assertEquals(C.equals(Matrix.sum(A,B)),true);
}

//умнозение матрицы на число
public void testScalMult(){
assertEquals(Matrix.mult(6,new Matrix("2;2;4;3;2;1")),
			new Matrix("2;2;24;18;12;6"));
}
	
public void testMultMatrix(){
Matrix A = new Matrix("2;2;4;9;-1;3");
Matrix B = new Matrix("2;2;1;-3;-2;1");
Matrix C = Matrix.mult(A,B);
assertEquals(C,new Matrix("2;2;-14;-3;-7;6"));
}

public void testE(){

assertEquals((new Matrix("2;2;1;0;0;1")).isE(),true);

for (int i=1; i<100; i+=10)
	assertEquals(Matrix.createE(i).isE(),true);
}
	
}