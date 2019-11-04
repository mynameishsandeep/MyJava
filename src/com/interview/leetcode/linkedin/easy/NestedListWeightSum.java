package com.interview.leetcode.linkedin.easy;

import java.util.List;

import com.interview.leetcode.NestedInteger;

/*
 * https://leetcode.com/problems/nested-list-weight-sum/description/
 *
 * See picture "NestedListWeightSum.PNG" on how to visualize tree.
 */
public class NestedListWeightSum {
  private int sum = 0;

  public int depthSum(List<NestedInteger> nestedList) {
    depthSum(nestedList, 1);
    return sum;
  }

  public void depthSum(List<NestedInteger> nestedList, int depth) {
    for (NestedInteger nested : nestedList) {
      if (nested.isInteger()) {
        sum += nested.getInteger() * depth;
      } else {
        depthSum(nested.getList(), depth + 1);
      }
    }
  }
}
