/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appspot.wm;

import javax.servlet.ServletContextListener;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import javax.servlet.ServletContextEvent;


/**
 *
 * @author remal
 */
public class OfyHelper implements ServletContextListener { 

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ObjectifyService.register(Record.class);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
		
}
