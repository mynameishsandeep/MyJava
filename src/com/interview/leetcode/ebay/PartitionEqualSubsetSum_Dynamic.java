package com.interview.leetcode.ebay;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 * 
 * Solution Note using GroupSum Approach : Verify whether array can be split into 2 equal parts. 
 * If we able to get a result of sum/2 using groupsum. Then remaining number is remaining half of array.

 */
public class PartitionEqualSubsetSum_Dynamic {
	public static void main(String[] args) {
		PartitionEqualSubsetSum_Dynamic p = new PartitionEqualSubsetSum_Dynamic();
		int input[] = new int[] { 1, 5, 11, 5 };
		System.out.println(p.canPartition(input));

	}

	public boolean canPartition(int[] nums) {
		Integer sum = Arrays.stream(nums).sum();
		if (sum % 2 == 1) {
			return false;
		}
		System.out.println("Target to achieve is " + sum / 2);
		return groupSumDynamic(nums, sum / 2);

	}

	
	
	/*
	 * 
	 *      
	 * 
	 * 
	 * Form the memoization matrix
	 * Set 0th row to false.
	 * Set 1st column to true.
	 * current value = value from top || from previous row (current column - current subset value)
	 */
	private boolean groupSumDynamic(int[] nums, int target) {
		int n = nums.length;
		boolean[][] dp = new boolean[n + 1][target + 1];
		fill1stColumnsToTrue(dp);

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < target + 1; j++) {
				dp[i][j] = dp[i - 1][j];
				Integer currentSubSetValue = nums[i - 1];
				if (j >= currentSubSetValue) {
					dp[i][j] = (dp[i][j] || dp[i - 1][j - currentSubSetValue]);
				}
			}
		}
		for(boolean[] d : dp) System.out.println(Arrays.toString(d) );  
		return dp[n][target];

	}


	private void fill1stColumnsToTrue(boolean mm[][]) {
		for (int i = 0; i < mm.length; i++) {
			mm[i][0] = true;
		}
	}

}
