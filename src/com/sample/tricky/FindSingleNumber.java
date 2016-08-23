package com.sample.tricky;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 */
public class FindSingleNumber {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,1,2,3};
		System.out.println(singleNumber(a));

	}

	public static int singleNumber(int[] A) {
		int x = 0;
		for (int a : A) {
			x = x ^ a;
		}
		return x;
	}
}
