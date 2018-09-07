package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
	public int[] searchRange(int[] nums, int target) {
		if (nums.length <= 0)
			return new int[] { -1, -1 };
		int lowIndex = binarySearchGetLower(0, nums.length - 1, nums, target);
		int highIndex = binarySearchGetHigher(0, nums.length - 1, nums, target);
		if (lowIndex < nums.length && highIndex < nums.length && nums[lowIndex] == target
				&& nums[highIndex] == target) {
			return new int[] { lowIndex, highIndex };
		} else {
			return new int[] { -1, -1 };
		}
	}

	public int binarySearchGetLower(int low, int high, int[] nums, int target) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return binarySearchGetLower(low, mid - 1, nums, target);
			} else if (nums[mid] > target) {
				return binarySearchGetLower(low, mid - 1, nums, target);
			} else {
				return binarySearchGetLower(mid + 1, high, nums, target);
			}
		}
		return low;
	}

	public int binarySearchGetHigher(int low, int high, int[] nums, int target) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return binarySearchGetHigher(mid + 1, high, nums, target);
			} else if (nums[mid] > target) {
				return binarySearchGetHigher(low, mid - 1, nums, target);
			} else {
				return binarySearchGetHigher(mid + 1, high, nums, target);
			}
		}
		return high;
	}
}
