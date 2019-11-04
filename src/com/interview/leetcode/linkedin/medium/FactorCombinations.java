package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/factor-combinations

=========How duplicates are skipped============
Ex: 2,2,3 then 2,3,2 cannot come.
above will never happen. Because if a number is selected then number less than cannot come after it.
it will always go in forward direction
===========

[]
[2]
[2, 2]
[2, 2, 2]
[2, 2, 2, 2]
[2, 2, 4]
[2, 4]
[2, 8]
[4]
[4, 4]
[8]
[16]
 */
public class FactorCombinations {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<>();
    helper(result, new ArrayList<Integer>(), n, 2);
    System.out.println(result);
    return result;
  }

  public void helper(
      List<List<Integer>> result, List<Integer> currentResult, int target, int start) {
    System.out.println(currentResult);
    if (target == 1) {
      if (currentResult.size() > 1) {
        result.add(new ArrayList<Integer>(currentResult));
      }
      return;
    }

    for (int i = start; i <= target; ++i) {
      if (target % i == 0) {
        currentResult.add(i);
        helper(result, currentResult, target / i, i);
        currentResult.remove(currentResult.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    FactorCombinations f = new FactorCombinations();
    f.getFactors(16);
    // f.getFactors(23848713);
  }
}
