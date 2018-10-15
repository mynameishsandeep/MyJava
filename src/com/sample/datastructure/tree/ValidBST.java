package com.sample.datastructure.tree;

import com.interview.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * 
 * Solution 1) BruteForce 
 * 		a) Do In-Order Traversal of the given tree and store the result in a temp array. 
 * 		b) Check if the temp array is sorted in ascending order, if it is, then the tree is BST.
 * 		Time Complexity: O(n) Space Complexity: O(n)
 * 
 * Solution 2)
 * 		1) Consider 3 node.... 2 1 3 --> 2 is root, 1 is left and 3 is right
 * 		2) At any point left is left and right is greater.
 * 		3) Set min and max...
 * 		4) Then Validate ---> node lies between ---> min and max...
 * 		5) For root --> min,  root,      max    --> 	-∞, 2, ∞
 * 		6) For left --> min,  root.left, root   --> 	-∞, 1, 2
 * 		7) For right--> root, roo.right, max    -->	  	 2, 3, ∞ 
 * 		8) At any point if "current value" is "less than or equal to min" or greater than or equal to max" return false.
 * 		9) if reached end, return true. 
 * 		10) result = left && right ==note here===  
 *    
 * 		Time Complexity: O(n) Space Complexity: O(1)  
 * 
 */
public class ValidBST {

	public boolean isValidBST(TreeNode root) {
		long max = Long.MAX_VALUE;
		long min = Long.MIN_VALUE;
		return isValid(min, root, max);
	}

	private boolean isValid(long min, TreeNode root, long max) {
		if (root == null) {
			return true;
		}
		if (root.val <= min || root.val >= max) {
			return false;
		}
		boolean left = isValid(min, root.left, root.val);
		boolean right = isValid(root.val, root.right, max);
		return left && right;
	}

}
