package com.yahoo.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;

/*
 * This is not an simple problem. It is complex one. Trying with 2 for loops with temp variable will fail for so many cases.
 * 
 *  https://leetcode.com/problems/longest-increasing-subsequence/description/
 *  
 *  1) Keep i as constant and move j from 0 to i.
 *  2) if value at i is greater than value of j, then result is max( value at j+1, i)
 * 
 * https://www.youtube.com/watch?v=CE2b_-XfVDk
 */
public class LongestIncreasingSubSequence_dp {

	public static void main(String[] args) {

		Integer[] input = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		System.out.println(lengthOfLIS(input));
	}

	public static int lengthOfLIS(Integer[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Integer[] dp = new Integer[nums.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		return Collections.max(Arrays.asList(dp));
	}

	public int lengthOfLIS(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		return lengthOfLIS(nums[0], 1, nums, 1);
	}

	/*
	 * LIS using groupSum approach. Timeout occurs for longer input.
	 * https://leetcode.com/problems/longest-increasing-subsequence/description/
	 * 
	 */
	public int lengthOfLIS(int prevNumber, int currentIndex, int[] nums, int max) {
		if (currentIndex == nums.length) {
			return max;
		}
		int left = 0;
		int right = 0;
		if (prevNumber < nums[currentIndex]) {
			left = lengthOfLIS(prevNumber, currentIndex + 1, nums, max);
			right = lengthOfLIS(nums[currentIndex], currentIndex + 1, nums, max + 1);
		} else {
			left = lengthOfLIS(nums[currentIndex], currentIndex + 1, nums, 1);
			right = lengthOfLIS(prevNumber, currentIndex + 1, nums, max);
		}

		return Math.max(left, right);
	}
}
