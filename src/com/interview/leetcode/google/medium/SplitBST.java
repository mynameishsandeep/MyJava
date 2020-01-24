package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;

public class SplitBST {
  public TreeNode[] splitBST(TreeNode root, int V) {
    if (root == null) return new TreeNode[2];

    TreeNode[] splitted;
    if (root.val > V) {
      splitted = splitBST(root.left, V);
      root.left = splitted[1];
      splitted[1] = root;
    } else {
      splitted = splitBST(root.right, V);
      root.right = splitted[0];
      splitted[0] = root;
    }

    return splitted;
  }

  public TreeNode[] splitBSTIterative(TreeNode root, int V) {
    TreeNode dummySm = new TreeNode(0);
    TreeNode curSm = dummySm;
    TreeNode dummyLg = new TreeNode(0);
    TreeNode curLg = dummyLg;

    while (root != null) {
      if (root.val <= V) {
        curSm.right = root;
        curSm = root;
        root = root.right;
        curSm.right = null;
      } else {
        curLg.left = root;
        curLg = root;
        root = root.left;
        curLg.left = null;
      }
    }
    return new TreeNode[] {dummySm.right, dummyLg.left};
  }
}
