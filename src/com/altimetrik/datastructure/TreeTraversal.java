package com.altimetrik.datastructure;

import java.util.Stack;

public class TreeTraversal {

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

	public void printPreOrder() {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.empty()) {
			Node n = stack.pop();
			System.out.printf("%d ", n.data);
			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
	}

	public void printPostOrder(Node root) {
		if (root != null) {
			printPostOrder(root.left);
			printPostOrder(root.right);
			// Visit the node by Printing the node data
			System.out.printf("%d ", root.data);
		}
	}

	public void printInOrder(Node root) {
		if (root != null) {
			printInOrder(root.left);
			// Visit the node by Printing the node data
			System.out.printf("%d ", root.data);
			printInOrder(root.right);
		}
	}
	
	public int treeHeight(Node root){
		if(root==null)return 0;
		return (1+ Math.max(treeHeight(root.left),treeHeight(root.right)));
	}

	public static void main(String[] args) {
		TreeTraversal p = new TreeTraversal();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(6);
		p.add(20);
		p.add(30);
		p.add(15);
		p.printPreOrder();
		System.out.println("");
		p.printPostOrder(p.root);
		System.out.println("");
		p.printInOrder(p.root);
		System.out.println(p.treeHeight(p.root));

	}

}
