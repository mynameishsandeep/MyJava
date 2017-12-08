package com.sample.datastructure.recursion;

/**
 * 1) Take the sum...
 * 2) If the sum is divided by 2. Array can be split.
 * 3) Iterate from 0 to n-1 for the value sum/2 
 * 
 */
public class SplitArrayIntoEqual_ContinuousSubArray {
	public static void main(String[] args) {
		Integer input[] = { 1, 2, 3, 4, 5, 5 };
		System.out.println(isArrayDividableInEqualSums(input));
		Integer input1[] = { 2, 2, 10, 10, 1, 1};
		System.out.println(isArrayDividableInEqualSums(input1));
		
	}

	public static boolean isArrayDividableInEqualSums(Integer[] fooBar) {
		if (fooBar == null) {
			return false;
		}

		int nSum = 0;
		int nLength = fooBar.length;
		for (int i = 0; i < nLength; ++i) {
			nSum += fooBar[i];
		}

		if ((nSum % 2) != 0) {
			return false; // have an Odd number as a Sum, not possible to have 2
							// equal subsets
		}

		int nHalfSum = nSum / 2;
		int currSum = 0;

		for (int i = 0; i < nLength; ++i) {
			currSum += fooBar[i];

			if (currSum == nHalfSum) {
				return true; // The set from the beginning up to and including i
								// is equal to the elements from i+1 to the end
			}
		}
		return false;
	}
}
