package com.sample.datastructure.tree;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 * Same code as tree height, with 2 changes
 * 1) return 0. instead of -1.
 * 2) add 1 extra line, which stores maxDiameter from left and right total.
 *
 *  Diameter of a tree can be calculated by only using the height function,
 *  Because the diameter of a tree is nothing but maximum value of (left_height + right_height + 1) for each node.
 *  So we need to calculate this value (left_height + right_height + 1) for each node and update the result.
 *
 *  =====We calculate height for each node. Because, biggest diameter may or may not pass through the root.=====
 *  Time complexity – O(n)
 *
 *  Note: result is not the number of nodes. result is number of edges(connecting line)
 *  https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
 *
 *  Note: Using array since it is immutable. Integer or int will not work.. or we need to go for global variable
 */
public class DiameterOfBinaryTreeOrLongestPath {

  private int maxDiameter;

  public int diameterOfBinaryTree(TreeNode root) {
    recur(root);
    return maxDiameter;
  }

  public int recur(TreeNode root) {
    if (null == root) return 0;

    int left = recur(root.left);
    int right = recur(root.right);
    maxDiameter = Math.max(maxDiameter, left + right);
    return Math.max(left, right) + 1;
  }
}
