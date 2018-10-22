package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<Integer> input = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
			input.add(nums[i]);
		List<List<Integer>> result = new ArrayList<>();
		permute(0, input, result);
		return result;
	}

	public static void permute(int index, List<Integer> input, List<List<Integer>> result) {
		if (index == input.size()) {
			result.add(new ArrayList<>(input));
			return;
		}
		for (int i = index; i < input.size(); i++) {
			Collections.swap(input, index, i);
			permute(index + 1, input, result);
			Collections.swap(input, index, i);
		}

	}
}
