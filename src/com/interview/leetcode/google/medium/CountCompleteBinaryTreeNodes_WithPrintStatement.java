package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;

public class CountCompleteBinaryTreeNodes_WithPrintStatement {
  /*
   * O (log(n))
   */
  public int countNodes(TreeNode root) {

    int currentLeftHeight = leftHeight(root);
    int currentRightHeight = rightHeight(root);
    System.out.println("Left Height " + currentLeftHeight);
    System.out.println("Right Height " + currentRightHeight);
    if (currentLeftHeight == currentRightHeight) {
      return (int) Math.pow(2, currentLeftHeight) - 1; // return (1 << leftHeight) - 1;
    }
    int accumulatedLeftHeight = countNodes(root.left);
    int accumulatedRightHeight = countNodes(root.right);
    return accumulatedLeftHeight + accumulatedRightHeight + 1;
  }

  private int rightHeight(TreeNode root) {
    int dep = 0;
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.right;
      dep++;
    }
    System.out.println();
    return dep;
  }

  private int leftHeight(TreeNode root) {
    int dep = 0;
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.left;
      dep++;
    }
    System.out.println();
    return dep;
  }
}
