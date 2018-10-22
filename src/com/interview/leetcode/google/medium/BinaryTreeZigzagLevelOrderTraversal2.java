package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * Refer Problem "FindLeavesOfBinaryTree_BottomUpRecurse.java"
 * 
 */
public class BinaryTreeZigzagLevelOrderTraversal2 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		travel(res, 0, root);
		return res;
	}

	private void travel(List<List<Integer>> res, int level, TreeNode cur) {
		if (cur == null)
			return;
		if (res.size() == level) {
			res.add(new ArrayList<Integer>());
		}
		if (level % 2 == 0) {
			res.get(level).add(cur.val);
		} else {
			res.get(level).add(0, cur.val);
		}
		travel(res, level + 1, cur.left);
		travel(res, level + 1, cur.right);
	}

}
