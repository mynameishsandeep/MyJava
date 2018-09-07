package com.interview.leetcode.linkedin.easy;

/*
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 * 
 * 1) aSquare+bSquare=c
 * 2) bSquare= c-aSquare
 * 3) We know c, start a from 0. 
 * 4) Find bSquare by binarySearch. b should be from 0 to bSquare/2.
 * 
 * Ex:
 * 1Square + 2Square = 5
 * 4(2Square) = 4(5-1)
 * Find 2*2 from 0 to 3 to get target 4
 * 
 * 
 */
public class SumOfSquares {
	public boolean judgeSquareSum(int c) {
		for (long a = 0; a * a <= c; a++) {
			int bSquare = c - (int) (a * a);
			int b = (int)Math.sqrt(bSquare);
			if (binary_search(0, bSquare / 2, bSquare)) {
				System.out.println("a " + a);
				return true;
			}
		}
		return false;
	}

	public boolean binary_search(long low, long high, int target) {
		if (low > high)
			return false;
		long mid = low + (high - low) / 2;
		if (mid * mid == target) {
			System.out.println(mid + " "+ target);
			return true;
		}
		if (mid * mid > target)
			return binary_search(low, mid - 1, target);
		return binary_search(mid + 1, high, target);
	}

	public static void main(String[] args) {
		SumOfSquares s = new SumOfSquares();

		//a 12 ,b 316
		s.judgeSquareSum(5);
	}
}
