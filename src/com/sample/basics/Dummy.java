package com.sample.basics;

import java.util.Scanner;

public class Dummy {

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
				Node temp = new Node();
				temp.data = scan.nextInt();
				if (node == null) {
					node = temp;
				} else {
					Node temp1 = node;
					while (true) {
						if (node.data > temp.data) {
							if (temp1.left == null) {
								temp1.left = temp;
								break;
							} else {
								temp1 = temp1.left;
							}
						} else {
							if (temp1.right == null) {
								temp1.right = temp;
								break;
							} else {
								temp1 = temp1.right;
							}
						}

					}
				}
			}
			int searchData = scan.nextInt();
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
					printInOrder(temp1);
					break;
				}

			}

		}
	}
	
	public static void printInOrder(Node root) {
		if (root != null) {
			printInOrder(root.left);
			// Visit the node by Printing the node data
			System.out.printf("%d ", root.data);
			printInOrder(root.right);
		}

		
	}
}
