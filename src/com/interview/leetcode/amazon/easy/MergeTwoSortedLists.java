package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode result = null;
        if(l1.val<l2.val) {
            result = l1;
            result.next = mergeTwoLists(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeTwoLists(l1, l2.next);
        }
        return result;
   }

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode finalResult = null;
		while (true) {
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					ListNode current = new ListNode(l1.val);
					if (result == null) {
						result = current;
						finalResult = result;
					} else {
						result.next = current;
						result = current;
					}
					l1 = l1.next;
				} else {
					ListNode current = new ListNode(l2.val);
					if (result == null) {
						result = current;
						finalResult = result;
					} else {
						result.next = current;
						result = current;
					}
					l2 = l2.next;
				}
			} else if (l1 == null && l2 == null) {
				break;
			} else if (l1 == null) {
				if (result == null) {
					finalResult = l2;
				} else {
					result.next = l2;
				}
				break;
			} else if (l2 == null) {
				if (result == null) {
					finalResult = l1;
				} else {
					result.next = l1;
				}
				break;
			}
		}
		return finalResult;
	}
}
