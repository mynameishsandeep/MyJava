package com.sample.datastructure.tree;

import java.util.Stack;

public class TreePrePostInOrderTraversal {

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

	// This method is similar to depth first search of a element
	public void printPreOrderUsingStack() {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()) {
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

	public void printPreOrderRecurse(Node root) {

		if (root == null) {
			return;
		}
		// Visit the node by Printing the node data
		System.out.printf("%d ", root.data);

		printPreOrderRecurse(root.left);
		printPreOrderRecurse(root.right);

	}

	public void printPostOrderUsingStack(Node root) {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();

			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
			System.out.printf("%d ", node.data);

		}
	}

	public void printPostOrderRecurse(Node root) {
		if (root != null) {
			printPostOrderRecurse(root.left);
			printPostOrderRecurse(root.right);
			// Visit the node by Printing the node data
			System.out.printf("%d ", root.data);
		}
	}

	public void printInOrderRecurse(Node root) {
		if (root != null) {
			printInOrderRecurse(root.left);
			// Visit the node by Printing the node data
			System.out.printf("%d ", root.data);
			printInOrderRecurse(root.right);
		}
	}

	public static void main(String[] args) {
		TreePrePostInOrderTraversal p = new TreePrePostInOrderTraversal();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(6);
		p.add(20);
		p.add(30);
		p.add(15);
		p.add(21);
		p.add(22);
		System.out.println("=====printPreOrderRecurse====");
		p.printPreOrderRecurse(p.root);
		System.out.println();
		System.out.println("=====printPreOrderUsingStack====");
		p.printPreOrderUsingStack();
		System.out.println();
		System.out.println("=====printPostOrderUsingStack====");
		p.printPostOrderUsingStack(p.root);
		System.out.println();
		System.out.println("=====printInOrderRecurse====");
		p.printInOrderRecurse(p.root);

	}

}
