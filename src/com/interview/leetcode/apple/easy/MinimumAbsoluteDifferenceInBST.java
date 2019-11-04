package com.interview.leetcode.apple.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/


1) Since this is a BST, the InOrder traversal of its nodes results in a sorted list of values.
2) Thus, the minimum absolute difference must occur in any adjacently traversed nodes
=======================Solution Approach=============================================
1) Traverse in InOrder.
2) First time previous node will be null.
3) Save the previous node.
4) If previous node not null. Calculate minDiff.
 */
public class MinimumAbsoluteDifferenceInBST {

  int minDiff = Integer.MAX_VALUE;
  TreeNode prev;

  public int getMinimumDifference(TreeNode root) {
    inorder(root);
    return minDiff;
  }

  public void inorder(TreeNode root) {
    if (root.left != null) inorder(root.left);
    if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
    prev = root;
    if (root.right != null) inorder(root.right);
  }
}
