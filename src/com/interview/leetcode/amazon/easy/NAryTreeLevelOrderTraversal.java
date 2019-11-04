package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.interview.leetcode.Node;

public class NAryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    levelOrderDFS(root, 0, result);
    return result;
  }

  // This method runs faster, as it doesn't need additional Data Structure
  private void levelOrderDFS(Node node, int level, List<List<Integer>> result) {
    if (node == null) return;
    if (result.size() == level) result.add(new ArrayList<>());
    result.get(level).add(node.val);
    for (Node children : node.children) levelOrderDFS(children, level + 1, result);
  }

  public List<List<Integer>> levelOrderBFS(Node root) {
    Queue<Node> q = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root != null) q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> currResult = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        Node curr = q.poll();
        currResult.add(i, curr.val);
        for (Node child : curr.children) {
          q.offer(child);
        }
      }
      result.add(currResult);
    }
    return result;
  }
}
