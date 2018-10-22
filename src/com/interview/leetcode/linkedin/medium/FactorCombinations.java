package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/factor-combinations/
 * 
 * Approach1 : Like groupsum approach, target can be reduced each time and check target==0
 * 			or 
 * Approach2 : keep an additional variable "currentSum" and check if target==currentSum
 * 
 * But approach2 will generate too many combinations and will throw timelimitexception
 * 
 * 
 */
public class FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		getFactors(result, new ArrayList<>(), n, 2, 1);
		System.out.println(result);
		return result;
	}

	public void getFactors(List<List<Integer>> result, List<Integer> tempResult, int target, int currentIndex,
			long eval) {
		System.out.println(tempResult);
		if (eval == target) {
			//System.out.println(tempResult);
			result.add(new ArrayList<>(tempResult));
			return;
		} else if (eval > target) {
			return;
		}
		for (int i = currentIndex; i <= target / 2; i++) {
			tempResult.add(i);
			getFactors(result, tempResult, target, i, eval * i);
			tempResult.remove(tempResult.size() - 1);
			//System.out.println(tempResult);
		}
	}

	public static void main(String[] args) {
		FactorCombinations f = new FactorCombinations();
		f.getFactors(16);
		//f.getFactors(23848713);
	}
}
