package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {
  //  O(NlogN)
  public TreeNode bstFromPreorderBruteForce(int[] preorder) {
    TreeNode root = new TreeNode(preorder[0]);
    TreeNode result = root;
    for (int i = 1; i < preorder.length; i++) {
      TreeNode curr = new TreeNode(preorder[i]);
      while (true) {
        if (preorder[i] < root.val) {
          if (root.left == null) {
            root.left = curr;
            break;
          }
          root = root.left;
        } else {
          if (root.right == null) {
            root.right = curr;
            break;
          }
          root = root.right;
        }
      }
      root = result;
    }
    return result;
  }
}
