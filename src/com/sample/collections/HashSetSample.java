package com.sample.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetSample {
	public static void main(String[] args) {
		Set<String> s1 = new HashSet<>(Arrays.asList("a","b"));
		Set<String> s2 = new HashSet<>();
		s2.add("a");
		s2.add("b");
		if(s1.containsAll(s2)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
