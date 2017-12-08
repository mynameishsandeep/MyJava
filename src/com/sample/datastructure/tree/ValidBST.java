package com.sample.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution 1) 
 * 		a) Do In-Order Traversal of the given tree and store the result in a temp array. 
 * 		b) Check if the temp array is sorted in ascending order, if it is, then the tree is BST.
 * 		Time Complexity: O(n) Space Complexity: O(n)
 * 
 * Solution 2) --- We can avoid the use of Auxiliary Array. Tree Image is present in "US Problems" "ValidBST.jpg" 
 * 		a) Traverse in anyone of In-Order or Pre-Order or Post-Order. 
 * 		   aq	Mostly Pre-Order for better understanding
 * 		b) Set min and max to Long.MIN_VALUE and Long.MAX_VALUE.
 * 		c) At any point node value should lie between min and max. Else False. 
 * 		d) For left side traverse, update max with current data.
 * 		e) For right side traverse, update min with current data.
 * 		Time Complexity: O(n) Space Complexity: O(h)--> h is height of tree  
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
	    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);    
	}
	 
	public boolean isValidBST(Node root, long min, long max) {
        if(root!=null) {
            if(root.data <= min || root.data >= max) {
                return false;
            }
            Boolean left = isValidBST(root.left, min, root.data);
            Boolean right = isValidBST(root.right, root.data, max);
            return left && right;
        }
        return true;
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
