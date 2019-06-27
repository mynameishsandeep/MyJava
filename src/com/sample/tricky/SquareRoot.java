package com.sample.tricky;

/*
 * https://leetcode.com/problems/sqrtx/description/
 * 
 * The logic is to breakdown the problem using binary search. 
 * Start from number/2
 * Ex: for 1000. 1 to 500, 1 to 250, 1 to 125, 1 to 62, 62 to 125... etc....
 * 
 * ======return "high"========
 * Ex:
 *  input is 15, low will be 4 and high will be 3.
 *  input is 8, low will be 3 and high will be 2.
 *  
 *  At anypoint low exceeds high we break the logic. 
 *  So high will be lower and low will be higher
 *  
 */
public class SquareRoot {

	public static int binarySearch(int x, int low, int high) {
		System.out.println(low + " " + high);
		if (low <= high) {
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
		return high;
	}

	public static void main(String[] args) {
		//System.out.println(binarySearch(200, 1, 200));
		//System.out.println(binarySearch(15, 1, 15));
		
		System.out.println(binarySearch(17, 1, 17/2));
	}

}