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

	public static Integer partition(List<Integer> input, Integer leftIndex, Integer rightIndex) {

		// Taking last element as pivot 
		int pivotIndex = rightIndex--;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (input.get(i) <= input.get(pivotIndex)) {
				Collections.swap(input, i, leftIndex++);
			}
		}
		Collections.swap(input, pivotIndex, leftIndex);
		System.out.println(input);
		System.out.println(leftIndex);
		return leftIndex;
	}

	public static Integer quick(Integer[] nums, Integer k) {
		if (nums.length == 1) {
			return nums[0];
		}
		int leftIndex = 0;
		List<Integer> input = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			input.add(nums[i]);
		}
		Integer rightIndex = input.size() - 1;
		Integer pivotIndex = partition(input, leftIndex, rightIndex);
		while (true) {
			// if 
			if (pivotIndex + 1 == k) {
				return input.get(k - 1);
			} else if (pivotIndex < k) {
				pivotIndex = partition(input, pivotIndex, rightIndex);

			} else {
				pivotIndex = partition(input, leftIndex, pivotIndex - 1);

			}
		}
	}
}
