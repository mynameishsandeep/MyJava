package com.interview.leetcode.ebay;

/*
 * https://leetcode.com/problems/subtree-of-another-tree/description/
Given two non-empty binary trees s and t, check whether tree t has exactly the 
same structure and node values with a subtree of s.

Solution: Recursively(preorder) For each Node in S & T. validate if child is same using preorder.
So Time Complexity is O(mn)  
 * 
 */
public class SubtreeOfAnotherTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s != null && t != null) {
			if (isSame(s, t)) {
				return true;
			} else {
				// Tricky... for each s.left send t node and for each s.left send t node 
				return isSubtree(s.left, t) || isSubtree(s.right, t);
			}
		} else {
			return false;
		}
//		Boolean left = isSubtree(s.left, t);
//		Boolean right = isSubtree(s.right, t);
//		return left || right;
	}

	private boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.val != t.val) {
			return false;
		}
		Boolean left = isSame(s.left, t.left);
		Boolean right = isSame(s.right, t.right);
		return left && right;
	}
}
