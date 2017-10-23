package com.sample.basics;

import java.util.HashSet;
import java.util.Set;

/**
 * implement addTask, getList, have a service to send notification if its due..
 * mark_done
 * 
 * @author chandrasekhar
 *
 */
public class Sample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("1");
		set.add("2");
		
		System.out.println(set.toString());
	}
}