package com.sample.generics;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		Set<? super Number> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<String>();
		set1.add(new Integer("10"));

	}

}
