package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * 1) With single stack it is not possible to come up with solution.
 * 2) Because Stack is LIFO. So when we add child, then it will be fetched immediately which is wrong.
 * =============Solution Approach==============
 * 1) From LeftToRight insert left first then right.
 * 2) From RightToLeft insert right first then left.
 */
public class BinaryTreeZigzagLevelOrderTraversalUsingStack {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> s1 = new ArrayDeque<>();
    Deque<TreeNode> s2 = new ArrayDeque<>();
    if (root != null) s1.offer(root);
    boolean leftToRight = true;
    while (!s1.isEmpty() || !s2.isEmpty()) {
      List<Integer> levelReslut = new ArrayList<>();
      if (leftToRight) {
        while (!s1.isEmpty()) {
          TreeNode curr = s1.pop();
          levelReslut.add(curr.val);
          if (curr.left != null) s2.push(curr.left);
          if (curr.right != null) s2.push(curr.right);
        }
      } else {
        while (!s2.isEmpty()) {
          TreeNode curr = s2.pop();
          levelReslut.add(curr.val);
          if (curr.right != null) s1.push(curr.right);
          if (curr.left != null) s1.push(curr.left);
        }
      }
      leftToRight = !leftToRight;
      result.add(levelReslut);
    }
    return result;
  }
}
