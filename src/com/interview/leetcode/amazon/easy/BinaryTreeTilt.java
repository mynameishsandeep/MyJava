package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-tilt/
Tilt is defined as the absolute difference between the sum of all left subtree nodes values
and the sum of all right subtree nodes values.
========================================================================
				           1
				        /    \
				       2      3
				      / \    /
				     4   n  5
								Output = 11
Tilt of node 2 : 0-4 = 4
Tilt of node 3 : 0-5 = 5
Tilt of node 1 : 8-6 = 2
                      ===
				       11
========================================================================
					    4
					   / \
					  2   9
					 / \   \
					3   5   7
								Output : 15
Tilt of node 3 : 0
Tilt of node 5 : 0
Tilt of node 7 : 0
Tilt of node 2 : |3-5| = 2
Tilt of node 9 : |0-7| = 7
Tilt of node 4 : |(3+5+2)-(9+7)| = 6
Tilt of binary tree : 0 + 0 + 0 + 2 + 7 + 6 = 15
==========================================
						1
					   / \
					  2   n
					 / \
					3   4
				   				Output : 10

=======================Solution Approach=================================================

    1) Accumulate the result
    2) Return left, right and sum.


 */
public class BinaryTreeTilt {
  public int findTilt(TreeNode root) {
    recur(root);
    return result;
  }

  int result = 0;

  private int recur(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return root.val;
    int leftSum = recur(root.left);
    int rightSum = recur(root.right);
    result += Math.abs(leftSum - rightSum);
    return leftSum + rightSum + root.val;
  }
}
