package com.sample.tricky;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
 *  
 * 1) Find Largest Number using priority queue
 * 2) Find Largest Number using Quick select algorithm
 * Image is Present on US Problems folder "Quick Select.jpg"
 */
public class FindKthLargestNumber_QuickSelect {
	public static void main(String[] args) {
		// 2,3,5,7,8,9,10
		int a[] = { 3, 2, 1, 5, 6, 4 };

		System.out.println(findKthLargestUsingPriorityQueue(a, 3));
		System.out.println(binSearch_QuickSelect(a, 2));
	}

	/**
	 * http://codingrecipies.blogspot.com/2015/07/algo-121-quick-select-algorithm.html
	 * 
	 * O(N) guaranteed running time + O(1) space... Worst Case O(N log k)
	 * 
	 * By default quick select finds kth Smallest element. 
	 * Less than symbol is changed in partition to change the function to kth Largest element
	 * 	
	**/
	public static int binSearch_QuickSelect(int[] nums, int k) {
		if (nums.length == 1) {
			return nums[0];
		}
		int low = 0;
		List<Integer> input = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			input.add(nums[i]);
		}
		int high = input.size() - 1;
		int mid = partition(input, low, high);
		while (true) {
			// if 
			if (mid + 1 == k) {
				return input.get(k - 1);
			} else if (mid >= k) {
				mid = partition(input, low, mid - 1);
			} else {
				mid = partition(input, mid + 1, high);
			}
		}
	}

	/**
	 * Partition meant arranging one set of data.
	 * Partition in quick select picks a pivot (either randomly or first/last element). This logic picks last element.
	 * Then it rearranges the list in a way that all elements greater than pivot 
	 * are on left side of pivot and others on right. 
	 * It then returns index of the element upto which is sorted.
	 * 
	 * Use 4 variable... left, right, i, pivot
	 * pick the pivot as last element
	 * initially i and left are same. 
	 * loop: i<=right
	 * compare i and pivot.. swap left, i
	 * last swap for left and pivot.
	 * return left
	 */

	// Taking last element as pivot 
	public static int partition(List<Integer> input, int left, int pivot) {
        int right = pivot-1;
		for (int i=left; i <= right; i++) {
			if (input.get(i) >= input.get(pivot)) {
				Collections.swap(input, i, left++);
			}
		}
		Collections.swap(input, pivot, left);
		return left;
	}

	public static Integer findKthLargestUsingPriorityQueue(int a[], Integer k) {
		Queue<Integer> pQ = new PriorityQueue<>();
		for (Integer data : a) {
			pQ.offer(data);
			if (pQ.size() > k) {
				pQ.poll();
			}
		}
		return pQ.poll();
	}

}
