package com.sample.datastructure.recursion;

public class GroupNoAdj {

	public boolean groupNoAdj(int start, int[] nums, int target) {
		if (target == 0) {
			return true;
		}
		if (start >= nums.length) {
			return false;
		}
		boolean left = groupNoAdj(start + 2, nums, target - nums[start]);
		boolean right = groupNoAdj(start + 1, nums, target);
		return left || right;
	}

	public boolean groupNoAdjBreakingInto2(int start, int[] nums, int target) {
		if (target == 0) {
			return true;
		}
		if (start >= nums.length) {
			return false;
		}
		boolean leftOddWith = groupNoAdj(start + 2, nums, target - nums[start]);
		boolean leftOddWithout = groupNoAdj(start + 2, nums, target);
		boolean rightOddWith = start + 1 < nums.length ? groupNoAdj(start + 3, nums, target - nums[start + 1]) : false;
		boolean rightOddWithout = start + 1 < nums.length ? groupNoAdj(start + 3, nums, target) : false;
		return leftOddWith || leftOddWithout || rightOddWith || rightOddWithout;
	}

}
