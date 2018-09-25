package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/combination-sum/description/
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
		combine(result, new ArrayList<>(), candidates, 0, 0, target);
		return result;
	}

	public void combine(List<List<Integer>> result, List<Integer> tempCombo, int[] input, int currentIndex,
			int currentSum, int target) {
		if (currentSum == target) {
			System.out.println(tempCombo);
			result.add(new ArrayList<>(tempCombo));
		} else if (currentSum > target) {
			System.out.println(tempCombo);
			return;
		} else {
			while (currentIndex < input.length) {
				System.out.println(tempCombo);
				tempCombo.add(input[currentIndex]);
				combine(result, tempCombo, input, currentIndex, currentSum + input[currentIndex], target);
				tempCombo.remove(tempCombo.size() - 1);
				currentIndex++;
			}
		}
	}

	public static void main(String[] args) {
		CombinationSumOrCoinChange c = new CombinationSumOrCoinChange();
		c.combinationSum(new int[] { 2, 3, 7, 6 }, 7);
	}
}
