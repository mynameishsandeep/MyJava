package com.yahoo.array;

/**
 * 	Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory
	
	Approach
	1) Iterate from 0 to n
	2) if current Index == duplicate Index... Increment duplicate index. Else replace current with duplicate 
 */
public class DeleteDuplicatesFromSortedArray {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));
	}

	public static int removeDuplicates(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int curIndex = 0;
		int dupIndex = 0;
		int n = A.length;
		while (n-- > 0) {
			if (A[curIndex] == A[dupIndex]) {
				dupIndex++;
			} else {
				A[++curIndex] = A[dupIndex++];
			}
		}
		return curIndex + 1;
	}

	public int removeDuplicatesKeepAtmostTwice(int[] nums) {
		int i = 2;
		for (int j = 2; j < nums.length; j++) {
			if (nums[j] > nums[i - 2]) {
				nums[i] = nums[j];
				i++;
			}
		}

		return i;
	}
}
