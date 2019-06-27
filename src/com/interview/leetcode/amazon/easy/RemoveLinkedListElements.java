package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.ListNode;

/*
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 * 
 * To delete a node and join a previous and next.
 * I need 3 nodes. 1) previous 2) current 3) next
 * Use dummyHead to avoid "if check" inside while condition. 
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode previous = dummyHead;
		ListNode current = dummyHead.next;
		while (current != null) {
			if (current.val == val) {
				previous.next = current.next;
			} else {
				previous = current;
			}
			current = current.next;
		}
		return dummyHead.next;
	}
	
	public ListNode removeElementsWithoutDummyHead(ListNode head, int val) {
		ListNode previous = null;
		ListNode current = head;
		while (current != null) {
			if (current.val == val) {
				if(previous == null) {
					head = head.next;
				} else {
					previous.next = current.next;
				}
			} else {
				previous = current;
			}
			current = current.next;
		}
		return head;
	}

}
