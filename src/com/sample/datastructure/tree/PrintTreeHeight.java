package com.sample.datastructure.tree;

public class PrintTreeHeight {

	class Node {
		int data;
		Node left;
		Node right;
	}

	Node root;

	public int treeHeight(Node root) {
		if (root == null)
			return 0;
		int left = 1 + treeHeight(root.left);
		int right = 1 + treeHeight(root.right);
		return Math.max(left, right);
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
