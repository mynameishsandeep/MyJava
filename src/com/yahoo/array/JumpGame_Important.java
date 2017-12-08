package com.yahoo.array;

/**
 * 	Given an array of non-negative integers, you are initially positioned at the first index of the array.
	Each element in the array represents your maximum jump length at that position.
	Determine if you are able to reach the last index.
 */
public class JumpGame_Important {

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 3, 3, 1, 0, 2, 0, 1 }));
		System.out.println(canJump(new int[] { 3, 3, 1, 0, 1, 0, 1 }));
	}

	public static boolean canJump(int[] nums) {
		int maxJump = 0;
		int maxLength = nums.length;
		for (int i = 0; i < maxLength - 1; i++) {
			if (maxJump <= i && nums[i] == 0) {
				return false;
			}
			maxJump = Math.max(maxJump, i + nums[i]);
		}
		return true;
	}

}
