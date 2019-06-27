package com.interview.leetcode.facebook.easy;

/*
 * https://leetcode.com/problems/balanced-binary-tree/description/

For this problem, a height-balanced binary tree is defined as:
a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Solution is modified treeHeight.

Calling TreeHeight for left and right will fail... check isBalancedWrong
									   1
								      / \
								     2   2
								    / \
								   3   3
								  / \
								 4   4

for node 4 left is 0 right is 0
for node 4 left is 0 right is 0
for node 3 left is 1 right is 1
for node 3 left is 0 right is 0
for node 2 left is 2 right is 1
for node 2 left is 0 right is 0
for node 1 left is 3 right is 1 --> false here


 */
import com.interview.leetcode.TreeNode;

public class BalancedBinaryTree {
  boolean result = true;

  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    height(root);
    return result;
  }

  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = height(root.left);
    int right = height(root.right);
    if (Math.abs(right - left) > 1) {
      result = false;
      return 0; // exit recursion
    }
    return Math.max(left, right) + 1;
  }

  /*
   * will fail for below case...
   *
   * [1,2,2,3,null,null,3,4,null,null,4]
  		1
  	2		   2
  3      n    n     3
  4    n             n   4

     */
  public boolean isBalancedWrong(TreeNode root) {
    if (root == null) return true;
    int leftHeight = treeHeight(root.left);
    int rightHeight = treeHeight(root.right);
    return Math.abs(leftHeight - rightHeight) <= 1;
  }

  private int treeHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = treeHeight(root.left);
    int right = treeHeight(root.right);
    return Math.max(left, right) + 1;
  }
}
