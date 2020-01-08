package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.ListNode;

/*
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
=================Solution Note=======================================
1) Solution is based on bottom-up and not forward recursion.

 */
public class MergeTwoSortedLists {

  // This code will not change the source l1 and l2
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode result = null;
    if (l1.val < l2.val) {
      result = l1;
      result.next = mergeTwoLists(l1.next, l2);
    } else {
      result = l2;
      result.next = mergeTwoLists(l1, l2.next);
    }
    return result;
  }
  /*
     * This will change both the node l1 and l2
  Input: 1->2->4, 1->3->4
  Output: 1->1->2->3->4->4


     */
  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists1(l1.next, l2);
      return l1;
    }
    l2.next = mergeTwoLists1(l1, l2.next);
    return l2;
  }
}
