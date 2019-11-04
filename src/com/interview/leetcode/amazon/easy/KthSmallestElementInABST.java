package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/

========================================Solution=====================================
1) Traversing BST in InOrder Traversal gives result in Ascending Order.
2) So if I traverse in InOrder Traversal, then problem is like in an sorted array
find the from to left get the Kth element
3) Reduce Kth from left to right. If Kth==0 result found.

 */
public class KthSmallestElementInABST {
  int kth = 0;
  int result = 0;

  public int kthSmallest(TreeNode root, int k) {
    kth = k;
    recur(root);
    return result;
  }

  private void recur(TreeNode root) {
    if (root == null || kth == 0) return;
    recur(root.left);
    kth--;
    if (kth == 0) result = root.val;
    recur(root.right);
  }
}
