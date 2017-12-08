package com.prabhu.sorting;

import java.util.Arrays;

/*
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold 
additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.

CRUX: Instead of coming from 0 to n. Compare from n to 0. Because Initial elements are already sorted.
In loop1 fill all the leftovers in array1
In loop2 Left overs in array2 will be added array1.
 */
public class MergeSortedArraysInPlace {

	public static void main(String[] args) {
		int[] nums1 = { 3, 5, 7, 0, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 4, 5, 7, 8 };
		int n = 4;
		System.out.println(Arrays.toString(merge(nums1, m, nums2, n)));
	}

	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
		int last = m + n - 1;
		int j = n - 1;

		for (int i = m - 1; i >= 0 && j >= 0;) {
			if (nums1[i] > nums2[j]) {
				nums1[last--] = nums1[i--];
			} else {
				nums1[last--] = nums2[j--];
			}
		}

		while (j >= 0) {
			nums1[last--] = nums2[j--];
		}
		return nums1;
	}
}
