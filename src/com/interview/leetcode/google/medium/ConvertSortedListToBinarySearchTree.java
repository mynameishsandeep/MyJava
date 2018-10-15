package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.ListNode;
import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 * 
 */
public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		return recur(list, 0, list.size() - 1);
	}

	private TreeNode recur(List<Integer> list, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			TreeNode node = new TreeNode(list.get(mid));
			node.left = recur(list, low, mid - 1);
			node.right = recur(list, mid + 1, high);
			return node;
		}
		return null;
	}
}
