package com.interview.leetcode.facebook.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree_GlobalVariable {

  TreeNode result = new TreeNode(0);

  public TreeNode increasingBST(TreeNode root) {
    TreeNode temp = result;
    recur(root);
    return temp.right;
  }

  private void recur(TreeNode node) {
    if (node == null) {
      return;
    }
    recur(node.left);
    TreeNode resultNode = new TreeNode(node.val);
    result.right = resultNode;
    result = result.right;
    recur(node.right);
  }
}
