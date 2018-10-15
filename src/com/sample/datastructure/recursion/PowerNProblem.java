package com.sample.datastructure.recursion;

/*
 * https://leetcode.com/problems/powx-n/solution/
 * 
 * Step1 Formula : powerN(base, n - 1) * base;
 * Step2 Formula : O(logn): (It performs faster and other solutions will cause timeoutexception in leetcode)
 			power(base * base, n / 2)-------> n%2
  			power(base * base, n / 2) * base;--------> other than n%2
 */
public class PowerNProblem {
	public static void main(String[] args) {
		//System.out.println(power(2, 5));
		System.out.println(powerNBasicApproach(2, 10));
		System.out.println(powerNBestApproach(2, 10));
		System.out.println(powerForNegative(2, -2));
	}

	public static double powerNBasicApproach(double base, int n) {
		if (n == 0) {
			return 1.0;
		} else {
			return powerNBasicApproach(base, n - 1) * base;
		}
	}

	/**
	 * O(logn).. with Temp variable 
	 * 
	 */
	public static double powerNBestApproach(double base, int n) {
		if (n == 0) {
			return 1;
		}
		double group2Item = base * base; //initially 2*2=4, then 4*4=16, then 16*16=256,  then 256*256=65536 
		System.out.println("group2Item " + group2Item);
		if (n % 2 == 0) {
			return powerNBestApproach(group2Item, n / 2);
		} else {
			return powerNBestApproach(group2Item, n / 2) * base;
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
		return powerNBestApproach(base, n);

	}

}
