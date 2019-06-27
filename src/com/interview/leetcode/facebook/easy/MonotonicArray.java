package com.interview.leetcode.facebook.easy;

/*
 * https://leetcode.com/problems/monotonic-array/description/
 * 
Array has to either in increasing order or decreasing order. 
So create a flag increasing, decreasing and set it to false.
Set the flag during iteration for increasing or decreasing.

Return is trick: Either 1 flag has to be false. 

Case1: Both flag false. Answer is true. Ex: 1,1,1,1
Case2: Either 1 flag false. Answer is true. Ex: 1,2,3 or Ex: 3,2,1
Case3: Both the flag true. Answer is false. Ex: 1,3,5,4 or Ex: 5,3,1,2

Note: equal value is not considered. Ex: 1,2,2,3 or 1,1,1,1... In both case answer is true
*/

public class MonotonicArray {
	public boolean isMonotonic(int[] A) {
		boolean increasing = false;
		boolean decreasing = false;
		for (int i = 0; i < A.length - 1; ++i) {
			if (A[i] > A[i + 1])
				increasing = true;
			else if (A[i] < A[i + 1])
				decreasing = true;
			// Skip the logic, if array is not monotonic 
			if (increasing && decreasing) {
				return false;
			}
		}

		return true;
	}
}