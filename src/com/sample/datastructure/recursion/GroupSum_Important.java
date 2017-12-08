package com.sample.datastructure.recursion;

/**
 * http://codingbat.com/prob/p145416
 * 
 * This is an basic example of recursion and DFS.
 * 
 *
 */
public class GroupSum_Important {

	public static void main(String[] args) {
		System.out.println(new GroupSum_Important().groupSum(0, new int[] { 2, 4, 8 }, 12));
		System.out.println(new GroupSum_Important().groupSumAlternate(0, new int[] { 2, 4, 8 }, 12));
	}

	/*
	 * I can reduce a variable by reducing the target, instead of taking sum as an argument.
	 */
	public boolean groupSum(int start, int[] nums, int target) {
		if (target == 0) {
			return true;
		}
		if (start == nums.length) {
			return false;
		}
		boolean left = groupSum(start + 1, nums, target - nums[start]);
		boolean right = groupSum(start + 1, nums, target);
		return left || right;
	}

	/**
	 * This takes an additional variable sum... 
	 */
	public boolean groupSumAlternate(int start, int[] nums, int target) {
		return groupSum(start, nums, target, 0);
	}

	public boolean groupSum(int start, int[] nums, int target, int sum) {
		if (target == sum) {
			return true;
		}
		if (start == nums.length) {
			return false;
		}
		Boolean left = groupSum(start + 1, nums, target, sum + nums[start]);
		Boolean right = groupSum(start + 1, nums, target, sum);

		return left || right;
	}

}
