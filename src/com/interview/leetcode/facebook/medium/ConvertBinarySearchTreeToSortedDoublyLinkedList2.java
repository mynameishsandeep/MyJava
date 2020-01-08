package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.list.Node;

/*
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
 *
 * 1) Do In-Order Traversal.
 * 2) Connect previous.right = current.
 * 3) current.left = previous
 * 4) previous = current
 *
 * SubLogic:
 * 1) Connect Last Node right with and First Node.
 * 2) Connect First Node left with Last Node.
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList2 {
  private Node prev = null;

  public Node treeToDoublyList(Node root) {
    if (root == null) return null;
    Node dummy = new Node(0, null, null);
    prev = dummy;
    helper(root);
    // connect head and tail
    prev.right = dummy.right;
    dummy.right.left = prev;
    return dummy.right;
  }

  private void helper(Node cur) {
    if (cur == null) return;
    helper(cur.left);
    prev.right = cur;
    cur.left = prev;
    prev = cur;
    helper(cur.right);
  }
}
