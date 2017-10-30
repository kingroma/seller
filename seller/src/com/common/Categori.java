package com.common;

import java.util.ArrayList;

public class Categori {
	ArrayList<String> list = new ArrayList<String>();
	public Categori(){
		list.add("book");
		list.add("bag");
		list.add("clothes");
		
	}
	
	public ArrayList<String> getList(){
		return list;
	}
}
