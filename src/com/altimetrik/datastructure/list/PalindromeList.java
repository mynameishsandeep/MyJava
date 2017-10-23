package com.altimetrik.datastructure.list;

import java.util.Stack;

public class PalindromeList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		System.out.println(new PalindromeList().isPalindrome(l1));
	}
	/*
	 * METHOD 1 (Use a Stack)
		A simple solution is to use a stack of list nodes. This mainly involves three steps.
		1) Traverse the given list from head to tail and push every visited node to stack.
		2) Traverse the list again. For every visited node, pop a node from stack and compare data of popped node with currently visited node.
		3) If all nodes matched, then return true, else false.
	 */
	public boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null) {
            return true;
        }
		Stack<Integer> stack = new Stack<>();
		ListNode pointer2 = head;

		while (head.next != null) {

			if (pointer2.next == null) {
				break;
			}
			pointer2 = pointer2.next;
			if (pointer2.next == null) {
				stack.push(head.val);
				break;
			}
			pointer2 = pointer2.next;
			stack.push(head.val);
			head = head.next;
		}
		head = head.next;

		while (head != null) {
			int prev = stack.pop();
			if (head.val != prev) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}