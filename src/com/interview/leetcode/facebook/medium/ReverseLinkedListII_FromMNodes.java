package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.ListNode;

/*
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 * 
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * m=3, n=2
 * a -> b -> c -> d -> e -> null
 * Result = a -> b -> d -> c -> e -> null
 * ===========
 * Break the logic into 3 steps
 * 1) Move pointer previous to m-1 node, current to m node.
 * 2) Do the actual reversal from m to n node. 
 * 3) Connect the step1 pointers. 
 * ============
 * 1) Move previous to b.
 * 2) Move current to c.
 * 3) Reverse c to d.
 * 3a) current1 will be pointing e. previous1 will be at d 
 * 4) Connect previous.next to previous1 i.e b to d
 * 5) Connect current.next to current1 i.e c to e
 *  
 */
public class ReverseLinkedListII_FromMNodes {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		//first part
		ListNode current = dummy;
		ListNode previous = null;
		for (int i = 0; i < m; i++) {
			previous = current;
			current = current.next;
		}

		//reverse
		ListNode current1 = current;
		ListNode previous1 = previous;
		ListNode next1;
		for (int i = m; i <= n; i++) {
			next1 = current1.next;
			current1.next = previous1;
			previous1 = current1;
			current1 = next1;
		}

		//connect 
		previous.next = previous1;
		current.next = current1;

		return dummy.next;
	}

}
