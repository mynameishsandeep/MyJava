package com.prabhu.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * See picture QuickSelect.jpg in "US Problems"
 * 
 * By default quick select finds kth Smallest element. 
 * Less than symbol is changed in partition to change the function to kth Largest element 
 * 2, 5, 3, 1, 7, 6, 4
 * 2, 3, 1, 4, 7, 6, 5
 * 2, 3, 1, 4, 5, 6, 7
 * 
 * ========Implementation Notes======
 * 1) It is a binary search with partition logic.
 * 2) Partition Logic returns an "index" which says, the element at this index is sorted.
 * i.e. element at this index is sorted, but elements b4 and after this element is not guaranteed to be sorted, 
 * which we are not interested.  
 * 3) 
 */
public class QuickSelect {
	public static void main(String[] args) {
		Integer input[] = { 3,2,1,5,6,4 };
		Integer k = 2;
		System.out.println(binSearch(input, k));
	}

	/**
	 * Partition meant arranging one set of data.
	 * Partition in quick select picks a pivot (either randomly or first/last element). This logic picks last element.
	 * Then it rearranges the list in a way that all elements greater than pivot 
	 * are on left side of pivot and others on right. 
	 * It then returns index of the element upto which is sorted.
	 */

	// Taking last element as pivot 
	public static Integer partition(List<Integer> input, Integer left, Integer pivot) {
        int right = pivot-1;
		for (int i=left; i <= right; i++) {
			if (input.get(i) >= input.get(pivot)) {
				Collections.swap(input, i, left++);
			}
		}
		Collections.swap(input, pivot, left);
		return left;
	}

	public static Integer binSearch(Integer[] nums, Integer k) {
		if (nums.length == 1) {
			return nums[0];
		}
		// Copy array to list for easier swap operation
		List<Integer> input = new ArrayList<>(Arrays.asList(nums));
		int low = 0;
		int high = input.size() - 1;
		int mid = partition(input, low, high);
		while (true) {
			if (mid + 1 == k) {
				return input.get(k - 1);
			} else if (mid >= k) {
				mid = partition(input, low, mid - 1);
			} else {
				mid = partition(input, mid + 1, high);

			}
		}
	}
}
