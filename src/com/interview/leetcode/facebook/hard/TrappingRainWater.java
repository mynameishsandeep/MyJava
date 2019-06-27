package com.interview.leetcode.facebook.hard;

/*
 * https://leetcode.com/problems/trapping-rain-water/description/
 * 
 */
public class TrappingRainWater {

	/*
	 * step1: scan A from left to right. record the largest seen during the scan; 
	 * step2: scan A from right to left, record the largest seen during the scan; 
	 * step3: then for each position the water level sum should be the minimum of the 2 large value minus current.
	 * 
	 * Space Complexity : 2N . Time Complexity : N
	 */
	public int trap1(int[] A) {
		if (A.length == 0)
			return 0;

		int[] leftMax = new int[A.length];
		int[] rightMax = new int[A.length];

		for (int i = 0, max = A[0]; i < A.length; i++) {
			leftMax[i] = max = Math.max(max, A[i]);
		}
		for (int i = A.length - 1, max = A[A.length - 1]; i >= 0; i--) {
			rightMax[i] = max = Math.max(max, A[i]);
		}
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum + Math.min(leftMax[i], rightMax[i]) - A[i];
		}
		return sum;

	}

	/*
	 * step1: scan from right to left and save largest in array.
	 * step2: largest for left to right can be derived as part of step3  
	 * step3: then for each position the water level sum should be the minimum of the 2 large value minus current.
	 * 
	 * Space Complexity : 1N. Time Complexity : N
	 */
	public int trap2(int[] A) {
		if (A.length == 0)
			return 0;
		int[] rightMax = new int[A.length];
		for (int i = A.length - 1, max = A[A.length - 1]; i >= 0; i--) {
			rightMax[i] = max = Math.max(max, A[i]);
		}
		int sum = 0;
		int leftMax = A[0];
		for (int i = 0; i < A.length; i++) {
			leftMax = Math.max(leftMax, A[i]);
			sum = sum + Math.min(leftMax, rightMax[i]) - A[i];
		}
		return sum;
	}

	/*
	 * Instead of saving the largest from both direction. 
	 * traverse on both side(based on condition, anyone side at a time), based on which side is bigger. 
	 * If left-side is bigger. Then move from right side. 
	 * If right-side is bigger. Then move from left side.
	 * For 10,5,7
	 *  (10,7) -> 7-7 = 0
	 *  (10,5) -> 7-5 = 2
	 *  (10,10) -> 10-10 = 0
	 * Space Complexity : 1. Time Complexity : N
	 *
	 */
	public int trap3(int[] array) {
		int result = 0;
		int leftMaxValue = 0;
		int rightMaxValue = 0;
		int leftValue = 0;
		int rightValue = 0;
		for (int leftIndex = 0, rightIndex = array.length - 1; leftIndex <= rightIndex;) {
			leftValue = array[leftIndex];
			rightValue = array[rightIndex];
			leftMaxValue = Math.max(leftMaxValue, leftValue);
			rightMaxValue = Math.max(rightMaxValue, rightValue);
			if (leftMaxValue > rightMaxValue) {
				result += rightMaxValue - rightValue;
				rightIndex--;
			} else {
				result += leftMaxValue - leftValue; // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
				leftIndex++;
			}
		}
		return result;
	}

}
