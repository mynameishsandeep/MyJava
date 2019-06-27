package com.interview.leetcode.facebook.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree {

	public TreeNode increasingBST(TreeNode root) {
		TreeNode dummy = new TreeNode(0);
		TreeNode[] aResult = new TreeNode[] { dummy };
		recur(aResult, root);
		return dummy.right;
	}

	private void recur(TreeNode[] result, TreeNode node) {
		if (node == null) {
			return;
		}
		recur(result, node.left);
		TreeNode resultNode = new TreeNode(node.val);
		result[0].right = resultNode;
		result[0] = result[0].right;
		recur(result, node.right);
	}
}
