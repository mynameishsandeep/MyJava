package com.sample.datastructure.tree;

import com.sample.datastructure.tree.TreeDiameterOrLongestPath.TreeNode;

/*
 *https://leetcode.com/problems/invert-binary-tree/description/ 
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
        if (root == null) 
			return null;
		else {
			invertTree(root.left);
			invertTree(root.right);
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
        return root;
    }
	
}
