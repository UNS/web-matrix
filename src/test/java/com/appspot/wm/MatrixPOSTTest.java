package com.appspot.wm;

import junit.framework.*;

public class MatrixPOSTTest extends TestCase{

public void testPOST(){
assertEquals(MatrixPOST.parse("4 3\r\n2 1"), new Matrix("2;2;4;3;2;1"));
assertEquals(MatrixPOST.parse("4 5\r\n6 7"),new Matrix("2;2;4;5;6;7"));
assertEquals(MatrixPOST.parse("4 5\r\n6 7\r\n\r\n       \r\n\r\n"),new Matrix("2;2;4;5;6;7"));
}


public void testKrivo(){
assertEquals(MatrixPOST.parse("4 5 6\r\n6 7"),new Matrix("2;3;4;5;6;6;7;0"));
assertEquals(MatrixPOST.parse("4\r\n6 7 4\r\n\r\n"),new Matrix("2;3;4;0;0;6;7;4"));
}

public void testLetter(){
assertEquals(MatrixPOST.parse("4df3ddf\r\ndf   dfn2x 1"), new Matrix("2;2;4;3;2;1"));
}

}
