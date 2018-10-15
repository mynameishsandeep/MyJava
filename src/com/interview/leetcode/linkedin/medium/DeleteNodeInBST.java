package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.TreeNode;

/*
 * https://www.youtube.com/watch?v=gcULXE7ViZw&vl=en
 * 
 * See the image "Delete a Node In BST.JPG" in "US Problems" folders
 * 
 * 1) Delete is not actually not delete (i.e) it is unlinking "only" the leaf node.
 * 2) The search key might exists anywhere in BST, but still we unlink only the leaf node.
 * 3) This is possible only because of property in BST. 
 * For tree other than BST. we have to do unlink and link. 
 * 
 * 1) If the node to be deleted has no child. simply delete.
 * 2) If the node to delete has 1 child right. Link root with right.
 * 3) If the node to delete has 1 child left. Link root with left.
 * 4) Else
 * 		a) Find right most minimum of root.
 * 		b) delete the "right most minimum of root".
 * 		c) set the root data with "right most minimum data of root"...Note: It is not linking. it is setting the data in root.
 * === Tricky... order matters in "b" and "c"========
 * 
 * 
 */

public class DeleteNodeInBST {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		} else if (root.val == key) { // Match Found Delete Case
			root = delete(root);
		} else if (root.val > key) { // Go Left
			root.left = deleteNode(root.left, key);
		} else { // Go Right
			root.right = deleteNode(root.right, key);
		}
		return root;
	}

	private TreeNode delete(TreeNode root) {
		if (root.left == null && root.right == null) { // Link root with null i.e leaf reached
			root = null;
		} else if (root.right == null) { // Link root with left
			root = root.left;
		} else if (root.left == null) { // Link root with right
			root = root.right;
		} else {
			TreeNode node = findMinimumFromRight(root.right); // Find right most minimum
			deleteNode(root, node.val); // delete the minimum.
			root.val = node.val; // replace minimum value with root value.
		}
		return root;
	}

	TreeNode findMinimumFromRight(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node.left == null) {
			return node;
		}
		return findMinimumFromRight(node.left);
	}
}
