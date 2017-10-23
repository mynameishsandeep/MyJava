package com.sample.datastructure.recursion;

public class PowerNProblem {
	public static void main(String[] args) {
		//System.out.println(power(2, 5));
		System.out.println(power(2, 6));
	}

	/**
	 * O(logn).. with Temp variable 
	 */
	public static int power(int a, int b) {
		if (b == 0) {
			return 1;
		}
		System.out.println("a = " +a +" b = " + b);
		int temp = power(a, b / 2);
		if (b % 2 == 0) {
			System.out.println("temp * temp = " + temp * temp );
			return temp * temp;
		} else {
			System.out.println("temp * temp * a = " + temp * temp * a);
			return temp * temp * a;
			
		}
	}

	/**
	 * O(n/2)... without tmep variable
	 */
	public int powerN(int base, int n) {
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
