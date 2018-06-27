package com.yahoo.array;

public class JumpGame_Recursion {

	public boolean canJump(int[] nums) {
		if (nums == null) {
			return false;
		}
		if (nums[0] >= nums.length) {
			return true;
		}
		Boolean left = canJump(skipArray(nums, 0));
		Boolean right = canJump(skipArrayByOneElement(nums));
		return left || right;
	}

	private int[] skipArray(int[] nums, int index) {
		int newArray[] = new int[nums.length - nums[index]];
		int j = 0;
		if (nums[index] == 0) {
			return null;
		}
		for (int i = nums[index]; i < nums.length; i++) {
			newArray[j++] = nums[i];
		}
		return newArray;
	}

	private int[] skipArrayByOneElement(int[] nums) {
		int newArray[] = new int[nums.length - 1];
		int j = 0;
        if (nums[0] == 0) {
			return null;
		}
		for (int i = 1; i < nums.length; i++) {
			newArray[j++] = nums[i];
		}
		return newArray;
	}

	public static void main(String[] args) {
		int input[] = new int[] {3,2,1,0,4 };
		JumpGame_Recursion j = new JumpGame_Recursion();
		System.out.println(j.canJump(input));
	}
}
