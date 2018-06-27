package com.interview.leetcode.google.hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/sliding-window-maximum/description/
 * 
 * 1) Sort each K element in reverse order. So top element will be max of K element always.
 * 2) Add top element to result.
 * 3) Remove "lowest index" "value" from sorted elements.
 * 
 * Solution Approach:
 * 1) Save each K element in TreeMap with key as data and value as number of occurrence of data. 
 * 	  Note : If the input doesn't contains duplicate, then TreeSet is enough instead of TreeMap.
 * 2) Save each K element in LinkedList. So head("lowest index" "value") elements will be searched in TreeMap and removed. 
 */
public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if ((nums.length) == 0) {
			return nums;
		}
		int[] result = new int[nums.length - k + 1];
		Map<Integer, Integer> dataMap = new TreeMap<>(Collections.reverseOrder());
		List<Integer> indexValue = new LinkedList<>();

		int resultIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			addElementToMap(dataMap, nums, i);
			indexValue.add(nums[i]);
			if (i > k) {
				result[resultIndex++] = dataMap.entrySet().iterator().next().getKey();
				removeElementFromMap(dataMap, indexValue.get(0));
				indexValue.remove(0);
			}
		}
		return result;
	}

	private void addElementToMap(Map<Integer, Integer> dataMap, int[] nums, int i) {
		if (dataMap.get(nums[i]) == null) {
			dataMap.put(nums[i], 1);
		} else {
			dataMap.put(nums[i], dataMap.get(nums[i]) + 1);
		}
	}

	private void removeElementFromMap(Map<Integer, Integer> dataMap, int val) {
		if (1 == dataMap.get(val)) {
			dataMap.remove(val);
		} else {
			dataMap.put(val, dataMap.get(val) - 1);
		}

	}

	public static void main(String[] args) {
		SlidingWindowMaximum s = new SlidingWindowMaximum();
		int input[] = new int[] { 1,3,-1,-3,5,3,6,7 };
		System.out.println(Arrays.toString(s.maxSlidingWindow(input, 3)));
	}
}
