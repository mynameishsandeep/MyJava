package com.sample.tricky;

import java.util.Arrays;

public class MaximumProductOfThreeNumber {

	public static int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int result = 1;
		for (int i = nums.length - 1, j = 0; i >= nums.length - 3; i--) {
			if (nums[i] < 0) {
				result = result * nums[j++];
			} else {
				result = result * nums[i];
			}
		}
		int result1 = nums[nums.length-1]*nums[0]*nums[1];
		return Math.max(result,result1);
	}

	public static void main(String[] args) {
		int input[] = { -1,-2,-3,-4 };
		System.out.println(maximumProduct(input));
	}
}
