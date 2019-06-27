package com.interview.leetcode.amazon.easy;

import java.util.HashSet;
import java.util.Set;

import com.interview.leetcode.TreeNode;

public class TwoSumIVInputIsABST {

  Set<Integer> set = new HashSet<>();

  public boolean findTarget(TreeNode root, int k) {
    if (root != null) {
      if (set.contains(k - root.val)) {
        return true;
      }
      set.add(root.val);
      boolean left = findTarget(root.left, k);
      // Can break If left is true.
      boolean right = findTarget(root.right, k);
      return left || right;
    }
    return false;
  }

  public boolean findTargetEfficient(TreeNode root, int k) {
    if (root != null) {
      if (set.contains(k - root.val)) {
        return true;
      }
      set.add(root.val);
      return findTarget(root.left, k) ? true : findTarget(root.right, k);
    }
    return false;
  }
}
