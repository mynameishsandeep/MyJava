package com.sample.datastructure.tree;

import com.interview.leetcode.TreeNode;

/*
 *https://leetcode.com/problems/invert-binary-tree/description/ 
 *
 * 1) No need to check for "null on right" or "null on left".
 * 2) Because we can swap at both cases. Ex: null(left) with data(right) and vice versa.
 * 3) Swap is not possible only when both left and right are null. This check also we are doing only for performance.
 * 
 * ============================
 * Ex: 3,2,4,1 -->3 is root, 2 is left, 4 is right, 1 is left.left
 * 
 *  Recursion go all the way to left which is 1. Goes to Swap method. 1 is not having left & right, so no swap.
 *  Then back track to 2. 2(parent of 1) comes. Goes to Swap method. 1 changed from left to right.
 *  Then back track to 3. 3(parent of 2 or root) comes. Goes to Swap method. 2 and 4 are swapped.
 *  Then back track to 4. Goes to Swap method. 4 is not having left & right, so no swap.
 *  
 *  So total of 2 swap operation.
 *  ================================
 *  
 *  ==== For a 7 node(balanced) there will be 3 swap operation==========
 */
public class InvertBinaryTree_Mirror {

	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			invertTree(root.left);
			invertTree(root.right);
			swap(root);
		}
		return root;
	}

	private void swap(TreeNode root) {
		if (root.left == null && root.right == null) { // For Performance. We can skip the leaf node, which doesn't have left and right
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

}
