package com.interview.leetcode.facebook.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */
public class BinaryTreePreorderTraversal {

	/*
	             10
	        5        15
	    4      7  13    20
	        Result should be : 10 5 4 7 15 13 20
	    
	*/
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop(); // 10 5 4 7
			result.add(root.val);
			if (root.right != null) {
				stack.push(root.right); // 15  7             
			}
			if (root.left != null) {
				stack.push(root.left); // 5   4            
			}
		}
		return result;
	}

	/*
	 * Note that in this solution only right children are stored to stack.
	             10
	        5        15
	    4      7  13    20
	        Result should be : 10 5 4 7 15 13 20
	   
	   For the above example: 15 7 and 20 are saved in stack. 
	 * 
	 */
	public List<Integer> preorderTraversal_HalfSpace(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null) {
			list.add(root.val);
			if (root.right != null) {
				stack.push(root.right); // 15 7 20
			}
			if (root.left != null) {
				root = root.left; 
			} else {
				if (!stack.isEmpty()) {
					root = stack.pop();
				} else {
					return list;
				}
			}
		}
		return list;

	}
}