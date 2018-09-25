package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/valid-triangle-number/description/
 * 
 * Logic: The sum of any two sides should always be greater than the third side alone
 * 
 * 1) Sort the input.
 * 2) if i+j>k then 1 result found.
 * 3) Since array is sorted we can break if step2 is not matching.
 * 
 * ======Note=========
 * 1) for each i, for each j, compare k for i+j>k...watch the video on accepted solution 
 * 
 * 
 */
public class ValidTriangleNumber {
	public static void main(String[] args) {
		ValidTriangleNumber v = new ValidTriangleNumber();
		System.out.println(v.triangleNumber(new int[] { 2, 2, 3, 4 }));
		System.out.println(v.triangleNumberBinarySerach(new int[] { 2, 2, 3, 4 }));
	}

	/*
	 * O(n^3)
	 */
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (nums[i] + nums[j] > nums[k]) {
						count++;
					} else {
						break;
					}
				}
			}
		}
		return count;
	}

	/*
	 * O(n^2log(n))
	 */
	public int triangleNumberBinarySerach(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				// With zero triangle cannot be formed. 
				if (nums[i] == 0 || nums[j] == 0) {
					break;
				}
				int k = binarySearch(j, n - 1, nums, i, j);
				count += k - j;
			}
		}
		return count;
	}

	public int binarySearch(int low, int high, int[] nums, int i, int j) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[i] + nums[j] > nums[mid]) {
				return binarySearch(mid + 1, high, nums, i, j);
			} else {
				return binarySearch(low, mid - 1, nums, i, j);
			}
		}
		return low - 1;
	}
}
