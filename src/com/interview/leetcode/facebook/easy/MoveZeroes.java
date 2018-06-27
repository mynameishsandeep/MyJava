package com.interview.leetcode.facebook.easy;

import java.util.Arrays;

/*
 * 1) Traverse the given array from left to right. 
 * 2) While traversing, maintain count of non-zero elements in array. 
 * 3) Let the count be ‘count’. For every "non-zero" element arr[i], 
 * overwrite the element with ‘arr[count]’ and increment ‘count’.
 * 4) After complete traversal, all non-zero elements have already been shifted to front. 
 * 5) ‘count’ will be at index of first 0.  Now run a loop from ‘count’ till end of the array and set values to 0.  
 */
public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (0 != nums[i]) {
				nums[count] = nums[i];
				count++;
			}
		}
		for (int i = count; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
	public static void main(String[] args) {
		int input[] = {0,1,0,3,12};
		moveZeroes(input);
		System.out.println(Arrays.toString(input));
	}
}
