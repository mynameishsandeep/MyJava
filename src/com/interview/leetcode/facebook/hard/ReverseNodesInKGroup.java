package com.interview.leetcode.facebook.hard;

import com.interview.leetcode.ListNode;

/*
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * 
 * 1) The problem is similar to "ReverseLinkedList.java" with a twist
 * 2) if k =3 with 10 elements, call reverse 3 times.
 * Ex: 1 2 3 4 5 6 7 8 9 10
 * 
 *  set1 : reverse [dummy 1 2 3 4]
 *  		result = 3 2 1 4 5 6 7 8 9 10
 *  set2 : reverse [ 1 4 5 6 7]
 *  		result = 3 2 1 6 5 4 7 8 9 10
 *  set3 : reverse [ 4 7 8 9 10 ]
 *  		result = 3 2 1 6 5 4 9 8 7 10
 *  3) When reverse is done for each set. Keep the "second node", "last node" and connect it
 *  Ex: for set1... Note: 1 and 4. Connect them at last in reverse code

 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode begin;
		if (head == null || head.next == null || k == 1)
			return head;
		ListNode dummyhead = new ListNode(-1);
		dummyhead.next = head;
		begin = dummyhead;
		int i = 0;
		while (head != null) {
			i++;
			if (i % k == 0) {
				begin = reverse(begin, head.next);
				head = begin.next;
			} else {
				head = head.next;
			}
		}
		return dummyhead.next;
	}

	public ListNode reverse(ListNode begin, ListNode end) {

		ListNode previous = begin;
		ListNode current = begin.next;
		ListNode currentTemp = current;
		ListNode next = null;
		while (current != end) {
			next = current.next;     // next = b,            next = c,         next= null
			current.next = previous; // current.next = null, current.next = a, current.next = b
			previous = current;      // previous = a,        previous = b,     previous = c
			current = next;          // current = b,         current = c,      current = null
		}
		begin.next = previous;
		currentTemp.next = current;

		return currentTemp;
	}
}
