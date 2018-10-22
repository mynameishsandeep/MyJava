package com.interview.leetcode.facebook.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import com.interview.leetcode.ListNode;

/*
 * https://leetcode.com/problems/reorder-list/submissions/
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

 * The only trick is to set null at end of list, based on odd and even number of counts.
 * 
 * 1) Parse the node and put it in stack. So that last last node can be taken
 * 2) Parse each node, take a node from stack and insert in middle.
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		Deque<ListNode> stack = new ArrayDeque<>();
		ListNode tempHead = head;
		int size = 0;
		while (tempHead != null) {
			stack.push(tempHead);
			tempHead = tempHead.next;
			size++;
		}
		if (size < 2) {
			return;
		}
		for (int i = 0; i < (size - 1) / 2; i++) {
			ListNode stackTop = stack.pop();
			ListNode temp = head.next;
			head.next = stackTop;
			stackTop.next = temp;
			head = head.next.next;
		}
		if (size % 2 == 0) {
			head = head.next;
		}
		head.next = null;
	}
}
