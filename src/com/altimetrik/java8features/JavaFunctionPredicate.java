package com.altimetrik.java8features;

import java.util.function.Predicate;

public class JavaFunctionPredicate {

	public static void main(String[] args) {

		System.out.println(testPredicate((a) -> a < 100));
		System.out.println(testPredicate((a) -> a < 102));
	}

	public static boolean testPredicate(Predicate<Integer> data) {
		return data.test(101);
	}
}
