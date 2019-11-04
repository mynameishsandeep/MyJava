package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * 1) Traverse by level order.
 * 2) Pass a flag to reverse the list before adding to result.
 */
public class BinaryTreeZigzagLevelOrderTraversalUsingQueue {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    boolean forward = true;
    while (!q.isEmpty()) {
      List<Integer> currResult = new ArrayList<>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        currResult.add(node.val);
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
      }
      if (forward) {
        result.add(currResult);
      } else {
        Collections.reverse(currResult);
        result.add(currResult);
      }
      forward = !forward;
    }
    return result;
  }
}
