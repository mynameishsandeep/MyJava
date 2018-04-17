package com.sample.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrderTraverse {
	static class Node {
		int data;
		Node right;
		Node left;

		Node(int data) {
			this.data = data;
		}
	}

	Node root;

	public void add(int data) {
		Node tempRoot = root;
		Node currNode = new Node(data);

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

	public void levelOrderTraverse() {
		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(q.size()>0) {
			Node temp = q.poll();
			System.out.print(temp.data +" ");
			if(temp.left!=null) {
				q.offer(temp.left);
			}
			if(temp.right!=null) {
				q.offer(temp.right);
			}
		}
		
	}
	/**
	 * At Each row end print a special character to indicate that row level is ending.
	 * 
	 * 1) Keep a main queue and push the root.
	 * 2) For each of items in main queue and traverse
	 * 3) take 1 item from queue.  
	 * 4) If left is not null, print and push the left node into temp queue.
	 * 5) If right is not null, print and push the right node into temp queue.
	 * 6) If the temp queue is empty break the main queue else copy the temp queue contents into main queue.
	 * 
	 * Note: 
	 * 1) You cannot do this operation is one queue. Because we need to print the end of level.
	 * 2) If we dont want to print the end of level. Then it can be done in one queue.
	 * 
	 * 
	 */
	public void levelOrderTraverseWithLevelEnd() {
		if (root == null) {
			return;
		}
		System.out.print(root.data +" " + "#");
		Queue<Node> queueMain = new LinkedList<>();
		queueMain.offer(root);
		while (true) {
			Queue<Node> queueTemp = new LinkedList<>();
			while (queueMain.size() > 0) {
				Node temp = queueMain.remove();
				if (temp.left != null) {
					System.out.print(temp.left.data + " ");
					queueTemp.offer(temp.left);
				}
				if (temp.right != null) {
					System.out.print(temp.right.data + " ");
					queueTemp.offer(temp.right);
				}
			}
			if (queueTemp.size() == 0) {
				break;
			}
			System.out.print("#");
			queueMain.addAll(queueTemp);
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		TreeLevelOrderTraverse p = new TreeLevelOrderTraverse();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(6);
		p.add(20);
		p.add(30);
		p.add(15);
		p.levelOrderTraverse();
		
		p.levelOrderTraverseWithLevelEnd();

	}

}
