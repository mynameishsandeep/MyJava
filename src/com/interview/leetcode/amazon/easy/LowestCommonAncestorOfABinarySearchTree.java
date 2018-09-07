package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * 
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T 
 * that has both v and w as descendants."
 * 
 * Note::::::::::  we allow a node to be a descendant of itself
 *
Approach:
1) Use the BST property. 
	a) If search key is less than root, then result lies in left
	b) If search key is greater than root, then result lies in right
	a) If search key is equal to root, then result is root 

Solution: 
1) If value of both p and q are greater than the node's value, then they both must be to the right side of the node. Therefore, move right: node = node.right.
2) If value of both p and q are smaller than the node's value, then they both must be to the left side of the node. Therefore, move left: node = node.left.
3) Else means p and q are on either side of the node, which means node is the answer. Therefore, we break loop at this point.

Time Complexity: O(h) ---> h is height of tree
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
