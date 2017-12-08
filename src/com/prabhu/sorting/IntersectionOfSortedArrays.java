package com.prabhu.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * BruteForce: For each outer array element, search its value in inner array using binary search : O(m log n)
 * 
 * Efficient Approach Below: O(m+n) 
 *  1) Use two index variables i and j, initial values i = 0, j = 0
	2) If arr1[i] is smaller than arr2[j] then print arr1[i] and increment i.
	3) If arr1[i] is greater than arr2[j] then print arr2[j] and increment j.
	4) If both are same then print any of them and increment both i and j.
	
	Note: skip duplicates by comparing and moving indexes of array
 */
public class IntersectionOfSortedArrays {

	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 5, 7, 7, 8, 8, 8, 9 };
		int[] b = { 1, 1, 4, 6, 8, 9, 9 };
		System.out.println(Arrays.toString(intersection(a, b)));
	}

	public static int ignoreDuplicates(int i, int[] nums1) {
		while (true) {
			if (i + 1 < nums1.length) {
				if (nums1[i] == nums1[i + 1]) {
					i++;
				} else {
					break;
				}
			} else {
				break;
			}
		}
		return i;

	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			i = ignoreDuplicates(i, nums1);
			j = ignoreDuplicates(j, nums2);
			if (nums1[i] == nums2[j]) {
				result.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		int[] r = new int[result.size()];
		for (int k = 0; k < result.size(); k++) {
			r[k] = result.get(k);
		}
		return r;
	}
}
