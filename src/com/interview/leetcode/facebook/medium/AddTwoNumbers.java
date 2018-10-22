package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Discard this node at end. This is to avoid "prev null check" inside while loop.
		// So Logic always starts from second node and "ignore" first node at result.
		// This is better way of coding rather than keeping too many if else.
		ListNode prev = new ListNode(0);
		ListNode result = prev;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int l1Value = l1 != null ? l1.val : 0;
			int l2Value = l2 != null ? l2.val : 0;
			int sum = l1Value + l2Value + carry;
			ListNode tempResult = new ListNode(sum % 10);
			prev.next = tempResult;
			prev = tempResult;
			carry = sum / 10;
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}
		if (carry > 0) {
			prev.next = new ListNode(1);
		}
		return result.next;
	}

	public ListNode addTwoNumbers_oldWayOfDoing(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode prev = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int l1Value = l1 != null ? l1.val : 0;
			int l2Value = l2 != null ? l2.val : 0;
			int sum = l1Value + l2Value + carry;
			ListNode tempResult = new ListNode(sum % 10);
			if (prev != null) {
				prev.next = tempResult;
				prev = tempResult;
			} else { // Runs only during the first time
				result = tempResult;
				prev = tempResult;
			}
			carry = sum / 10;
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}
		if (carry > 0) {
			prev.next = new ListNode(1);
		}

		return result;
	}
}
