package com.interview.leetcode.google.hard;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/sliding-window-maximum/description/
 * 
 * O(n*w)
 * 1) Iterate each window and find the max. 
 * === Solution Approach =====
 * 1) Iterate each element and update max. 
 * 2) Whenever the window size reached. Update the result with max.
 * 3) Move to the next window and do step 1.  
 *
 */
public class SlidingWindowMaximum_BruteForce {

	public int[] maxSlidingWindow(int[] array, int windowSize) {
		if (array.length == 0) {
			return new int[] {};
		}
		int[] result = new int[array.length - windowSize + 1];
		int max = Integer.MIN_VALUE;
		int currentWindowSize = 1;
		
		//traverse the array while shifting the window forward
		for (int i = 0; i < array.length; i++) {
			//find maximum in the current window
			max = Math.max(array[i], max);
			if (currentWindowSize == windowSize) {
				result[i - windowSize + 1] = max;
				max = Integer.MIN_VALUE;;
				i = i - currentWindowSize + 1;
				currentWindowSize = 0;
			}
			currentWindowSize++;
		}
		return result;

	}

	public static void main(String[] args) {
		SlidingWindowMaximum_BruteForce s = new SlidingWindowMaximum_BruteForce();
		int input[] = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		System.out.println(Arrays.toString(s.maxSlidingWindow(input, 3)));
	}
}
