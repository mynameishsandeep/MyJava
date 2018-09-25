package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * 
 * 1) Find which side (Left or right side) is sorted.
 * 2) Then check target lies in the sorted side. If yes go towards that side or go opposite.
 * 
 */
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		return searchBinary(nums, target, 0, nums.length - 1);

	}

	public int searchBinary(int[] nums, int target, int low, int high) {
		if (low <= high) {
			int mid = low + ((high - low) / 2);
			if (nums[mid] == target) {
				return mid;
			} else if (nums[low] <= nums[mid]) { // Left Side Sorted.
				if (target >= nums[low] && target <= nums[mid]) {// Check target lies in left side
					return searchBinary(nums, target, low, mid - 1);
				} else {
					return searchBinary(nums, target, mid + 1, high);
				}
			} else { // Right Side Sorted 
				if (target >= nums[mid] && target <= nums[high]) {// Check target lies in right side
					return searchBinary(nums, target, mid + 1, high);
				} else {
					return searchBinary(nums, target, low, mid - 1);
				}
			}
		}
		return -1;

	}
}
