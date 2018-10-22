package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.interview.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * 
 * 1) Traverse the Tree by Level Order. 
 * 2) Add a for loop inside level order traversal. That runs till the current size of queue.
 * 3) The queue size determines 1 level of current level traversal. 
 * 4) When the for loop ends add the level result to main result, that would be result of 1 level
 * 
 * Ex:
 * 					1
 * 				2		3
 * 			4	   5  6		7
 * 1) Initial size of inner for loop is 1(Based on current queue size). Then left and right is added to queue. 
 * 2) Now size of inner for loop is 2(because currently queue has 2 and 3.) 
 * 3) On iteration 3. size of inner for loop is 4(because currently queue has 4,5,6,7)
 */

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (queue.size() > 0) {
				// Do not get queue.size() inside for loop. Because queue size varies. So keep it statically
				int size = queue.size();
				List<Integer> levelResult = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					root = queue.poll();
					levelResult.add(root.val);
					if (root.left != null) {
						queue.offer(root.left);
					}
					if (root.right != null) {
						queue.offer(root.right);
					}
				}
				result.add(levelResult);
			}
		}
		return result;
	}
}
