package com.altimetrik.datastructure;

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fib(8));
		System.out.println(fibWhile(8));
	}

	public static int fib(int n) {
		if (n < 3) // Exit Condition
			return 1;
		else { // Recursive case
			return (fib(n - 1) + fib(n - 2));
		}
	}
	
	public static int fibWhile(int n) {
		int result = 2;
		int previousResult = 1;
		int lastResult = 2;
		
		for (int i=3; i<n; i++) {
			lastResult = result; //2 3
			result = result+previousResult;//3 5
			previousResult = lastResult;//2 3
		}
		return result;
	}
}
