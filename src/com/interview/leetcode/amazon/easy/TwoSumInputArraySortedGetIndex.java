package com.interview.leetcode.amazon.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumInputArraySortedGetIndex {

	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		Integer savedIndex;
		Integer currentIndex = 0;
		for (Integer i : numbers) {
			savedIndex = map.get(target - i);
			if (savedIndex != null) {
				return new int[] { savedIndex + 1, currentIndex + 1 };
			} else {
				map.put(i, currentIndex);
			}
			currentIndex++;
		}
		return null;
	}
}
