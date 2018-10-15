package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumII_GroupSumApproach {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<>();
		groupSum(candidates, target, 0, result, new ArrayList<>());
		return result;
	}

	public void groupSum(int[] input, int target, int index, List<List<Integer>> result, List<Integer> res) {
		if (input.length == index) {
			if (target == 0) {
				if (result.size() == 0) {
					result.add(res);
				} else {
					boolean contains = false;
					for (int i = 0; i < result.size(); i++) {
						if (equalLists(result.get(i), res)) {
							contains = true;
							break;
						}
					}
					if (!contains) {
						List<Integer> list = new ArrayList<>();
						list.addAll(res);
						result.add(list);
						res = new ArrayList<>();
					}
				}

			}
			return;
		}
		groupSum(input, target, index + 1, result, res);
		groupSum(input, target - input[index], index + 1, result, copy(res, input[index]));
	}

	public List<Integer> copy(List<Integer> inp, int val) {
		List<Integer> ret = new ArrayList<>();
		ret.addAll(inp);
		ret.add(val);
		return ret;
	}

	public boolean equalLists(List<Integer> one, List<Integer> two) {
		if (one.size() != two.size()) {
			return false;
		}
		Collections.sort(one);
		Collections.sort(two);
		return one.equals(two);
	}
}
