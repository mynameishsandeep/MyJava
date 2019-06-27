package com.interview.leetcode.facebook.easy;

/*
1) Result is not a number. It is index
2) Question is Peak index at any point. There can be many Peak index in monuntain. 
But the problem strictly says only one peak. So below case is not possible.
Ex:[0,1,2,3,0,3,4,6,0] For below one relult can be 3(index) or 7.
Solution1: go by comparing current and next number. 
Solution2: Binary Search. Instead of target==A[mid]..... check for A[mid]<A[mid+2]

Example:
Input: [0,1,0]
Output: 1

Example:
Input: [0,2,1,0]
Output: 1
*/

public class PeakIndexInAMountainArray_BinarySearch {

	public int peakIndexInMountainArray(int[] A) {
		return binSearch(A, 0, A.length - 1);
	}

	private int binSearch(int[] A, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (A[mid] < A[mid + 1])
				return binSearch(A, mid + 1, high);
			else
				return binSearch(A, low, mid - 1);
		}
		return low;
	}

}