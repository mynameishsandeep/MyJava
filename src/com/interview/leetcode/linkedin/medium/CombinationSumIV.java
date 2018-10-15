package com.interview.leetcode.linkedin.medium;

/*
 * 
 * https://leetcode.com/problems/combination-sum-iv/discuss/176717/Java-Recursive-Solution-with-Cache(6ms)-and-DP-Solution-(1-ms)
 * 
 * ======Note: Array index is not passed and every time for loop goes from 0 to nums.length======
 */
public class CombinationSumIV {

	private int combine(int[] nums, int target) {
		if (target == 0)
			return 1;
		else if (target < 0)
			return 0;
		int count = 0;
		for (int i = 0; i < nums.length; ++i) {
			count += combine(nums, target - nums[i]);
		}
		return count;
	}

	public int combinationSum4(int[] nums, int target) {
		return combine(nums, target);
	}
}
