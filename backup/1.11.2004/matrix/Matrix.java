package matrix;
import java.util.StringTokenizer;
import java.lang.Math;
public class Matrix
{

private int m;
private int n;
private int det;
private Q [][] A;



/**
* матрица на основе строки
* 1 2 3
* 4 5 6
* 2;3;1;2;3;4;5;6
*/
public Matrix(String s){

StringTokenizer st = new StringTokenizer(s,"; ");

m = Integer.parseInt(st.nextToken());
n = Integer.parseInt(st.nextToken());

A = new Q[m][n];  
for(int i = 0; i < m; i++){
	for(int j = 0; j < n; j++){
	A[i][j] = new Q(st.nextToken());
	}}
}

public Matrix(int m, int n, String []value){//!test
this.m = m;
this.n = n;
A = new Q[m][n];
for(int i = 0; i < m; i++){
	for(int j = 0; j < n; j++){
	A[i][j] = new Q(value[i*n + j]);
	}}
}



//комент !!
/**
* создание 'нулевой' матриый порядка mxn
*/
public Matrix(int m,int n){
this.m = m;
this.n = n;
A = new Q[m][n];

for(int i = 0; i < m; i++){
	for(int j = 0; j < n; j++){
	A[j][i] = new Q(0);
	}}
}



/**
* Присвоение  i,j елементу матрицы значения
*/
public boolean setElement(int i, int j, int value){
A[i-1][j-1] = new Q(value);
return true;
}

public boolean setElement(int i, int j, Q value){
A[i-1][j-1] = value;
return true;
}



/**
*Является ли матрица единичной
*/
public boolean isE(){
int t=0;
if (isKvadrat()) {
	for (int i=0;i<m; i++)
	for (int j=0;j<n; j++){
		if (i==j) { 
			     if (!A[i][j].equals(new Q("1"))) t=1;}
			else if (!A[i][j].equals(new Q("0"))) t=1;
		}
if (t==1) return false;
return true;
}
return false;
}

/**
 *Является ли матрица равностороней:)
 */
public boolean isKvadrat(){//!!!!rename
	if (m==n) return true;
return false;
}

/**
 *Количевто строк
 *(элементов в столбце)
 */
public int getM(){
return m;
}

/**
 *Количевто столбцов
 *(элементов в строке)
 */
public int getN(){
return n;
}


/**
 * Возвращает i,j элемент матрицы
 *	i строка 
 *	j столбец
 */
public Q getElement(int i,int j){
return A[i-1][j-1];
}

/**
 * Возвращает i,j элемент матрицы
 *	i строка 
 *	j столбец
 */
public int getIntValue(int i,int j){
return A[i-1][j-1].getInt();
}

public int getIntDet(){
return getDet().getInt();
}

/**
* Нахождение определителя
*/
public Q getDet(){ // !!! добавить условие равносторонности
if (getM()*getN()==1) return A[0][0];
int []y = new int[getM()-1];
int []x = new int[getN()-1];
int k,l;
Q result = new Q(0);

	for(int t=1;t<=getM();t++){
	k=0; 
	l=0;
		for(int i=1;i<=getM();i++){
			if (i!=1) x[i-2]=i;
			if (i!=t) y[k++]=i;
			}
		result= Q.sum(result,
		              Q.mult(
				    Q.mult(
				          getMinor(y,x).getDet(),
				          (new Q((int)Math.pow(-1,1+t))
				          )),//mult
				    getElement(t,1)
				    )//mult
			      );//sum
	}
return result;
}

/**
 * Ранг матрицы
 */
public int getRang(){
int []y = new int[0];
int []x = new int[0];
return rangCalc(0,y,x);
}


// рекурсивное вычисление ранга
private int rangCalc(int t,int []y,int []x){
int []newY = new int[t+1];
int []newX = new int[t+1];
for (int k=0; k<y.length; k++){
newY[k] = y[k];
newX[k] = x[k];
}
for (int i=1; i<=m; i++){
if (include(i,y)) continue;
	for (int j=1; j<=n; j++){
	if (include(j,x)) continue;
	newX[t]=j;
	newY[t]=i;
	if (!getMinor(newY,newX).getDet().equals(new Q("0"))) 
		return rangCalc(t+1,newY,newX);
	}} 
return t;
}

// содержится ли значение переменной в масиве
private boolean include(int a, int []m){
for (int i=0; i < m.length; i++) 
	if (m[i]==a) return true;
return false;
}

/**
* строкиа на основе матрици
* 1 2 3
* 4 5 6
* 2;3;1;2;3;4;5;6
*/
public String getStringValue(){
String result;
result = m + ";" + n +";";
for (int i=1; i<=m; i++){
	for (int j=1; j<=n; j++){
	result += getElement(i,j)+";";
	}
}
return result;
}

public String toString(){
String result = new String();
for (int i=1; i<=m; i++){
	for (int j=1; j<=n; j++){
	result += (getElement(i,j)+"\u0009");
	}
	result += "\n";
	}
return result;
}


//коменты!
/**
* Минор, пересечение указаных строк, столбцов.
*/
public Matrix getMinor(int []a, int []b){ //!!! добавить обработку бредовых запросов
Matrix minor = new Matrix(a.length,b.length);
for (int i=1; i<=a.length; i++){
	for (int j=1; j<=b.length; j++){
	minor.setElement(i,j,getElement(a[i-1],b[j-1]));
	}
}
return minor;
}


//коменты!
/**
* Минор, вычёркивание указаных строк, столбцов.
*/
public Matrix getAdvMinor(int []a, int []b){ //!!! добавить обработку бредовых запросов
int []y = new int[m-a.length];
int []x = new int[n-b.length];
int k=0;
int l=0;
for (int i=1; i<=m; i++){
if (a[k]==i) { 
		if (a.length>k+1) k++;
		}else y[l++] = i;
}
k = 0;
l = 0;

for (int j=1; j<=n; j++){
if (b[k]==j) { 
		if (b.length>k+1) k++;
		}else x[l++] = j;
}
return getMinor(y,x);
}

//коменты!
/**
* Минор, вычёркивание указаных строк, столбцов.
*/
public Matrix getAdvMinor(int a, int b){ //!!! добавить обработку бредовых запросов
int []y = new int[1];
int []x = new int[1];
y[0]=a; x[0]=b;
return getAdvMinor(y, x);
}

//коменты!
/**
* Алгебралическое дополнение, элемента i,j
*/
public Q getAlgAdv(int i, int j){ //!!! добавить обработку бредовых запросов
return Q.mult(
	     getAdvMinor(i, j).getDet(),
	     (int)Math.pow(-1,i+j)
	     );
}




// !??????????????!переделать
public boolean equals(Object anObject){
    if (anObject instanceof Matrix) {
	Matrix A = (Matrix)anObject;
	boolean b = true;
for (int i=1; i<=m; i++){
	for (int j=1; j<=n; j++){
	if (!getElement(i,j).equals(A.getElement(i,j))) b = false;
	}}
	return b;
	}
return false;
}

public static Matrix sum(Matrix A, Matrix B){ // !!равность размера матриц
int m = A.getM();
int n = A.getN();
Matrix C = new Matrix(m,n);

for (int i=1; i<=m; i++){
	for (int j=1; j<=n; j++){
	C.setElement(
		    i,
		    j,
		    Q.sum(
			 A.getElement(i,j),
			 B.getElement(i,j)
			 )
		    ); //setElement
	}}
return C;
}

public static Matrix mult(Matrix A, Matrix B){
Matrix C = new Matrix(B.getM(),B.getN());
Q t;
for (int i=1; i<=B.getM(); i++){
	for (int j=1; j<=B.getN(); j++){
		t= new Q("0");
		for (int k=1; k<=B.getM(); k++) 
			t = Q.sum(
				 t,
				 Q.mult(
				       A.getElement(i,k),
				       B.getElement(k,j)
				       )
				 ); //sum
		C.setElement(i,j,t);
	}}
return C;
}

public static Matrix mult(int scal, Matrix A){
int m = A.getM();
int n = A.getN();
Matrix C = new Matrix(m,n);

for (int i=1; i<=m; i++){
	for (int j=1; j<=n; j++){
	C.setElement(i,j,
		     Q.mult(
			   scal,
 			   A.getElement(i,j)
			   )
		     ); //setElement
	}}
return C;
}


public static Matrix mult(Q q, Matrix A){
int m = A.getM();
int n = A.getN();
Matrix C = new Matrix(m,n);

for (int i=1; i<=m; i++){
	for (int j=1; j<=n; j++){
	C.setElement(i,j,Q.mult(q, A.getElement(i,j)));
	}}
return C;
}


/**
 * Обратная матрица
 */
public static Matrix reverse(Matrix A){
if (A.getM()!=A.getN()) return null;
Q det = A.getDet();
if (det.equals(new Q(0))) return null;
Matrix B = new Matrix(A.getN(), A.getN());

if (A.getM()==1) {
	Q q = A.getElement(1,1);
	B.setElement(1,1,new Q(q.getN(), q.getZ()));
	return B;
	}

for (int i=1; i<=B.getM(); i++){
	for (int j=1; j<=B.getN(); j++){
	B.setElement(i,j,A.getAlgAdv(i, j));
	}}

return mult(new Q(det.getN(),det.getZ()),T(B));
}

public static Matrix T(Matrix A){
Matrix B = new Matrix(A.getN(),A.getM());
for (int i=1; i<=B.getM(); i++){
	for (int j=1; j<=B.getN(); j++){
	B.setElement(i,j,A.getElement(j,i));
	}}
return B;
}

/*
создает еденичную матрицу порядка m
*/
public static Matrix createE(int m){
Matrix A = new Matrix(m,m);
for (int i=1; i<=m;i++) A.setElement(i,i,1);
return A;
}

}