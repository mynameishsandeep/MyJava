package com.sample.datastructure;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	static Map<Integer, Integer> cache = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(fibRecursive(10));
		System.out.println(fibWhile(10));
		System.out.println(fibMemoization(10));
	}

	public static int fibRecursive(int n) {
		if (n <= 1) {// Exit Condition
			return n;
		} else {
			// Recursive case
			return (fibRecursive(n - 1) + fibRecursive(n - 2));
		}
	}

	/**
	 * Copied from Book Elements of Programming Interviews. Page 303 
	 */
	private static int fibMemoization(int n) {
		if (n <= 1) {
			return n;
		} else if (!cache.containsKey(n)) {
			cache.put(n, fibMemoization(n - 2) + fibMemoization(n - 1));
		}
		return cache.get(n);
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
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = fNMinus2 + fNMinus1;
			fNMinus2 = fNMinus1;
			fNMinus1 = result;
		}
		return result;
	}
}
