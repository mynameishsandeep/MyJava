package com.interview.leetcode.google.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * 
 * 1) The pattern of BST is part of Binary Search. 
 */
public class ConvertSortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0) {
			return null;
		}
		TreeNode head = helper(num, 0, num.length - 1);
		return head;
	}

	public TreeNode helper(int[] num, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			System.out.println(mid);
			TreeNode node = new TreeNode(num[mid]);
			node.left = helper(num, low, mid - 1);
			node.right = helper(num, mid + 1, high);
			return node;
		}
		return null;
	}

	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();
		c.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 6, 7 });
	}
}
