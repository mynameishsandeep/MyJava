package com.sample.datastructure.recursion;

public class PowerNProblem {
	public static void main(String[] args) {
		//System.out.println(power(2, 5));
		System.out.println(power(2, 7));
		System.out.println(powerN(2, 7));
	}

	/**
	 * O(logn).. with Temp variable 
	 */
	public static int power(int base, int n) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			return power(base * base, n / 2);
		} else {
			return power(base * base, n / 2) * base;
		}
	}

	/**
	 * O(n/2)... without tmep variable
	 */
	public static int powerN(int base, int n) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			return powerN(base, n / 2) * powerN(base, n / 2);
		} else {
			return powerN(base, n / 2) * powerN(base, n / 2) * base;
		}

	}

}
