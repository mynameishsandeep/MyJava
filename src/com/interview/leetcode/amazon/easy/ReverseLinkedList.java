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

	/*
	 * Key point here is reversal start from null, not from first element 
	 * 
	 * a -> b -> c -> null
	 * null <- a -> b -> c // first iteration
	 * null <- a <- b -> c // second iteration
	 * null <- a <- b <- c // third iteration
	 * 
	 */
	public ListNode reverseList(ListNode head) {
		ListNode previous = null;
		ListNode current = head;
		ListNode next = null;
		while (current != null) {
			next = current.next;     // next = b,            next = c,         next= null
			current.next = previous; // current.next = null, current.next = a, current.next = b
			previous = current;      // previous = a,        previous = b,     previous = c
			current = next;          // current = b,         current = c,      current = null
		}
		return previous;
	}
	
}
