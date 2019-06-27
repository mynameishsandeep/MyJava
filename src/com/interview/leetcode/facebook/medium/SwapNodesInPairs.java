package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.ListNode;

/*
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * 
1) For 1 node. No swap.
2) For even node, swap.

Need 4 node at anypoint to swap.
current - next - nextNext - last
dummy -> 1 - 2 - 3(or null)

*/

class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;
		while (current.next != null && current.next.next != null) {
			ListNode nextNode = current.next;
			ListNode nextNextNode = nextNode.next;

			current.next = nextNextNode;
			nextNode.next = nextNextNode.next;
			current.next.next = nextNode;

			current = current.next.next;
		}
		return dummy.next;
	}
}
