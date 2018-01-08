package com.altimetrik.java8features;

import java.util.function.Predicate;

/**
 * Predicate is similar to a Function, it accepts argume3vnt, but it can return only boolean value.

 * Predicate sends a function f1 to another function f2. Inside f2, we call
 * function.test(data), which calls f1(data). f1(data) applies data on f1(Ex:
 * greater than operation) and does return the result.
 */
public class LambdaFunctionPredicate {

	public static void main(String[] args) {

		Predicate<Integer> p = a -> (a < 100);
		//System.out.println(p.test(101));
		System.out.println(testPredicate(p, 50));

		Predicate<Integer> p1 = a -> {
			System.out.println("Some Operation");
			return a > 100;
		};
		System.out.println(testPredicate(p1, 100));
	}

	public static boolean testPredicate(Predicate<Integer> predicate, Integer data) {
		return predicate.test(data);
	}
}
