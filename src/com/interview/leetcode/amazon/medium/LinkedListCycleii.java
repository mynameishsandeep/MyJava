package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/linked-list-cycle-ii/

1) Detect Loop using single pointer and double pointer approach. Loop point is not same as Cycle point.
2) Move fast to head again. Now move both slow and fast. The meeting point is cycle point.
 */
public class LinkedListCycleii {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        fast = head;
        while (fast != slow) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }
}
