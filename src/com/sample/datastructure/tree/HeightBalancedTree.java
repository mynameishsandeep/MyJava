package com.sample.datastructure.tree;

/**
 * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 * 
 * An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.

The below logic will take O(n^2). 
 */

public class HeightBalancedTree {
	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	Node root;

	private boolean isBalanced(Node node) {
		/* If tree is empty then return true */
		if (node == null)
			return true;

		/* Get the height of left and right sub trees */
		int lh = height(node.left);
		int rh = height(node.right);

		if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right))
			return true;

		/* If we reach here then tree is not height-balanced */
		return false;
	}

	int height(Node node) {
		/* base case tree is empty */
		if (node == null)
			return 0;

		return 1 + Math.max(height(node.left), height(node.right));
	}

	public static void main(String args[]) {
		HeightBalancedTree tree = new HeightBalancedTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(8);

		if (tree.isBalanced(tree.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}
