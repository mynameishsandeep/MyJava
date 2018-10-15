package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/combination-sum-ii/description/
 * 
 * == Key point is array has to be sorted to remove duplicates formed in result.=====
 * 
 *
 */
public class CombinationSumII_DPTopDown {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		combine(result, new ArrayList<>(), candidates, target, 0);
		return result;
	}

	public void combine(List<List<Integer>> result, List<Integer> tempCombo, int[] input, int target,
			int currentIndex) {
		if (0 == target) {
			result.add(new ArrayList<>(tempCombo));
		} else if (target < 0) {
			return;
		} else {
			for (int i = currentIndex; i < input.length; i++) {
				if (i > currentIndex && input[i] == input[i - 1]) {
					continue;
				}
				tempCombo.add(input[i]);
				combine(result, tempCombo, input, target - input[i], i + 1);
				tempCombo.remove(tempCombo.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		CombinationSumII_DPTopDown c = new CombinationSumII_DPTopDown();
		System.out.println(c.combinationSum2(new int[] { 1, 1, 6, 1 }, 8));
	}
}
