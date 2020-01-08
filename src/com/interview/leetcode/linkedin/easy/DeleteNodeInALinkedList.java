package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.ListNode;

/*
 * https://leetcode.com/problems/delete-node-in-a-linked-list/

1) Generally to delete a node. We will keep previous node and current node and
then we find the node to delete, we will connect previous node with current.node
2) In this problem they got the node to delete and sending that as argument.
Ex: Node to delete can be first or middle except tail.
So copy next value to current(Node to delete). Point current.next to next of next.
 */
public class DeleteNodeInALinkedList {
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
