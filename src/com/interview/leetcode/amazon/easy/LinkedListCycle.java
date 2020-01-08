package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.ListNode;

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    ListNode sP = head;
    ListNode dP = head;
    while (true) {
      if (dP == null) {
        return false;
      } else {
        dP = dP.next;
        if (dP == null) {
          return false;
        } else {
          dP = dP.next;
        }
      }
      sP = sP.next;
      if (sP == dP) {
        return true;
      }
    }
  }
}
