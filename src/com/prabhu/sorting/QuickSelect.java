package com.prabhu.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * http://codingrecipies.blogspot.com/2015/07/algo-121-quick-select-algorithm.html
 * 
 * By default quick select finds kth Smallest element. 
 * Less than symbol is changed in partition to change the function to kth Largest element 
 * 2, 5, 3, 1, 7, 6, 4
 * 2, 3, 1, 4, 7, 6, 5
 * 2, 3, 1, 4, 5, 6, 7
 */
public class QuickSelect {
	public static void main(String[] args) {
		Integer input[] = { 2, 5, 3, 1, 7, 6, 4 };
		Integer k = 6;
		System.out.println(quick(input, k));
	}

	/**
	 * Partition meant arranging one set of data.
	 * Partition in quick select picks a pivot (either randomly or first/last element). This logic picks last element.
	 * Then it rearranges the list in a way that all elements greater than pivot 
	 * are on left side of pivot and others on right. 
	 * It then returns index of the element upto which is sorted.
	 */

	public static Integer partition(List<Integer> input, Integer left, Integer right) {

		// Taking last element as pivot 
		int pivot = right--;
		for (int i = left; i <= right; i++) {
			if (input.get(i) <= input.get(pivot)) {
				Collections.swap(input, i, left++);
			}
		}
		Collections.swap(input, pivot, left);
		System.out.println(input);
		System.out.println(left);
		return left;
	}

	
	public static Integer quick(Integer[] nums, Integer k) {
		if (nums.length == 1) {
			return nums[0];
		}
		Integer left = 0;
		List<Integer> input = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			input.add(nums[i]);
		}
		Integer right = input.size() - 1;
		Integer pivot = partition(input, left, right);
		while (true) {
			// if 
			if (pivot + 1 == k) {
				return input.get(k - 1);
			} else if (pivot < k) {
				pivot = partition(input, pivot, right);

			} else {
				pivot = partition(input, left, pivot - 1);

			}
		}
	}
}
