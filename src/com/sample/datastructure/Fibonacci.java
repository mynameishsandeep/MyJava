package com.sample.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * f(n) = { f(n-1) -f(n-2) } 
 */
public class Fibonacci {
	static Map<Integer, Integer> cache = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(fibRecursive(10));
		System.out.println(fibWhile(10));
		System.out.println(fibMemoization(10));
	}

	// Time Complexity is O(2^n)
	public static int fibRecursive(int n) {
		if (n <= 1) {// Exit Condition
			return n;
		} else {
			// Recursive case
			return (fibRecursive(n - 1) + fibRecursive(n - 2));
		}
	}

	private static int fibMemoization(int n) {
		if (n <= 1) {
			return n;
		}
		if (cache.containsKey(n)) {
			return cache.get(n);
		} else {
			Integer nMinus1 = fibMemoization(n - 1);
			cache.put(n-1, nMinus1);
			Integer nMinus2 = fibMemoization(n - 2);
			cache.put(n-2, nMinus2);
			return nMinus1 + nMinus2;
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
		int fN = 1;
		for (int i = 2; i <= n; i++) {
			fN = fNMinus2 + fNMinus1;
			fNMinus2 = fNMinus1;
			fNMinus1 = fN;
		}
		return fN;
	}
}
