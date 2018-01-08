package com.yahoo.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;

/*
 * https://www.youtube.com/watch?v=CE2b_-XfVDk
 * 
 * O(n square)
 */
public class LongestIncreasingSequence {

	public static void main(String[] args) {
		
		Integer[] input = {1,3,6,7,9,4,10,5,6};
		System.out.println(lengthOfLIS(input));
	}
	public static int lengthOfLIS(Integer[] nums) {
		Integer[] result = new Integer[nums.length];
		Arrays.fill(result, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] >= nums[j]) {
					result[i] = Math.max(result[j] + 1,result[i]);
				}
			}
		}
		return Collections.max(Arrays.asList(result));

	}
}
