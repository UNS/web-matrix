package matrix;

import junit.framework.*;

public class TestQ extends TestCase{


//todo Q defalut = 0 value



public void testCreateFromString(){
Q a = new Q("-1/-2");
Q b = new Q("2/4");
Q c = new Q("1/3");
Q d = new Q("-1/3");
Q e = new Q("-15");
Q g = new Q("15/-1");

assertEquals(a.equals(b), true);
assertEquals(a.equals(c), false);
assertEquals(b.equals(c), false);
assertEquals(d.equals(c), false);
assertEquals(e.equals(g), true);



assertEquals(a.toString(), "1/2");
assertEquals(d.toString(), "-1/3");
assertEquals(e.toString(), "-15");


}



public void testEquals(){
assertEquals(new Q("15"), new Q(15));
assertEquals(new Q("15"), new Q("-15/-1"));
}


public void testShorten(){
Q q = new Q("100/200");
assertEquals(   q.shorten().toString(), 
	     (new Q("1/2")).toString());
}


public void testTrans(){
Q a = new Q(1);
Q b = new Q("1");
//Q c = new Q(0,5);
assertEquals(a.equals(b), true);
}


public void testGetValue(){
Q a = new Q(100);
Q b = new Q(-500);
//Q c = new Q(0,5);
assertEquals(a.getInt(), 100);
assertEquals(a.getInt()!=5, true);
assertEquals(b.getInt(), -500);

}



public void testSum(){
Q a = new Q("1/2");
Q b = new Q("1/3");
Q c = new Q("5/6");

assertEquals(Q.sum(new Q("1/2"),new Q("1/2")), new Q("1"));
assertEquals(Q.sum(new Q("1/3"),new Q("1/2")), new Q("5/6"));
assertEquals(Q.sum(new Q("50"),new Q("-1")), new Q("49"));
assertEquals(Q.sum(new Q("16"),new Q("-1/16")), new Q("255/16"));
assertEquals(Q.sum(new Q("0"),new Q("256")), new Q("256"));
assertEquals(Q.sum(new Q("0"),new Q("-14/23")), new Q("-14/23"));


assertEquals(Q.sum(new Q("13/-17"),new Q("-24/43")), Q.sum(new Q("-24/43"),new Q("13/-17")));
}


public void testMult(){
assertEquals(Q.mult(new Q("1/2"),new Q("1/3")),	 new Q("1/6"));
assertEquals(Q.mult(new Q("1/2"),new Q("-2/1")), new Q("-1"));
assertEquals(Q.mult(new Q("0"),new Q("-2/1")),	 new Q("0"));
assertEquals(Q.mult(new Q("0"),new Q("500")),	 new Q("0"));
assertEquals(Q.mult(new Q("5"),new Q("5")), new Q("25"));
assertEquals(Q.mult(new Q("10"),new Q("1/10")), new Q("1"));
}



}