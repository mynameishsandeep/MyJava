package com.yahoo.array;

/*
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaximumSubArraySum {

	public static void main(String[] args) {
		// the contiguous subarray [4,-1,2,1] has the largest sum = 6.
		int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(input));

		int[] input2 = { -2, -6, -4, -1, -3 };
		System.out.println(maxSubArray(input2));
	}

	public static int maxSubArray(int[] nums) {

		int sum = 0;
		// If i put maxSum to 0. Then it will not work for case {-1,-2,-3} . i.e all negative value.
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			// Adjust maxSum to current sum
			if (sum > maxSum) {
				maxSum = sum;
			}
			// Set the sum to zero in case value went negative
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}
}
