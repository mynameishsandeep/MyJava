package com.interview.leetcode.amazon.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/set-mismatch/description/
 * 
 * Note: missing number can be found only by formula. Because of below case
 * 
 * Input : 1 1 -> missing number is 2
 * Input : 2 2 -> missing number is 1.
 * 
 *  So we cannot decide missing number by duplicate-1 or duplicate+1
 */
public class SetMismatch {

	public int[] findErrorNums(int[] nums) {
		Set<Integer> set = new HashSet<>();
		Integer duplicate = 0;
		Integer totalSum = (nums.length * (nums.length + 1)) / 2;
		Integer currentSumWithOutDup = 0;
		for (Integer i : nums) {
			if (!set.add(i)) {
				duplicate = i;
			} else {
				currentSumWithOutDup += i;
			}
		}
		Integer missingNumber = totalSum - currentSumWithOutDup;
		return new int[] { duplicate, missingNumber };
	}
}
