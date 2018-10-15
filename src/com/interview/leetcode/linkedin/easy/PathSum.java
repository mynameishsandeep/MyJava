package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/path-sum/description/
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum.
 * 
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (null == root) { // Edge case, when root itself null
			return false;
		}
		return recurse(root, sum);
	}

	public boolean recurse(TreeNode root, int sum) {
		if (root.left == null && root.right == null) { // Leaf is reached and no more to traverse
			return (root.val == sum);
		}
		boolean left = hasPathSum(root.left, sum - root.val);
		boolean right = hasPathSum(root.right, sum - root.val);
		return left || right;
	}
}
