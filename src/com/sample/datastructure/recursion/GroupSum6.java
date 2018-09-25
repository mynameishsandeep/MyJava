package com.sample.datastructure.recursion;

/**
 * Note: Question is a bit tricky, if there is a 6 present in the input then sum should have 6 to achieve target.
 *  If there is no 6 present in the input then grouping sum other than 6 is ok.
 */
public class GroupSum6 {
	public static void main(String[] args) {
		System.out.println(new GroupSum6().groupSum6(0, new int[] { 5, 6, 2, 4 }, 11));
		System.out.println(new GroupSum6().groupSum6(0, new int[] { 7, 6, 11 }, 11));

	}

	/**
	 * If the input 2 sixes then both had to present in output...So iteration should happen till end
	 *  
	 */
	public boolean groupSum6(int start_index, int[] nums, int target) {
		//System.out.println(target);
		if (start_index == nums.length)
			return target == 0;

		Boolean left = false;
		Boolean right = false;
		if (nums[start_index] == 6)
			return groupSum6(start_index + 1, nums, target - nums[start_index]);
		else {
			left = groupSum6(start_index + 1, nums, target - nums[start_index]);
			right = groupSum6(start_index + 1, nums, target);
		}

		return left || right;
	}
	
	private boolean groupSum6_Longer(int start_index, int[] nums, int target) {
		// Below 2 if case can be replaced with 1 in above groupSum6 method.
		// But in above groupSum6 method recursion go till end of index, which is performance issue.
		if (target == 0) {
			return true;
		}
		if (nums.length == start_index) {
			return false;
		}
		boolean left = false;
		boolean right = false;
		if (nums[start_index] == 6) {
			return groupSum6(start_index + 1, nums, target - nums[start_index]);
		} else {
			left = groupSum6(start_index + 1, nums, target - nums[start_index]);
			right = groupSum6(start_index + 1, nums, target);
		}
		return left || right;
	}


}
