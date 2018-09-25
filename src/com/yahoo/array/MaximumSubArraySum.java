package com.yahoo.array;

/*
 * https://leetcode.com/problems/maximum-subarray/description/
 * 
 * =====Look for "maxSubArrayMathematicalApproach" and compare with "MaximumProductSubarray.java"========
 */
public class MaximumSubArraySum {

	public static void main(String[] args) {
		// the contiguous subarray [4,-1,2,1] has the largest sum = 6.
		int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(input));

		int[] input2 = { -2, -6, -4, -1, -3 };
		System.out.println(maxSubArray(input2));
	}

	/*
	 * Below is the clean and mathematical approach. I am not setting defaults to "sum" or "maxSum".. 
	 * Use this logic in interview. 
	 */
	public static int maxSubArrayMathematicalApproach(int[] nums) {
		int sum = nums[0];
		int maxSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
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
