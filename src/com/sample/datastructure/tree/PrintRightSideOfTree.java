package com.sample.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.sample.datastructure.tree.TreeLevelOrderTraverse.Node;

/**
 * 1) Parse Tree by Level Order but from right to left. 2) If any one data is
 * printed break that row.
 * 
 * @author chandrasekhar
 *
 */
public class PrintRightSideOfTree {
	static class Node {
		Integer data;
		Node right;
		Node left;

		Node(Integer data) {
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
	
	public void levelOrderTraverseWithPrintOnlyRight() {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		Queue<Node> queueMain = new LinkedList<>();
		queueMain.offer(root);
		while (true) {
			Queue<Node> queueTemp = new LinkedList<>();
			Boolean print = false;
			while (queueMain.size() > 0) {
				Node temp = queueMain.remove();
				if (temp.left != null) {
					if(!print) {
						print = true;
						System.out.print(temp.left.data + " ");
					}
					queueTemp.offer(temp.left);
				}
				if (temp.right != null) {
					if(!print) {
						print = true;
						System.out.print(temp.right.data + " ");
					}
					queueTemp.offer(temp.right);
				}
			}
			if (queueTemp.size() == 0) {
				break;
			}
			System.out.print("#");
			queueMain.addAll(queueTemp);
		}
	}

	public static void main(String[] args) {
		PrintRightSideOfTree p = new PrintRightSideOfTree();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(20);
		p.levelOrderTraverseWithPrintOnlyRight();

	}

}
