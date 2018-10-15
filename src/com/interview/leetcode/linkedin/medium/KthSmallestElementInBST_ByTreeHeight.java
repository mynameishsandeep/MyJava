package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/submissions/detail/181247087/
 * 
 * ==Note: We start getting height from left... not root=========
 * Ex: 100 50 200==> 100 is root, 50 is left, 200 is right.

 * To get second lowest, 
 * I will pass 50. which is left of root(100). which will return 1 as height.
 * height+1 = k. So returns parent value of 50 i.e 100 
 * 
 * To get third lowest, 
 * 1) I will pass 50. which is left of root(100). which will return 1 as height.
 * height+1<k, so it will go for right, with k size reduced to 1. 
 * 2) Doing height for null (left of 200) which returns 0 as height.
 * height+1 = k. So return parent value of null i.e 200.
 * 
 * 
 * ======================
 * 
 * We count the number of nodes of left sub tree and right sub tree recursively. 
 * Suppose the Kth smallest element is in the right sub tree, 
 * then we need to update k as k - leftCount - 1 (leftCount + 1 is the number of nodes of left sub tree plus the root node). 
 * Only when k equals leftCount + 1, we find the target.
 */
public class KthSmallestElementInBST_ByTreeHeight {
	public int kthSmallest(TreeNode root, int k) {
		int height = treeHeight(root.left);

		if (height + 1 == k) {
			return root.val;
		} else if (height + 1 > k) {
			return kthSmallest(root.left, k);
		} else {
			return kthSmallest(root.right, k - height - 1);
		}

	}

	private int treeHeight(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + treeHeight(root.left) + treeHeight(root.right);
	}
}
