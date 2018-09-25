package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/description/
 * 
 * Note: Get K Closest element from the target. 
 * Ex: 
 * { 1,5,8 }, 2, Target= 5... Here closest to 5 is 8....So output is 5,8
 * { 1,5,9 }, 2, Target = 5... Here tie occurs from left and right. So pick left. So output 1,5
 * 
 * 1) Custom binary search which returns index of "higher number index" if element is not found. Ex: {1,5,8}. binary search of 6 will return 8th index.
 * 2) No need to save the result from left and right to array and sort. Simply save left index and right index. and grab the value from left to right index. 
 * 3) Fix both leftIndex and rightIndex on the index of target(if found) or number above target.
 * 4) Don't think of moving 2 steps. Go Element by Element from  either left side or right side by compare logic. 
 *
 * =======Note: Same problem can be solved using 2 stack approach "ClosestBinarySearchTreeValueII.java"
 * But it is not worth, as it will make it linear=======
 */
public class FindKClosestElements {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
		int index = binarySearch(arr, x, 0, arr.length - 1);
		int leftIndex = index, rightIndex = index;
		while (k - 1 > 0) {
			if (leftIndex == 0) {
				rightIndex++;
			} else if (rightIndex == arr.length - 1) {
				leftIndex--;
			} else if (Math.abs(arr[leftIndex - 1] - x) <= Math.abs(arr[rightIndex + 1] - x)) {
				leftIndex--;
			} else {
				rightIndex++;
			}
			k--;
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			res.add(arr[i]);
		}
		//System.out.println(res);
		return res;
	}

	private int binarySearch(int[] arr, int target, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				return binarySearch(arr, target, low, mid - 1);
			} else {
				return binarySearch(arr, target, mid + 1, high);
			}
		}
		return low;

	}

	public static void main(String[] args) {
		FindKClosestElements f = new FindKClosestElements();
		f.findClosestElements(new int[] { 1, 5, 8 }, 2, 5);
		f.findClosestElements(new int[] { 1, 5, 9 }, 2, 5);
		System.out.println(f.findClosestElements(new int[] { 1, 4, 6, 9 }, 1, 5));//

	}
}
