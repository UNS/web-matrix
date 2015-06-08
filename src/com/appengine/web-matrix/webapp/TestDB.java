package ru.juga.dev.matrix.webapp.db;

import junit.framework.*;


public class TestDB extends TestCase{

public void testDB(){
DB th = new DB("123");
th.start();
}

}