package com.sample.basics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Dummy {

	public static void main(String[] args) {
		Dummy d = new Dummy();
		List<?> l = d.fun();
		Collection<? extends Object> c = new ArrayList<String>();
		//c.add("hello");
		
	}

	public List<?> fun() {
		List<String> l = new ArrayList<String>();
		l.add("Hello");
		return l;
	}

}
