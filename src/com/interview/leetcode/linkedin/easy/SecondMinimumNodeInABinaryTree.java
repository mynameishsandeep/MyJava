package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 *
			1
		1		3
	 2     1
For the above tree answer is 2.

	 ========Solution Thinking=========
1) The problem is same as an array having 1st element as MIN1. Find MIN2.
2) Here as per problem definition, root is always MIN1
3) So set MIN2 as max value.
4) Verify if current falls between MIN1 and MIN2, then update MIN2 with current.
=================================


 */
public class SecondMinimumNodeInABinaryTree {
  int min1;
  long min2 = Long.MAX_VALUE;

  private boolean isCurrentFallsBetweenMIN1AndMIN2(int current) {
    return min1 < current && min2 > current;
  }

  public void dfs(TreeNode root) {
    if (root != null) {
      if (isCurrentFallsBetweenMIN1AndMIN2(root.val)) {
        min2 = root.val;
      } else {
        dfs(root.right); // purposely made right as first. Changing line will still work
        dfs(root.left);
      }
    }
  }

  public int findSecondMinimumValue(TreeNode root) {
    min1 = root.val;
    dfs(root);
    return (min2 == Long.MAX_VALUE) ? -1 : (int) min2;
  }
}
