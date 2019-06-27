package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * <p>1) Traverse the Tree by Level Order. 2) At Each Level End. Save the (last) node and return it.
 */
public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    if (root != null) {
      queue.offer(root);
      while (!queue.isEmpty()) {
        // Do not get queue.size() inside for loop. Because queue size varies. So keep it statically
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          root = queue.poll();
          if (root.left != null) {
            queue.offer(root.left);
          }
          if (root.right != null) {
            queue.offer(root.right);
          }
        }
        result.add(root.val);
      }
    }
    return result;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }
}
