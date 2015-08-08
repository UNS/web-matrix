package com.appspot.wm;

import junit.framework.*;


public class DBTest extends TestCase{

public void testDB(){
DB th = new DB("123");
th.start();
}

}