package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.ListNode;

/*
 *https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 *
=====Solution Logic====
1) Take 2 pointers p1 and p2.
2) Move p1 to n times.
3) Move both p1 and p2 till p1 reaches null.
4) Connect p2.next with p2.next.next
	Edge Case: Delete 1st node itself. 
==============
There are 2 cases  
1) Most cases, we need to do the connect on 1st and 3rd node by skipping 2nd node. 
	Ex: Node:[1,2,3] remove 2rd from last
		Node:[1,2,3] remove 1st from last
2) Edge Case : Remove the 1st node itself. In that case. p1 will be null. Just send head.next
    Ex: Node:[1] remove 1st from last
     	Node:[1,2] remove 2nd from last
     	Node:[1,2,3] remove 3rd from last
	
=======================Case1:==================
1 to 10 data
remove 4th from last.
====Move p1 to 4==== 
p1 to 4
====Move p1 and p2, till p1==null=====
p2 1, p1 5
p2 2, p1 6
p2 3, p1 7
p2 4, p1 8
p2 5, p1 9
p2 6, p1 10
p1.next== null stop and return p2.
===================================================
*/

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd_WithoutDummyNode(ListNode head, int n) {
		ListNode p1 = head;
		ListNode p2 = head;
		//Move p1 to n
		for (int i = 1; i <= n; i++) {
			p1 = p1.next;
		}
		// Case1 return result instantly.....
		if (p1 == null) {
			return head.next;
		}

		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p2.next = p2.next.next;
		return head;
	}
}
