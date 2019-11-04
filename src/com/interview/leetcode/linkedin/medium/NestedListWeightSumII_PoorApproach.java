package com.interview.leetcode.linkedin.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.interview.leetcode.NestedInteger;
import com.interview.leetcode.linkedin.easy.NestedListWeightSum;

/*
 * Get the depth by level order traversal and call NestedListWeightSum.java depthSum
 */
public class NestedListWeightSumII_PoorApproach {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    int depth = getDepth(nestedList);
    return new NestedListWeightSum().depthSum(nestedList, depth);
  }

  private int getDepth(List<NestedInteger> nestedList) {
    int depth = 0;
    Queue<List<NestedInteger>> q = new LinkedList<>();
    if (nestedList == null || nestedList.isEmpty()) {
      return 0;
    }
    q.offer(nestedList);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int j = 0; j < size; j++) {
        List<NestedInteger> n = q.poll();
        for (int i = 0; i < n.size(); i++) {
          if (!n.get(i).isInteger()) {
            q.offer(n.get(i).getList());
          }
        }
      }
      depth++;
    }
    return depth;
  }
}
