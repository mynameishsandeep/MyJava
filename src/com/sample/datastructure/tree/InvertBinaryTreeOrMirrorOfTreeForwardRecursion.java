package com.sample.datastructure.tree;

import com.interview.leetcode.TreeNode;

/*
*https://leetcode.com/problems/invert-binary-tree/description/
=======================Solution=======================
Swap happens from top to Bottom
* ============================
* Ex: 3,2,4,1
			     3
			   /   \
			  2     4
			 / \   / \
			1   n n   n

	1st swap:
			     3
			   /   \
			  4     2
			 / \   / \
			n   n 1   n

	2nd swap:
			     3
			   /   \
			  4     2
			 / \   / \
			n   n n   1
*/
public class InvertBinaryTreeOrMirrorOfTreeForwardRecursion {
  public TreeNode invertTree(TreeNode parent) {
    if (parent == null) return parent;
    TreeNode tempParent = parent;
    forwardRecur(tempParent);
    return tempParent;
  }

  private void forwardRecur(TreeNode parent) {
    if (parent.left != null || parent.right != null) {
      swap(parent);
    }
    if (parent.left != null) forwardRecur(parent.left);
    if (parent.right != null) forwardRecur(parent.right);
  }

  private void swap(TreeNode root) {
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
  }
}
