package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/combination-sum/description/
 * 
 * No duplicates in candidates
 * 
[]
[2]
[2, 2]
[2, 2, 2]
[2, 2, 2, 2]
[2, 2, 2]
[2, 2, 2, 3]
[2, 2, 2]
[2, 2, 2, 7]
[2, 2, 2]
[2, 2, 2, 6]
[2, 2]
[2, 2, 3]
[2, 2]
[2, 2, 7]
[2, 2]
[2, 2, 6]
[2]
[2, 3]
[2, 3, 3]
[2, 3]
[2, 3, 7]
[2, 3]
[2, 3, 6]
[2]
[2, 7]
[2]
[2, 6]
[]
[3]
[3, 3]
[3, 3, 3]
[3, 3]
[3, 3, 7]
[3, 3]
[3, 3, 6]
[3]
[3, 7]
[3]
[3, 6]
[]
[7]
[]
[6]
[6, 6]

 */
public class CombinationSumOrCoinChange {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		combine(result, new ArrayList<>(), candidates, target, 0);
		return result;
	}

	public void combine(List<List<Integer>> result, List<Integer> tempCombo, int[] input, int target, int currentIndex) {
		if (0 == target) {
			result.add(new ArrayList<>(tempCombo));// Note: not directly adding tempCombo.
		} else if (target < 0) {
			return;
		} else {
			for (int i = currentIndex; i < input.length; i++) {
				tempCombo.add(input[i]);
				combine(result, tempCombo, input, target - input[i], i);
				tempCombo.remove(tempCombo.size() - 1); // Remove the last element from the arraylist
			}
		}
	}

	public static void main(String[] args) {
		CombinationSumOrCoinChange c = new CombinationSumOrCoinChange();
		System.out.println(c.combinationSum(new int[] { 1, 2, 3, 7, 6 }, 7));
	}
}
