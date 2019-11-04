package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/trim-a-binary-search-tree/

				    3
				   / \
				  0   4
				   \
				    2
				   /
				  1
======================================
				L = 1
  				R = 3
			Output:
					      3
					     /
					   2
					  /
					 1
===========================Root Changed for Below===========
				L = 0
				R = 2
			Output:
						  0
						   \
						    2
						   /
						  1
============================Root Changed for Below==========
				L = 0
				R = 1
			Output:
						  0
						   \
						    1
==============================================================
There 3 cases in total depends on the root value and L, R

1) When node.val > R, we know that the trimmed binary tree must occur to the left of the node.
2) when node.val < L, the trimmed binary tree occurs to the right of the node.
3) Otherwise, we will trim both sides of the tree.

 */
public class TrimABinarySearchTreeRecursionMust {
  public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) return root;
    if (root.val > R) {
      root = trimBST(root.left, L, R);
      return root;
    }
    if (root.val < L) {
      root = trimBST(root.right, L, R);
      return root;
    }

    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);
    return root;
  }
}
