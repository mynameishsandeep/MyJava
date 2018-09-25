package com.sample.datastructure.recursion;

/*
 * https://leetcode.com/problems/powx-n/solution/
 * 
 * Step1 Formula : powerN(base, n - 1) * base;
 * Step2 Formula : 
		  	powerN(base, n /2) * powerN(base, n /2) -----> n%2
		    powerN(base, n / 2) * powerN(base, n / 2) * base------> other than n%2
 * Step3 Formula : O(logn): (It performs faster and other solutions will cause timeoutexception in leetcode)
 			power(base * base, n / 2)-------> n%2
  			power(base * base, n / 2) * base;--------> other than n%2
 */
public class PowerNProblem {
	public static void main(String[] args) {
		//System.out.println(power(2, 5));
		System.out.println(power(2, 7));
		System.out.println(powerN(2, 7));

		System.out.println(powerForNegative(2, -2));
	}

	/**
	 * O(logn).. with Temp variable 
	 * 
	 */
	public static double power(double base, int n) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			return power(base * base, n / 2);
		} else {
			return power(base * base, n / 2) * base;
		}
	}

	/*
	 * For negative number do the below logic.
	 * 1) base =  base by 1
	 * 2) convert the negative number to positive number
	 */
	public static double powerForNegative(double base, int n) {
		if (n < 0) {
			base = 1 / base;
			n = -n;//n=n*-1;
		}
		return power(base, n);

	}

	/**
	 * O(n/2)... without temp variable
	 */
	public static int powerN(int base, int n) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			return powerN(base, n / 2) * powerN(base, n / 2);
		} else {
			//return powerN(base, n / 2) * powerN(base, n / 2) * base;
			return powerN(base, n - 1) * base;
		}

	}

}
