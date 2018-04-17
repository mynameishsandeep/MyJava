package com.interview.leetcode.amazon.easy;

import java.util.Arrays;

public class RotateArray {

	// This method uses the temp array 
	public void rotate(int[] nums, int k) {
		// For 0 or 1 data no rotation is needed.
		if (nums == null || nums.length < 2) {
			return;
		}
		// If the number of rotation is more than the size of data. Then rotation = rotation%size of data.
		k = k % nums.length;
		int temp[] = new int[nums.length];
		int tempIndex = k - 1;
		for (int i = nums.length - 1; tempIndex >= 0; i--, tempIndex--) {
			temp[tempIndex] = nums[i];
		}
		tempIndex += k + 1;
		for (int i = 0; i < nums.length - k; i++) {
			temp[tempIndex++] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = temp[i];
		}

	}

	/*
	 * The basic idea is that, for example, nums = [1,2,3,4,5,6,7] and k = 3, first we reverse [1,2,3,4], 
	 * it becomes[4,3,2,1]; then we reverse[5,6,7], it becomes[7,6,5], 
	 * finally we reverse the array as a whole, it becomes [5,6,7,1,2,3,4].
	 */
	public void rotateWithOutTemp(int[] nums, int k) {
		// For 0 or 1 data no rotation is needed.
		if (nums == null || nums.length < 2) {
			return;
		}
		// If the number of rotation is more than the size of data. Then rotation = rotation%size of data.
		k = k % nums.length;

		// reverse n-k data from beginning.
		// reverse k data from end. (n-k to n from beginning)
		// reverse step1 and step2 i.e: "k data from end" with "n-k data from beginning"

		reverse(nums, 0, nums.length - k);
		reverse(nums, nums.length - k, nums.length);
		reverse(nums, 0, nums.length);

	}

	private void reverse(int[] nums, int start, int end) {
		while (end > start) {
			// Swapping without Temp... needs below condition
			// https://www.geeksforgeeks.org/swap-two-numbers-without-using-temporary-variable/
			// Without Below if, program fails for the input 1,2 with k=1... Because of self swap problem
			if (nums[start] != nums[end - 1]) {
				nums[start] = nums[start] ^ nums[end - 1];
				nums[end - 1] = nums[start] ^ nums[end - 1];
				nums[start] = nums[start] ^ nums[end - 1];
			}
			end--;
			start++;
		}
	}

	public static void main(String[] args) {
		RotateArray r = new RotateArray();
		int i[] = new int[] { 1, 2, 3, 4, 5, 6 };
		r.rotate(i, 2);
		System.out.println(Arrays.toString(i));
		int i1[] = new int[] { 1, 2, 3, 4, 5, 6 };
		r.rotateWithOutTemp(i1, 2);
		System.out.println(Arrays.toString(i1));
	}
}
