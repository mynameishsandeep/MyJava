package com.interview.leetcode.linkedin.medium;

import com.leetcode.TreeNode;

/*
 * https://coding-interview-solutions.hackingnote.com/problems/clone-binary-tree.html
 */
public class CloneTree {
	public TreeNode cloneTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode clone = new TreeNode(root.val);
		clone.left = cloneTree(root.left);
		clone.right = cloneTree(root.right);
		return clone;
	}
}
