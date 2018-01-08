package com.sample.tricky;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 
 * 1) Find Largest Number using priority queue
 * 2) Find Largest Number using Quick select algorithm
 */
public class FindKthLargestNumber {
	public static void main(String[] args) {
		// 2,3,5,7,8,9,10
		int a[] = { 7, 3, 9, 2, 5, 10, 8 };

		System.out.println(findKthLargestUsingPriorityQueue(a, 3));
		System.out.println(findKthLargetUsingQuickSelect(a, 3));
	}

	public static Integer findKthLargestUsingPriorityQueue(int a[], Integer k) {
		Queue<Integer> pQ = new PriorityQueue<Integer>();
		for (Integer data : a) {
			pQ.offer(data);
			if (pQ.size() > k) {
				pQ.poll();
			}
		}
		return pQ.poll();
	}

	/**
	 * http://codingrecipies.blogspot.com/2015/07/algo-121-quick-select-algorithm.html
	 * 
	 * By default quick select finds kth Smallest element. 
	 * Less than symbol is changed in partition to change the function to kth Largest element
	 * 	
	**/
	public static int findKthLargetUsingQuickSelect(int[] nums, int k) {
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
			if (input.get(i) >= input.get(pivot)) {
				Collections.swap(input, i, left++);
			}
		}
		Collections.swap(input, pivot, left);
		System.out.println(input);
		System.out.println(left);
		return left;

	}

}