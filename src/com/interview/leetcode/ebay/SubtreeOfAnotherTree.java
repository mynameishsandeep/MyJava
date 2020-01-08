package com.interview.leetcode.ebay;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/subtree-of-another-tree/description/
Given two non-empty binary trees s and t, check whether tree t has exactly the
same structure and node values with a subtree of s.

Solution: Recursively(preorder) For each Node in S . validate if child is same using preorder.
So Time Complexity is O(mn)
 *
 */
public class SubtreeOfAnotherTree {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return false;
    if (isSame(s, t)) return true;
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  private boolean isSame(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;

    if (s.val != t.val) return false;

    return isSame(s.left, t.left) && isSame(s.right, t.right);
  }
}
