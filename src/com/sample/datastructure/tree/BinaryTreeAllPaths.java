package com.sample.datastructure.tree;

public class BinaryTreeAllPaths {

	class Node {
		int data;
		Node left;
		Node right;
	}

	Node root;

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
		BinaryTreeAllPaths p = new BinaryTreeAllPaths();
		p.add(10);
		p.add(5);
		p.add(6);
		p.add(20);
		p.DFS(p.root, "");

	}

	public void DFS(Node startNode, String result) {
		if (startNode.left == null && startNode.right == null) {
			System.out.println(result + startNode.data);
		} else {
			if (startNode.left != null) {
				DFS(startNode.left, result + startNode.data + "->");
			}
			if (startNode.right != null) {
				DFS(startNode.right, result + startNode.data + "->");
			}
		}
	}
}
