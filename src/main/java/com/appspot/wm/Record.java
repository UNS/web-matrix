/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appspot.wm;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;
import com.googlecode.objectify.Key;
import java.util.Date;

/**
 *
 * @author remal
 */
@Entity
public class Record {

	@Id
	public Long id;
	public String postBody;
	@Index
	public Date date;
	public boolean hasMtx = false;
	public int mtxRang;
	
	public Record() {
		date = new Date();
	}
	
	public Record(String inp_mtx, Matrix m) {
		this.date = new Date();
		this.postBody = inp_mtx;
		if (m != null) {
			this.hasMtx = true;
			this.mtxRang = m.getRang();
		}
	}
}
