package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.Node;

public class MaximumDepthOfNAryTree {

	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		} else {
			int maxDepth = 0;
			for (Node n : root.children) {
				int currentDepth = maxDepth(n);
				if (currentDepth > maxDepth) {
					maxDepth = currentDepth;
				}
			}
			return 1 + maxDepth;
		}
	}
}
