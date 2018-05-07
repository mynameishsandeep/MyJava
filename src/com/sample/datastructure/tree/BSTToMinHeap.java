package com.sample.datastructure.tree;

import java.util.LinkedList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/convert-bst-min-heap/
 * The above link problem has 1 more condition along with min heap. i.e left child tree should 
 * be less than right child tree. This can be achieved only by Solution2
 * 
 * Solution 1:
 * 1) Traverse the tree in-order and copy the node values in an array. The data will be sorted order.
 * 2) Traverse the tree again in Level-Order and replace the data in node. Result in Min Heap.
 * 
 * Solution 2:
 * Step 2 traversal can be replaced with pre-order traversal, which will satisfy the Min-Heap condition. 
 * i.e parent node data will be lesser than the child data.
 */
public class BSTToMinHeap {

	class Node {
		Integer data;
		Node left;
		Node right;

		Node(Integer data) {
			this.data = data;
		}
	}

	Node root;

	public void add(Integer data) {
		Node n = new Node(data);
		if (root == null) {
			root = n;
		} else {
			Node temp = root;
			while (temp.left != null || temp.right != null) {
				if (data > temp.data) {
					if (temp.right == null) {
						break;
					}
					temp = temp.right;
				} else {
					if (temp.left == null) {
						break;
					}
					temp = temp.left;
				}
			}
			if (data > temp.data) {
				temp.right = n;
			} else {
				temp.left = n;
			}
		}
	}

	/**
	 * By traversing root as In Order Traversal. We will get output as Ascending Order
	 */
	public void readAsAscending(Node root, List<Integer> nodeList) {
		if (root == null) {
			return;
		}
		readAsAscending(root.left, nodeList);
		nodeList.add(root.data);
		System.out.println(root.data);
		readAsAscending(root.right, nodeList);
	}

	/*
	 * By traversing root as level order traversal and changing its value from sorted list,
	 * min heap is formed.
	 * 
	 */
	public void convertToMinHeap(LinkedList<Integer> nodeList) {
		LinkedList<Node> queue = new LinkedList<>();
		Node temp = root;
		temp.data = nodeList.poll();
		queue.offer(temp);
		while (queue.size() > 0) {
			temp = queue.poll();

			if (temp.left != null) {
				temp.left.data = nodeList.poll();
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				temp.right.data = nodeList.poll();
				queue.offer(temp.right);
			}
		}
	}

	public void levelOrderTraversalDisplay(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		Node temp = root;
		queue.offer(temp);
		while (queue.size() > 0) {
			temp = queue.poll();
			System.out.println(temp.data);
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		BSTToMinHeap p = new BSTToMinHeap();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(6);
		p.add(20);
		p.add(30);
		p.add(15);
		LinkedList<Integer> nodeList = new LinkedList<>();
		p.readAsAscending(p.root, nodeList);
		p.convertToMinHeap(nodeList);
		p.levelOrderTraversalDisplay(p.root);

	}

}
