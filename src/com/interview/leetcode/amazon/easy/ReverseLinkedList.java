package com.interview.leetcode.amazon.easy;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 */
public class ReverseLinkedList {

	public class ListNode {
		int val;
		ListNode next;
	}

	public ListNode reverseList(ListNode head) {

		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}
