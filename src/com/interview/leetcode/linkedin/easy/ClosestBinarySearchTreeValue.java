package com.interview.leetcode.linkedin.easy;

import com.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/closest-binary-search-tree-value/description/
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

	Logic : Capture 1 value greater than target and 1 value less than target in Pair. 
	Compare and send whichever is closest. 
 */
public class ClosestBinarySearchTreeValue {

	public int closestValue(TreeNode root, double target) {
		return closest(root, target, root.val);
	}

	private int closest(TreeNode node, double target, int val) {
		if (node == null)
			return val;
		if (Math.abs(node.val - target) < Math.abs(val - target))
			val = node.val;
		if (node.val < target)
			val = closest(node.right, target, val);
		else if (node.val > target)
			val = closest(node.left, target, val);
		return val;
	}
}
