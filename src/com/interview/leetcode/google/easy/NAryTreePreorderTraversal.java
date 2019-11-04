package com.interview.leetcode.google.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.interview.leetcode.Node;

/*
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal
 *
 * 1) BFS loads child from right to left.
 * 2) DFS loads child from left to right
 */
public class NAryTreePreorderTraversal {
  public List<Integer> preorder(Node root) {
    List<Integer> result = new ArrayList<>();
    Deque<Node> stack = new LinkedList<>();
    if (root != null) stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      result.add(root.val);
      for (int i = root.children.size() - 1; i >= 0; i--) {
        stack.push(root.children.get(i));
      }
    }
    return result;
  }

  public List<Integer> preorderDFS(Node root) {
    List<Integer> result = new ArrayList<>();
    recur(root, result);
    return result;
  }

  private void recur(Node root, List<Integer> result) {
    if (root != null) {
      result.add(root.val);
      for (Node child : root.children) {
        recur(child, result);
      }
    }
  }
}
