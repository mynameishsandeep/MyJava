package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * 
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T 
 * that has both v and w as descendants."
 * 
 * Note::::::::::  we allow a node to be a descendant of itself
 */
public class LowestCommonAncestorOfABinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (true) {
			if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else {
				return root;
			}
		}
	}

	public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}

	}
}
