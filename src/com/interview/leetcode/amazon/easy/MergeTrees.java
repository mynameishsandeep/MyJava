package com.interview.leetcode.amazon.easy;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 * 
 *  This implementation cannot be done using stack (dfs stack api approach) or queue (bfs queue api approach). 
 *  Because we need to associate nodes in case of empty. 
 *  So recursion is the ideal approach.
 *  
		Traverse the tree in Pre-order fashion
		Check if both the tree nodes are NULL
		If not, then update the value
		Recur for left subtrees
		Recur for right subtrees
		Return root of updated Tree
 *
 */
public class MergeTrees {

	class Node {
		Node left;
		Node right;
		int data;
	}

	/* Method to merge given two binary trees*/
	static Node MergeTrees(Node t1, Node t2) {
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;
		t1.data += t2.data;
		t1.left = MergeTrees(t1.left, t2.left);
		t1.right = MergeTrees(t1.right, t2.right);
		return t1;
	}
}
