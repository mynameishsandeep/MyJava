package com.interview.leetcode.google.easy;

import com.interview.leetcode.TreeNode;

public class LongestUnivaluePath {
	int result = 0;

	public int longestUnivaluePath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int prevLeft = root.left != null ? longestUnivaluePath(root.left) : 0;
		int prevRight = root.right != null ? longestUnivaluePath(root.right) : 0;
		int resultLeft = root.left != null && root.val == root.left.val ? prevLeft + 1 : prevLeft;
		int resultRight = root.right != null && root.val == root.right.val ? prevRight + 1 : prevRight;
		result = Math.max(result, resultLeft + resultRight);
		return result;
	}
}
