package com.interview.leetcode.google.medium;

/*
 * https://leetcode.com/problems/divide-two-integers/description/
 * 
 * 1) Keep "subtracting" the divisor from dividend until "dividend becomes less than divisor". 
 * 2) Finally, the dividend becomes the remainder, and the number of times subtraction is done becomes the quotient.
 */
public class DivideTwoIntegers_SimpleApproach {
	int divide(int dividend, int divisor) {

		int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

		// Update both divisor and dividend positive 
		dividend = Math.abs(dividend);// remove negative by Math.abs
		divisor = Math.abs(divisor);

		int quotient = 0;// Initialize the quotient 

		while (dividend >= divisor) {
			dividend -= divisor;
			++quotient;
		}
		return sign * quotient;
	}

	public static void main(String[] args) {
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide(101, 5));
	}
}
