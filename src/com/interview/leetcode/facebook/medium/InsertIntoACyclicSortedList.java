package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.newer.Node;

/*
 * https://leetcode.com/problems/insert-into-a-cyclic-sorted-list/
 *
1) Think of the problem as, in a sorted array, insert a number.
2) Number can come in duplicate.
3) We cannot do binary search because it is linked list.
4) Iterate nodes for the first time. Make the head pointer to come in lowest
number and prev pointer to the highest number.
5) There are only 3 cases can come
	a) number to be inserted is at front.
	b) number to be inserted is at last.
	c) number to be inserted is at anywhere in middle.
6) For the case 5a and 5b we can insert number between prev and head.
7) For the case 5c. Iterate for the second time.
	Start from low, verify ins >= curr && ins <= next. Then insert. Else loop it.

Ex: Data...
123 -> insert 0 -> case5a
123 -> insert 4 -> case5b
1235 -> insert 4 -> case5c
null -> insert 1 -> special case, handle separately
1 -> insert 0 -> case5a
1 -> insert 2 -> case5b
 */
public class InsertIntoACyclicSortedList {

  public Node insert(Node head, int ins) {
    if (head == null) {
      return new Node(ins, null);
    }
    // Since we need to return the same head in result. Caching it.
    Node resultHeadToReturn = head;
    Node prev = takeThePointerToHighestNumber(head, resultHeadToReturn); // Highest Number
    head = prev.next; // Lowest Number... Now prev is the source of truth.
    if (ins < head.val || ins > prev.val) {
      Node n = new Node(ins, head);
      prev.next = n;
      return resultHeadToReturn;
    }
    while (true) {
      int curr = head.val;
      int next = head.next.val;
      if (ins >= curr && ins <= next) {
        Node n = new Node(ins, head.next);
        head.next = n;
        break;
      }
      head = head.next;
    }
    return resultHeadToReturn;
  }
  // To make while loop finite, making address level compare.
  private Node takeThePointerToHighestNumber(Node head, Node loopIdentifier) {
    while (true) {
      if (head.val <= head.next.val) {
        head = head.next;
      } else {
        return head;
      }
      if (head == loopIdentifier) {
        return head;
      }
    }
  }
}
