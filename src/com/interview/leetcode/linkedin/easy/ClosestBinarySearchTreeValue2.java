package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/closest-binary-search-tree-value/description/
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

	Logic : Capture 1 value greater than target and 1 value less than target in Pair. 
	Compare and send whichever is closest.
	
	==Note: This is not a good approach. Because it traverse all node in the tree===
	
 */

public class ClosestBinarySearchTreeValue2 {

	public class Pair {
		public long min;
		public long max;

		public Pair(Long min, Long max) {
			this.min = min;
			this.max = max;
		}
	}

	public int closestValue(TreeNode root, double target) {
		long min = Long.MIN_VALUE;
		long max = Long.MAX_VALUE;
		Pair p = new Pair(min, max);
		recur(root, target, p);
		System.out.println(p.max);
		System.out.println(p.min);
		return p.max - target <= target - p.min ? (int) p.max : (int) p.min;
	}

	/*
	 * In-Order, Pre-Order or Post-Order all approach will work.
	 */
	public void recur(TreeNode root, Double target, Pair p) {
		if (root != null) {
			recur(root.left, target, p);
			if (root.val > target) {// update max
				p.max = Math.min(root.val, p.max);
			} else {
				p.min = Math.max(root.val, p.min);
			}
			recur(root.right, target, p);
		}

	}
}
