package com.sample.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * f(n) = { f(n-1) + f(n-2) }
 * 
 * Note: Printing fibonacci values in recursion is tricky. Because of recursion. 
 * Ex: For 6 result will be 0,1,1,2,3,5,8 
 * 
 * If you print n-1 in recursion, you will get one set of value. 0,1,1,2,3 // 5, 8 missed
 * If you print n-2 in recursion, you will get one set of value. 1,1,2,3,5 // 0 in beginning and 8 in end missed
 * If you print n in recursion, then another set of value. 1,2,3,5,8 // 0 and 1 missed
 * But none will print all values.
 * So to print all values print n(1,2,3,5,8) in recursion. Then print f(0) and f(1) manually  outside recursion. 
 * Fibonacci while loop also has the same logic that prints f(0) and f(1) manually outside for loop.
 * 
 */

public class FibonacciSeriesPrint {

	static Map<Integer, Integer> cache = new HashMap<>();

	public static void main(String[] args) {

		int n = 6;
		System.out.println("Print Fibonacci Series Using Recursion");
		// Print Fibonacci Series Using Recursion
		System.out.println(0);
		System.out.println(1);
		fibRecursive(n, new HashMap<>());
		System.out.println("Print Fibonacci Series Using While Loop");
		// Print Fibonacci Series Using While Loop
		fibWhile(n);
	}

	// Time Complexity is O(2^n)
	public static int fibRecursive(int n, Map<Integer, Integer> map) {
		if (n <= 1) {// Exit Condition
			return n;
		} else {
			if (map.containsKey(n)) {
				return map.get(n);
			} else {
				// Recursive case
				Integer result = fibRecursive(n - 1, map) + fibRecursive(n - 2, map);
				map.put(n, result);
				System.out.println(result);
				return result;
			}
		}
	}

	/*
	 * f(n) = fNMinus2+fNMinus1;
	 */
	public static int fibWhile(int n) {
		if (n <= 1) {
			return n;
		}
		int fNMinus2 = 0;
		int fNMinus1 = 1;
		System.out.println(fNMinus2);
		System.out.println(fNMinus1);
		int fN = 1;
		for (int i = 2; i <= n; i++) {
			fN = fNMinus2 + fNMinus1;
			fNMinus2 = fNMinus1;
			fNMinus1 = fN;
			System.out.println(fN);
		}
		return fN;
	}

}
