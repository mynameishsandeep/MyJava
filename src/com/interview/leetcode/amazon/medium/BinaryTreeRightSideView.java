package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 */
public class BinaryTreeRightSideView {
  List<Integer> res = new ArrayList<>();

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return res;
    rightSideViewHelper(root, 0);
    return res;
  }

  /*
   * 1) Think about a tree with only one node at every level.
   * 2) Solution is simple pre-order traversal from "right side".
   * 3) For Left Side view, do pre-order traversal from "left side".
   */
  public void rightSideViewHelper(TreeNode root, int level) {
    if (level == res.size()) res.add(root.val);
    if (root.right != null) rightSideViewHelper(root.right, level + 1);
    if (root.left != null) rightSideViewHelper(root.left, level + 1);
  }

  /*
   * 1) Traverse the Tree by Level Order.
   * 2) At Each Level End. Save the (last) node and return it.
   */
  public List<Integer> rightSideViewQueueApproach(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    if (root != null) {
      queue.offer(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          root = queue.poll();
          if (root.left != null) queue.offer(root.left);
          if (root.right != null) queue.offer(root.right);
        }
        result.add(root.val);
      }
    }
    return result;
  }
}
