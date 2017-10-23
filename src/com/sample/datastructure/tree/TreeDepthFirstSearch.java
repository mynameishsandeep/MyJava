package com.sample.datastructure.tree;

import java.util.Stack;

public class TreeDepthFirstSearch {

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

	public boolean DFS(Node startNode, int k) {
		if (startNode == null) {
			return false;
		} else if (startNode.data == k) {
			return true;
		} else {
			System.out.println("Node Data is : " + startNode.data);
			return DFS(startNode.left, k) || DFS(startNode.right, k);
		}
	}

	// Method 2: DFS using stack
	public boolean DFSUsingStack(Node root, int k) {
		if (root == null) {
			return false;
		}
		Stack<Node> stack = new Stack<Node>();
		// Queue<Node> queue = new LinkedList<Node>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.println("Node Data is : " + current.data);
			if (current.data == k) {
				return true; // Found the value!
			}
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) { // As we want to visit left
				stack.push(current.left); // child first, we must push this node
											// last
			}
		}
		return false;
	}

	// Method 2: DFS using stack
	public boolean DFSUsingStackAndPrintVisitingNodes(Node root, int k) {
		if (root == null) {
			return false;
		}
		Stack<Node> stack = new Stack<Node>();
		// Queue<Node> queue = new LinkedList<Node>();
		stack.push(root);
		Stack<Node> resultStack = new Stack<>();
		resultStack.push(root);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.println("Node Data is : " + current.data);
			if (current.data == k) {
				return true; // Found the value!
			}
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) { // As we want to visit left
				stack.push(current.left); // child first, we must push this node
				resultStack.push(current.left); // last
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TreeDepthFirstSearch p = new TreeDepthFirstSearch();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(6);
		p.add(20);
		p.add(30);
		p.add(15);
		System.out.println(p.DFS(p.root, 30));
		System.out.println(p.DFSUsingStack(p.root, 30));
	}
}
