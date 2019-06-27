package com.sample.tricky;

/*
 * https://www.geeksforgeeks.org/n-bonacci-numbers/
 * 
 * Also Refer problem ClimbingStairs
 */
public class Fibonacci_Nbonacci {

	private int fibXSteps(int n, int numberOfSteps) {
		if (n <= 1) {
			return n;
		}
		int result = 0;
		for (int i = 1; i <= numberOfSteps; i++) {
			int currentResult = fibXSteps(n - i, numberOfSteps);
			result += currentResult;
		}
		return result;
	}

	public static void main(String[] args) {
		Fibonacci_Nbonacci c = new Fibonacci_Nbonacci();
		System.out.println(c.fibXSteps(6, 2)); // 0 1 1 2 3 5 8
	}

}
