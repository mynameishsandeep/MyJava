package com.interview.leetcode.amazon.medium;

/**
 * Solution1: Worst Approach.
 * Count the number of 0’s, 1’s and 2’s. After Counting, put all 0’s first, then 1’s and lastly 2’s in the array. 
 * We traverse the array two times.
 * 
 * Solution2:
 * 1) Keep 3 pointers. low (represents 0), mid (represents 1), high (represents 2). 
 * 2) Keep low and mid at 0; high at n-1.
 * 3) if input is 0. Swap low and mid. increment low and mid. 
 * 4) if input is 1. increment mid.
 * 5) if input is 2. Swap mid and high. decrement high. 
 * 
 * Note: 
 * 1) In the for loop, Each element is compared against mid... not low... 
 * 2) Another key is mid<=high and not mid<high
 * 
 * This problems can be asked like sort 123 or sort 012 or arrange 3 colors in order or any combo...
 * This is also DutchFlag Problem
 *
 */

public class SortColors {
	public void sortColors(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int mid = 0;
		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
				swap(nums, low++, mid++);
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(nums, mid, high--);
				break;
			}
		}
	}

	public void swap(int[] nums, int from, int to) {
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
	}
}
