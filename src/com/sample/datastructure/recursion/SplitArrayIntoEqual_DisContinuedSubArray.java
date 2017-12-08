package com.sample.datastructure.recursion;

/**
 * =================Solution 1============
 * 1) Calculate sum of the array. If sum is odd, there can not be two subsets
 * with equal sum, so return false. 
 * 2) If sum of array elements is even,
 * calculate sum/2 and find a subset of array with sum equal to sum/2. Check GroupSum problem
 * 
 * =================Solution 2===============
 * 1) Calculate sum of subset of array. Check the program (SumOfAllSubSetsOfArray.java)
 * 2) Pass the left side sum into right side and right side sum into left side.
 * 3) If leftSum == rightSum true else false.
 * 4) Its bit tricky to imagine. But sample tree will prove it.
 */
public class SplitArrayIntoEqual_DisContinuedSubArray {
	public static void main(String[] args) {
		Integer input[] = { 1, 2, 3, 4, 5, 5 };
		Integer input1[] = { 2, 2, 10, 10, 1, 1 };
		Integer input2[] = { 5, 4, 3 };
		Integer input3[] = { 2, 3, 1 };
		System.out.println(splitArray(input3));
	}

	public static boolean splitArray(Integer[] nums) {
		return recArray(nums, 0, 0, 0);
	}

	private static boolean recArray(Integer[] nums, Integer index, Integer leftSum, Integer rightSum) {
		if (index >= nums.length) {
			return leftSum == rightSum;
		}
		Boolean left = recArray(nums, index + 1, leftSum + nums[index], rightSum);
		Boolean right = recArray(nums, index + 1, leftSum, rightSum + nums[index]);
		return left || right;

	}
}
