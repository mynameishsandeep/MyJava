package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/closest-binary-search-tree-value/description/
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * 
 * 
 * 1) Find Closest point for each value.
 * 2) if target is less than root. I am sure, there might be "more close" on left. So go left.
      Ex: [5,1,10]... target= 3 
 * 3) Else Go Right. 
	  Ex: [5,1,10]... target= 7 
 * 
 * ===Note: The target "can or cannot" have float number. But the input cannot have float number.======
 * If the input has float number. Then this approach will not work. Because close value can occur in left and right side. 
 * see "ClosestBinarySearchTreeValue2.java" it will work. Because it parses all nodes.
 * 
 * Ex: [4, 3.1, 4.2] target key is 3.9 --> Logic will go left. But 4.2 is the closes of 3.9 
 * ==========
 */
public class ClosestBinarySearchTreeValue {

	public int closestValue(TreeNode root, double target) {
		return closest(root, target, root.val);
	}

	private int closest(TreeNode root, double target, int currentCloseValue) {
		if (root != null) {
			currentCloseValue = updateClosestPoint(root, target, currentCloseValue);
			if (target < root.val) {
				currentCloseValue = closest(root.left, target, currentCloseValue);
			} else {
				currentCloseValue = closest(root.right, target, currentCloseValue);
			}
		}
		return currentCloseValue;
	}

	// Math.abs --> removes negative value... Because closest can occur in upper or lower bound. 
	// target= 4... root.val=2  currentCloseValue= 3.5 --> Here without "Math.abs" logic will fail.
	private int updateClosestPoint(TreeNode root, double target, int currentCloseValue) {
		if (Math.abs(root.val - target) < Math.abs(currentCloseValue - target))
			return root.val;
		return currentCloseValue;
	}
}
