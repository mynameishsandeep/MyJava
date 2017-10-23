package com.sample.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1) Do In-Order Traversal of the given tree and store the result in a temp
 * array. 3) Check if the temp array is sorted in ascending order, if it is,
 * then the tree is BST.
 * 
 * Time Complexity: O(n)
 * 
 * We can avoid the use of Auxiliary Array. While doing In-Order traversal, we
 * can keep track of previously visited node. If the value of the currently
 * visited node is less than the previous value, then tree is not BST.
 * 
 * @author chandrasekhar
 *
 */
public class ValidBST {

	class Node {
		int data;
		Node left;
		Node right;
	}
	List<Integer> result = new ArrayList<>();
	private Node root;
	private Node prev;

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

	public boolean isValidBST(Node root) {
	    return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
	}
	 
	private boolean isValidBST(Node p, double min, double max){
	    if(p==null) 
	        return true;
	 
	    if(p.data <= min || p.data >= max)
	        return false;
	 
	    return isValidBST(p.left, min, p.data) && isValidBST(p.right, p.data, max);
	}
	
	public void printInOrderRecurse(Node root) {
		if (root != null) {
			printInOrderRecurse(root.left);
			// Visit the node by Printing the node data
			result.add(root.data);
			printInOrderRecurse(root.right);
		}
	}


	public static void main(String[] args) {
		ValidBST p = new ValidBST();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(6);
		p.add(20);
		p.add(30);
		p.add(15);
		p.printInOrderRecurse(p.root);
		System.out.println(p.result.toString());
		p.result.clear();

		p.add(21);
		p.printInOrderRecurse(p.root);
		System.out.println(p.result.toString());

		System.out.println(p.isValidBST(p.root));
	}

}
