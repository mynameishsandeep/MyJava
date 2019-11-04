package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.NestedInteger;

/*
 * See picture "NestedListWeightSum2.PNG" on how this logic works.
 * See picture "NestedListWeightSum.PNG" on how to visualize tree.
 */
public class NestedListWeightSumII_Optimal_Maths {

  public int depthSumInverse(List<NestedInteger> nestedList) {
    return helper(nestedList, 0);
  }

  private int helper(List<NestedInteger> nestedListRecurseForward, int prev) {
    int recursionForwardSum = prev;
    List<NestedInteger> nestedListRecurseBack = new ArrayList<>();
    for (NestedInteger ni : nestedListRecurseForward) {
      if (ni.isInteger()) {
        recursionForwardSum += ni.getInteger();
      } else {
        nestedListRecurseBack.addAll(ni.getList());
      }
    }
    System.out.println("prevSum " + recursionForwardSum);
    int recursionReturnSum = 0;
    if (nestedListRecurseBack.isEmpty()) { // Reached End...
      // Do nothing
    } else {
      recursionReturnSum = helper(nestedListRecurseBack, recursionForwardSum);
    }
    int total = recursionReturnSum + recursionForwardSum;
    System.out.println("total " + total);
    return total;
  }
}
