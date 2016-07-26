package com.sample.datastructure;

import java.util.Scanner;
/*
 * 1) Create a Binary Search Tree.
 * 2) Search a element, then print the sub-tree of elements in Pre-Order
 * SAMPLE INPUT 
5
2 1 4 3 5
4

SAMPLE OUTPUT 
4
3
5
 */
public class TreeSearchANumberAndPrintSubTree {

	static class Node {
		int data;
		Node left;
		Node right;
	}

	public static void main(String args[]) throws Exception {
		Node node = null;
		try (Scanner scan = new Scanner(System.in)) {
			int n = scan.nextInt();
			for (int i = 0; i < n; i++) {
				Node currentNode = new Node();
				currentNode.data = scan.nextInt();
				if (node == null) {
					node = currentNode;
				} else {
					Node temp1 = node;
					while (true) {
						if (temp1.data > currentNode.data) {
							if (temp1.left == null) {
								temp1.left = currentNode;
								break;
							} else {
								temp1 = temp1.left;
							}
						} else {
							if (temp1.right == null) {
								temp1.right = currentNode;
								break;
							} else {
								temp1 = temp1.right;
							}
						}

					}
				}
			}
			int searchData = scan.nextInt();
			System.out.println("searchData " + searchData);
			System.out.println("Sub-Trees of " + searchData + " In Pre-Order are below : ");
			Node temp1 = node;

			while (true) {
				if (temp1.data > searchData) {
					if (temp1.left == null) {
						break;
					}
					temp1 = temp1.left;
				} else if (temp1.data < searchData) {
					if (temp1.right == null) {
						break;
					}
					temp1 = temp1.right;
				} else {
					printPreOrder(temp1);
					break;
				}

			}

		}
	}

	public static void printPreOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
}

