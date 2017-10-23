package com.sample.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You can't really do this operation with recursion. Because recursion is about
 * going deeper, but this logic needs level order. You need explicit data
 * structures such as a queue, stack, list to implement this operation.
 *
 */
public class TreeBreadthFirstSearch {

	
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
	
	public boolean BFS(Node node, int searchData) {
		if(node == null) {
			return false;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while(!q.isEmpty()) {
				Node current = q.poll();
				System.out.println("Node Data is : " + current.data);
				if(current.data == searchData) {
					return true;
				}
				if(current.left!= null) {
					q.add(current.left);
				}
				if(current.right!= null) {
					q.add(current.right);
				}
			}
		return false;
	}

	public static void main(String[] args) {
		TreeBreadthFirstSearch p = new TreeBreadthFirstSearch();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(6);
		p.add(20);
		p.add(30);
		p.add(15);
		System.out.println(p.BFS(p.root, 30));
		System.out.println(p.BFS(p.root, 31));
		
	}
}
