package com.interview.leetcode.linkedin.hard;

import java.util.PriorityQueue;
import java.util.Queue;

import com.interview.leetcode.ListNode;

/*
* https://leetcode.com/problems/merge-k-sorted-lists/description/
*
* 1) First time fill priority queue with 0th index of node from all array.
* 2) Poll a node from queue, which is the least value and 1st result.
* 3) If the node has next node, offer the next node. Else poll next node from queue.
* ===========================
* Trick: We don't need to maintain array index to poll "next data" specifically from particular index of array.
* It is done implicitly because of node data structure "node.next"
* If the node is not having the "next" attribute itself, then solution would be more tricky.
* ===========================
* =======Solution Approach for Array of Integers(Not for below problem, because below problem is based on Array of connected node)=========
  1) The data should be offered as pair<data, index(index of array), index(index of element in array)> in priority queue
  2) First time fill priority queue with 0th index of data from all array.
* 3) Poll a data pair from queue, which is the least value and 1st result.
* 4) from the pair load the next data from specific index of array, inside that specific element.
* 3) If the array is not empty, offer the next element. Else poll next element from queue.


* O(nlogk).
*/
public class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    Queue<ListNode> q = new PriorityQueue<>((list1, list2) -> list1.val - list2.val);
    ListNode result = new ListNode(0);
    ListNode dummyResult = result;
    for (ListNode list : lists) {
      if (list != null) q.offer(list);
    }
    while (!q.isEmpty()) {
      ListNode list = q.poll();
      ListNode temp = new ListNode(list.val);
      result.next = temp;
      result = result.next;
      if (list.next != null) q.offer(list.next);
    }
    return dummyResult.next;
  }
}
