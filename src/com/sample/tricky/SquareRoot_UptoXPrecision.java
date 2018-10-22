package com.sample.tricky;

/*
 * https://leetcode.com/problems/sqrtx/description/
 * 
 *  1) Get the value before precision 
 *  
 */
public class SquareRoot_UptoXPrecision {


	public static int binarySearch(int x, int low, int high) {
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
	
	static float squareRoot(int number, int precision) {
		double ans = binarySearch(number, 0, number);

		double increment = 0.1;
		for (int i = 0; i < precision; i++) {
			while (ans * ans <= number) {
				ans += increment;
			}
			System.out.println(ans + " " + increment);
			ans = ans - increment;
			System.out.println(ans + " " + increment);
			increment = increment / 10; // For precision 4, divide by .1 then .01 then .001 and .0001
		}
		return (float) ans;
	}

	public static void main(String[] args) {
        System.out.println("Square Root of 25 is: " + squareRoot(25,2));
        System.out.println("Square Root of 81 is: " + squareRoot(81,2));
        System.out.println("Square Root of -100 is: " + squareRoot(-100,2));
        System.out.println("Square Root of 1 is: " + squareRoot(1,2));
        System.out.println("Square Root of 0 is: " + squareRoot(0,2));
	}

}