package com.sample.datastructure.recursion;

public class GroupSum6 {
	public static void main(String[] args) {
		System.out.println(new GroupSum6().groupSum6(0, new int[] { 5, 9, 2 }, 11));
	}

	/**
	 * If the input 2 sixes then both had to present in output...So iteration should happen till end
	 *  
	 */
	public boolean groupSum6(int start, int[] nums, int target) {
		if (start >= nums.length)
			return target == 0;

		Boolean left = false;
		Boolean right = false;
		if (nums[start] == 6)
			return groupSum6(start + 1, nums, target - nums[start]);
		else {
			left = groupSum6(start + 1, nums, target - nums[start]);
			right = groupSum6(start + 1, nums, target);
		}

		return left || right;
	}

}
