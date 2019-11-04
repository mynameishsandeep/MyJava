package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/closest-binary-search-tree-value/description/
*
* Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
*
*
* 1) Find Closest point for each value.
* 2) if target is less than root. I am sure, there might be "more close" on left. So go left.
     Ex: [5,1,10]... target= 3
* 3) Else Go Right.
  Ex: [5,1,10]... target= 7
*=================================
*1) Initially Pick the root value as currentCloseValue.
*2) Then decide go left or right if (target < root.val)
*3) calculate currentCloseValue for every node........
*
Note: Root is guaranteed to be not null or there will be only one unique value in the BST that is closest to the target.
*========Tricky============
*For Tree Problems, think about going node by node... don't think by left and right.
*A single logic will be executed for a node.
*left and right will adhere to a single logic.
*
*============================================
* ===Note: The target "can or cannot" have float number. But the input cannot have float number.======
* If the input has float number. Then this approach will not work. Because close value can occur in left and right side.
* see "ClosestBinarySearchTreeValue2.java" it will work. Because it parses all nodes.
*
* Ex: [4, 3.1, 4.2] target key is 3.9 --> Logic will go left. But 4.2 is the closes of 3.9
* ==========
*/
public class ClosestBinarySearchTreeValue {

  public int closestValue(TreeNode root, double target) {
    return closest(root, root.val, target);
  }
  // Ex: 100, 50, 150... target = 70... answer 50
  private int closest(TreeNode root, int currentCloseValue, double target) {
    root = target < root.val ? root.left : root.right; // DecideLeft
    if (root != null) {
      currentCloseValue =
          Math.abs(root.val - target) < Math.abs(currentCloseValue - target)
              ? root.val
              : currentCloseValue; // 1))(70-50)<100-50
      return closest(root, currentCloseValue, target); // GoLeft.
    }
    return currentCloseValue;
  }
}
