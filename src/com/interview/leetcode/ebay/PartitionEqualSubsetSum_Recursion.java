package com.interview.leetcode.ebay;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 * 
 * Recursion approach will take more than 5 minutes if the input has 50+ elements
 * 
 * Solution Note Recursion Approach : Verify whether array can be split into 2 equal parts. 
 * Simple approach using groupSum is... 
 * If we able to get a result of sum/2 using groupsum. Then remaining number is remaining half of array.
 */
public class PartitionEqualSubsetSum_Recursion {

	public static void main(String[] args) {
		PartitionEqualSubsetSum_Recursion p = new PartitionEqualSubsetSum_Recursion();
		int input[] = new int[] { 100, 100, 100, 100, 100, 100, 100, 100 };
		System.out.println(p.canPartition(input));

	}

	public boolean canPartition(int[] nums) {
		Integer sum = getSum(nums);
		if (sum % 2 == 1) {
			return false;
		}
		System.out.println("Target to achieve is " + sum/2);
		return groupSum(0, nums, sum / 2);
	}

	private Integer getSum(int nums[]) {
		Integer result = 0;
		for (int i = 0; i < nums.length; i++) {
			result += nums[i];
		}
		return result;
	}

	private boolean groupSum(Integer start, int nums[], Integer target) {
		if (start == nums.length) {
			return false;
		}
		if (target == 0) {
			return true;
		}
		Boolean left = groupSum(start + 1, nums, target - nums[start]);
		Boolean right = groupSum(start + 1, nums, target);
		return left || right;
	}

}
