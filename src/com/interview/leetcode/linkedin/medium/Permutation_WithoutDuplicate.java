package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/permutations-ii/description/
 * 
 * 1) With the permutation logic, comparing for contains.
 */
public class Permutation_WithoutDuplicate {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<Integer> input = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
			input.add(nums[i]);
		List<List<Integer>> result = new ArrayList<>();
		permute(0, input, result);
		return result;
	}

	public static void permute(int index, List<Integer> input, List<List<Integer>> result) {
		if (index == input.size() - 1) {
			if (!result.contains(input)) {
				result.add(new ArrayList<>(input));
			}
			return;
		}
		for (int i = index; i < input.size(); i++) {
			Collections.swap(input, index, i);
			permute(index + 1, input, result);
			Collections.swap(input, index, i);
		}
	}
}
