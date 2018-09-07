package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactorCombinations {
	Map<Integer, Integer> cache = new HashMap<>();

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 2; i <= n / 2; i++) {
			if (cache.containsKey(i)) {
				List<Integer> curr = new ArrayList<>();
				curr.add(i);
				curr.add(cache.get(i));
				boolean same = false;
				for (int l = 0; l < result.size(); l++) {
					if (result.get(l).containsAll(curr) && curr.containsAll(result.get(l))) {
						same = true;
						break;
					}
				}
				if (!same) {
					result.add(curr);
				}
			} else {
				List<Integer> curr = new ArrayList<>();
				recursion(result, curr, i, n);
				calculateCache(curr);
			}
		}
		System.out.println(result);
		return result;
	}

	public void calculateCache(List<Integer> curr) {
		for (int i = 0; i < curr.size(); i++) {
			int key = curr.get(i);
			if (cache.containsKey(key)) {
				continue;
			}
			int value = 1;
			for (int j = 0; j < curr.size(); j++) {
				if (i != j) {
					value = value * curr.get(j);
				}
			}
			cache.put(value, key);
			cache.put(key, value);
		}
	}

	public void recursion(List<List<Integer>> result, List<Integer> curr, int start, int target) {
		if (target == 1) {
			if (curr.size() != 1) {
				result.add(curr);
			}
			return;
		}
		if (start > target) {
			return;
		}
		if (target % start == 0) {
			curr.add(start);
			recursion(result, curr, start, target / start);
		} else {
			recursion(result, curr, start + 1, target);
		}

	}

	public static void main(String[] args) {
		FactorCombinations f = new FactorCombinations();
		f.getFactors(12);
	}
}
