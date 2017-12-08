package com.yahoo.array;

/**
 * 	Given an array of non-negative integers, you are initially positioned at the first index of the array.
	Each element in the array represents your maximum jump length at that position.
	Your goal is to reach the last index in the minimum number of jumps. 
 */
public class JumpGame2 {
	public static void main(String[] args) {
		System.out.println(jump(new int[] { 3, 3, 1, 0, 2, 0, 1 }));
		System.out.println(jump(new int[] { 2, 3, 1, 1, 4 }));
	}

	public static int jump(int[] nums) {
		int minJump = 0;
		int curJump = 0;
		int maxGoJump = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			maxGoJump = Math.max(maxGoJump, i + nums[i]);
			if (i == curJump) {
				minJump++;
				curJump = maxGoJump;
			}
		}
		return minJump;
	}
}
