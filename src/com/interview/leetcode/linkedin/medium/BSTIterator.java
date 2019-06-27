package com.interview.leetcode.linkedin.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/submissions/detail/180297071/

    1) Requirement is to use uses O(h) memory..
    Save "data on left side of tree" to stack, during init
    2) During next() call, pick data from stack which is result.
    Then Check if the node has right. If the node has right, then push all the left of right to stack.
    
    Ex: 8, 4, 9, 3 , 6 , 5 , 7

 */
public class BSTIterator {

	private Deque<TreeNode> stack = new ArrayDeque<>();

	public BSTIterator(TreeNode root) {
		if (null == root) {
			return;
		}
		stack.push(root);
		while (null != root.left) {
			stack.push(root.left);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		TreeNode result = stack.pop();
		if (null != result.right) {
			TreeNode right = result.right;
			stack.push(right);
			while (null != right.left) {
				stack.push(right.left);
				right = right.left;
			}
		}
		return result.val;
	}
}
