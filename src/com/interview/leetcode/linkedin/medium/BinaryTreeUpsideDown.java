package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-upside-down/description/
 * 
 * Solution2:
 * https://leetcode.com/problems/binary-tree-upside-down/discuss/160896/Java-using-stack-AC
 */
public class BinaryTreeUpsideDown {

	/*
	 * 				1
	 * 			
	 * 			||		||
	 * 		2				3
	 * 
	 */
	public TreeNode upsideDownBinaryTree(TreeNode root) {

		if (root == null || root.left == null) {
			return root;
		}

		TreeNode newRoot = upsideDownBinaryTree(root.left); 
		root.left.left = root.right; // node 2 left children
		root.left.right = root; // node 2 right children
		root.left = null;
		root.right = null;
		return newRoot;
	}
}
