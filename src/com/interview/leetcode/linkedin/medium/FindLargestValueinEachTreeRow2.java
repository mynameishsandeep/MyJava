package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.interview.leetcode.TreeNode;

public class FindLargestValueinEachTreeRow2 {

	public List<Integer> largestValues(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		q.offer(root);
		while (q.size() > 0) {
			int size = q.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.val > max) {
					max = node.val;
				}
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
			result.add(max);
		}
		return result;
	}
}
