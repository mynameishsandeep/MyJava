package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 *
Calculate sum at each level and return which level has max sum.
 */
public class MaximumLevelSumOfABinaryTree {
  public int maxLevelSum(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    recur(root, 0, result);
    int maxLevel = 1;
    int maxNum = result.get(0);
    for (int i = 1; i < result.size(); i++) {
      if (result.get(i) > maxNum) {
        maxNum = result.get(i);
        maxLevel = i + 1;
      }
    }
    return maxLevel;
  }

  private void recur(TreeNode root, int level, List<Integer> levelSum) {
    if (root == null) return;
    if (level == levelSum.size()) levelSum.add(root.val);
    else levelSum.set(level, levelSum.get(level) + root.val);
    recur(root.left, level + 1, levelSum);
    recur(root.right, level + 1, levelSum);
  }
}
