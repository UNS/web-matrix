package matrix;
import java.util.StringTokenizer;
import java.lang.Math;

/** 
 * –ациональный числа z/n 
 * z - целое, n - натуральное
 * 	
 */

public class Q
{
private long z;
private long n;

public Q(String value){
 StringTokenizer st = new StringTokenizer(value,"/");
setZ(Long.parseLong(st.nextToken()));
if (st.hasMoreTokens()) setN(Long.parseLong(st.nextToken()));
	else setN(1);
}



public Q(long value){
setZ(value);
setN(1);
}

public Q(int value){
setZ(value);
setN(1);
}



public Q(int z,int n){
setZ(z);
setN(n);
}

public Q(long z,long n){
setZ(z);
setN(n);
}


//public Q(double){todo}



public boolean equals(Object anObject){
    if (anObject instanceof Q) {
	Q q = (Q)anObject;
	return (getDouble()==q.getDouble());
	}
return false;
}

public String toString(){
if (getZ() == 0) return "0";
if (java.lang.Math.abs(getZ()) == java.lang.Math.abs(getN())) 
	if (getZ()>0) return "1";
		else return "-1";
if (getN() == 1) return Long.toString(getZ());
return (getZ() +  "/"+ getN());
}


public long getZ(){//!!!
return z;
}

public long getN(){//!!
return n;
}

public void setZ(int newZ){//!!!
z = newZ;
}

public void setZ(long newZ){//!!!
z = newZ;
}


public void setN(int newN){//!!
if (newN < 0) {
		setZ(getZ()*-1);
		newN*=-1;
		}
n = (newN == 0) ? 1 : newN;
}

public void setN(long newN){//!!
if (newN < 0) {
		setZ(getZ()*-1);
		newN*=-1;
		}
n = (newN == 0) ? 1 : newN;
}



public int getInt(){
return (int)(z/n);
}

public double getDouble(){
return ((double)z/n);
}


private static int []pch = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};

public Q shorten(){   //todo!!!!! optim
if (n==1) return new Q(getZ(),1);
if (z==0) return new Q(0,1);
Q q = new Q(getZ(),getN());

for(int i=0; i<25; i++){
	if ((q.getZ()%pch[i]==0)&
	    (q.getN()%pch[i]==0)) {
			q = (new Q(q.getZ()/pch[i],q.getN()/pch[i])).shorten();
			i=25;//!!!!!
			}
	}
return q;
}


public static Q mult(int a,Q b){//!!!!
return (new Q(a*b.getZ(),b.getN())).shorten();
}

public static Q mult(Q b, int a){
return mult(a, b);
}


public static Q mult(Q a,Q b){//!!!!
return (new Q(a.getZ()*b.getZ(),(a.getN()*b.getN()))).shorten();
}

public static Q sum(Q a,Q b){//!!!!!
if (a.getN()==b.getN()) return (new Q(a.getZ() + b.getZ(),a.getN())).shorten();
return (new Q(a.getZ()*b.getN() + b.getZ()*a.getN(), a.getN()*b.getN())).shorten();
}

}