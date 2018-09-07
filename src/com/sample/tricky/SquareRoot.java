package com.sample.tricky;

/*
 * https://leetcode.com/problems/sqrtx/description/
 * 
 * The logic is to breakdown the problem using binary search. 
 * Start from number/2
 * Ex: for 1000. 1 to 500, 1 to 250, 1 to 125, 1 to 62, 62 to 125... etc....
 */
public class SquareRoot {

	public static int binarySearch(int x, int low, int high) {
		if (low > high) {
			return high;
		}
		// To avoid overflow doing multiplication using long  
		long mid = low + (high - low) / 2;
		if (mid * mid == x) {
			return (int) mid;
		} else if (mid * mid > x) {
			return binarySearch(x, low, (int) mid - 1);
		} else {
			return binarySearch(x, (int) mid + 1, high);
		}
	}

	public static void main(String[] args) {
		System.out.println(binarySearch(200, 1, 200));
	}

}