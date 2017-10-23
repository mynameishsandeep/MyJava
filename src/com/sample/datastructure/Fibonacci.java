package com.sample.datastructure;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(fibRecursive(10));
		System.out.println(fibWhile(10));

		map.put(0, 0);
		map.put(1, 1);

		System.out.println(fibMemoization(10));
	}

	public static int fibRecursive(int n) {
		if (n <= 0) { // Exit Condition
			return 0;
		} else if (n == 1) {// Exit Condition
			return 1;
		} else {
			// Recursive case
			return (fibRecursive(n - 1) + fibRecursive(n - 2));
		}
	}

	private static int fibMemoization(int n) {

		if (!map.containsKey(n - 1)) {
			int result = fibMemoization(n - 1);
			map.put(n - 1, result);
		}
		return map.get(n - 1) + map.get(n - 2);
	}

	public static int fibWhile(int n) {
		int result = 2;
		int previousResult = 1;
		int lastResult = 2;

		for (int i = 3; i < n; i++) {
			lastResult = result; // 2 3
			result = result + previousResult;// 3 5
			previousResult = lastResult;// 2 3
		}
		return result;
	}
}
