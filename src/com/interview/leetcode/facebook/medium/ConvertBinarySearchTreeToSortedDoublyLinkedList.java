package com.interview.leetcode.facebook.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import com.interview.leetcode.list.Node;

/*
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
 *
 * 1) Form DoubleLinkedList with Tree itself
 * 2) Tree Right points to next node
 * 3) Tree Left points to previous node.
 *
 * Main Logic :
 * 1) From Root Node push all left node to stack
 * 2) Pop a node(current).
 * 			If there is right. Then push all of its left node to stack. Take a node(next)
 * 			If there is no right. Then pop a node(next).
 * 3) Connect current and next
 *
 * SubLogic:
 * 1) Connect Last Node right with and First Node.
 * 2) Connect First Node left with Last Node.
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

  public Node treeToDoublyList(Node root) {

    if (root == null) return null;
    Deque<Node> st = new ArrayDeque<>();
    while (root != null) {
      st.push(root);
      root = root.left;
    }
    Node head = st.peek(); // The leftmost node is the new head
    Node cur = null;
    while (!st.isEmpty()) {
      Node top = st.peek();
      cur = st.pop();
      if (cur.right != null) {
        cur = cur.right;
        while (cur != null) {
          st.push(cur);
          cur = cur.left;
        }
      }
      if (!st.isEmpty()) {
        top.right = st.peek();
        st.peek().left = top;
      }
    }
    cur.right = head;
    head.left = cur;
    return head;
  }
}
