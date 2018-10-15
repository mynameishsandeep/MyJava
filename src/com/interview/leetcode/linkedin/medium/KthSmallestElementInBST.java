package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/submissions/detail/181247087/
 */
public class KthSmallestElementInBST {
	int count = 0;
	int result = 0;

	public int kthSmallest(TreeNode root, int k) {
		traverseInOrder(root, k);
		return result;
	}

	public void traverseInOrder(TreeNode root, int k) {
		if (root != null && count < k) {
			traverseInOrder(root.left, k);
			++count;
			if (count == k) {
				result = root.val;
			}
			traverseInOrder(root.right, k);
		}

	}
}
