package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations2 {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, new ArrayList<Integer>(), n, 2);
		System.out.println(result);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> item, int target, int start) {
		System.out.println(item);
		if (target == 1) {
			if (item.size() > 1) {
				result.add(new ArrayList<Integer>(item));
			}
			return;
		}

		for (int i = start; i <= target; ++i) {
			if (target % i == 0) {
				item.add(i);
				helper(result, item, target / i, i);
				item.remove(item.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		FactorCombinations2 f = new FactorCombinations2();
		f.getFactors(16);
		//f.getFactors(23848713);
	}
}
