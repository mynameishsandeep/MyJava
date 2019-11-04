package com.sample.datastructure.tree;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * Solution 1) BruteForce
 * 		a) Do In-Order Traversal of the given tree and store the result in a temp array.
 * 		b) Check if the temp array is sorted in ascending order, if it is, then the tree is BST.
 * 		Time Complexity: O(n) Space Complexity: O(n)
 *
 * Solution 2)
 * 		1) Consider 3 node.... 2 1 3 --> 2 is root, 1 is left and 3 is right
 * 		2) At any point left is smaller and right is greater.
 * 		3) Set low and high...
 * 		4) Then Validate ---> node lies between ---> low and high...
 * 		5) For root --> low,  root,      high    --> 	-∞, 2, ∞
 * 		6) For left --> low,  root.left, root   --> 	-∞, 1, 2
 * 		7) For right--> root, roo.right, high    -->	  	 2, 3, ∞
 * 		8) At any point if "current value" is "less than or equal to low" or greater than or equal to high" return false.
 * 		9) if reached end, return true.
 * 		10) result = left && right ==note here===
 *
 * 		Time Complexity: O(n) Space Complexity: O(1)
 *
 */
public class ValidBST {

  public boolean isValidBST(TreeNode root) {
    long high = Long.MAX_VALUE;
    long low = Long.MIN_VALUE;
    return isValid(low, root, high);
  }

  private boolean isValid(long low, TreeNode mid, long high) {
    if (mid == null) 
      return true;
    else if (mid.val < high && mid.val > low) {
      boolean left = isValid(low, mid.left, mid.val);
      boolean right = isValid(mid.val, mid.right, high);
      return left && right;
    } else {
      return false;
    }
  }
}
