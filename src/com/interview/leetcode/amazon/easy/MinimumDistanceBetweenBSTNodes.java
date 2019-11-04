package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/minimum-distance-between-bst-nodes/

Given a Binary Search Tree (BST) with the root node, return the minimum difference
between the values of any two different nodes in the tree.

========================================Solution=====================================
1) Traversing BST in InOrder Traversal gives result in Ascending Order.
2) So if I traverse in InOrder Traversal, then problem is like in an sorted array
find the minimum between adjacent.
3) First time previous is null. From 2nd time take the difference.
4) Update previous with current.

				         4
				        / \
				       2   5
				      / \
				     1   3

*/
public class MinimumDistanceBetweenBSTNodes {
  int minDiff = Integer.MAX_VALUE;
  Integer prev = null;
  Integer curr = null;

  public int minDiffInBST(TreeNode root) {
    recur(root);
    return minDiff;
  }

  private void recur(TreeNode root) {
    if (root == null) return;
    recur(root.left);
    if (prev == null) prev = root.val;
    else {
      curr = root.val;
      minDiff = Math.min(minDiff, curr - prev);
      prev = root.val;
    }
    recur(root.right);
  }

  private void recurInShort(TreeNode root) {
    if (root == null) return;
    recurInShort(root.left);
    if (prev != null) minDiff = Math.min(minDiff, root.val - prev);
    prev = root.val;
    recurInShort(root.right);
  }
}
