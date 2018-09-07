package com.sample.datastructure.tree;

/*
 * The height of a binary tree is the number of edges between the tree's root and its furthest leaf. 
 * A tree containing a single node has a height of 0, if we count by edges.
 * A tree containing a single node has a height of 1, if we go by node count.
 * 
 * Note:To return the count of nodes "return 0" in recursive base condition. 
 * https://www.youtube.com/watch?v=_pnqMz5nrRs at 5.02 timing
 * https://www.youtube.com/watch?v=_SiwrPXG9-g --- understanding call stack...
 *  
 *  Time Complexity : O(n)
 */
public class PrintTreeHeight {

	class Node {
		int data;
		Node left;
		Node right;
	}

	Node root;

	public int treeHeight(Node root) {
		if (root == null) {
			return -1;
		}
		int left = treeHeight(root.left);
		int right = treeHeight(root.right);
		return Math.max(left, right) + 1;
	}

	public void add(int data) {
		Node tempRoot = root;
		Node currNode = new Node();
		currNode.data = data;
		if (tempRoot == null) {
			root = currNode;
		} else {
			while (true) {
				if (data < tempRoot.data) {
					if (tempRoot.left != null) {
						tempRoot = tempRoot.left;
					} else {
						tempRoot.left = currNode;
						break;
					}
				} else {
					if (tempRoot.right != null) {
						tempRoot = tempRoot.right;
					} else {
						tempRoot.right = currNode;
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		PrintTreeHeight p = new PrintTreeHeight();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(6);
		p.add(20);
		p.add(30);
		p.add(15);
		p.add(21);
		p.add(22);

		System.out.println();
		System.out.println("Height of the Tree is " + p.treeHeight(p.root));

	}
}
