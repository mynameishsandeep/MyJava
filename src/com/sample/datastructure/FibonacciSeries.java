package com.sample.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fibonacci-number/submissions/
 * 
 * f(n) = f(n-1) + f(n-2)
 */

public class FibonacciSeries {

	static Map<Integer, Integer> cache = new HashMap<>();
	// Time Complexity is O(2^n) without memoization
	// Time Complexity is O(n) with memoization
	public static int fibRecursive(int n, Map<Integer, Integer> map) {
		if (n <= 1) {
			return n;
		} else {
			if (map.containsKey(n)) {
				return map.get(n);
			} else {
				Integer result = fibRecursive(n - 1, map) + fibRecursive(n - 2, map);
				map.put(n, result);
				return result;
			}
		}
	}

	/*
	 * 
	 * Below is base logic nbonacci
	 */
	public int fibonacci(int N) {
		if (N <= 1) {
			return N;
		}
		int result = 0;
		for (int i = 1; i <= 2; i++) {
			int currentResult = fibonacci(N - i);
			result += currentResult;
		}
		return result;
	}

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
