package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/closest-binary-search-tree-value/description/
*
* 1) Initially Pick the root value as currentCloseValue.
* 2) calculate currentCloseValue for every node........
* 3) Then decide go left or right if (target < root.val)

Note: Root is guaranteed to be not null or there will be only one unique value in the BST that is closest to the target.
*
*/

public class ClosestBinarySearchTreeValue2 {

  // Ex: 100, 50, 150... target = 70... answer 50
  public int closestValue(TreeNode root, double target) {
    int currentCloseValue = root.val; // 100
    while (true) {
      root = root.val > target ? root.left : root.right; // GoLeft.
      if (root != null)
        currentCloseValue =
            Math.abs(root.val - target) < Math.abs(currentCloseValue - target)
                ? root.val
                : currentCloseValue; // 1) (70-50)<100-50
      else break;
    }
    return currentCloseValue;
  }
}
