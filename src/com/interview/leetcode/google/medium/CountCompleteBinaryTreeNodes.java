package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * Complete Binary Trees are filled from left to right "strictly".
 * So left node might(or equal) be having 1 node greater than right node.
 *
 * Check method "countNodes_TimeLimitExceeded"  which fails.
 * It is a simple height of tree with "return as 0 if null" and without (Math.max)
 * ===log(n) solution approach=======
 * 1) Key point is since data is strictly filled from left. I can verify left height and right height.
 * If both are same. Then I got my output. (2 power height -1). Ex: "1 level 1". "2 level 4-1", "3 level 8-1", "4 level 16-1".
 *
 * 2) Else do step1 for left and right.
 * 3) Save the Height of Left and Right
 * ===========Note======
 * 1) When the tree is properly balanced and tree is big. The logic will be very efficient.
 * 2) Worst case it has to visit most node. Sometimes even more than n nodes for smaller tree.
 * Check diagram "CountCompleteTreeNodes_WorstCase.jpg" and "CountCompleteTreeNodes_BestCase.jpg" in US Problems

 *  
 *  
 *  */
public class CountCompleteBinaryTreeNodes {

  /*
   * O (log(n))
   */
  public int countNodes(TreeNode root) {

    int currentLeftHeight = leftHeight(root);
    int currentRightHeight = rightHeight(root);
    if (currentLeftHeight == currentRightHeight) {// Exit Condition
      return (int) Math.pow(2, currentLeftHeight) - 1; // return (1 << leftHeight) - 1;
    }
    int accumulatedLeftHeight = countNodes(root.left);
    int accumulatedRightHeight = countNodes(root.right);
    return accumulatedLeftHeight + accumulatedRightHeight + 1;
  }

  private int rightHeight(TreeNode root) {
    int dep = 0;
    while (root != null) {
      root = root.right;
      dep++;
    }
    return dep;
  }

  private int leftHeight(TreeNode root) {
    int dep = 0;
    while (root != null) {
      root = root.left;
      dep++;
    }
    return dep;
  }

  /*
   * O(n).
   * Below code visits every node in tree, which causes Too much time and fails when there are too many nodes.
   */
  public int countNodes_TimeLimitExceeded(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = countNodes(root.left);
    int right = countNodes(root.right);
    return left + right + 1;
  }
}
