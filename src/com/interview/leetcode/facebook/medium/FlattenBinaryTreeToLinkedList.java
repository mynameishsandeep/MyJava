package com.interview.leetcode.facebook.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
*
   1) From the root, verify it has right. If it has right. PUSH into stack.
   2) Vefify root has left.
       2a)If it has left, Move left to right and change left to null.
       2b) Change right to root.
       2c) If left is not there. set root.right from POPping from stack. Change right to root.
       2d) If stack is empty. exit
   3) Go to Step1.

*/
public class FlattenBinaryTreeToLinkedList {
  Deque<TreeNode> stack = new ArrayDeque<>();

  public void flatten(TreeNode root) {
    if (root == null) return;
    if (root.right != null) stack.push(root.right);
    if (root.left == null) {
      if (stack.isEmpty()) return;
      root.left = stack.pop();
    }
    root.right = root.left;
    root.left = null;
    flatten(root.right);
  }

  TreeNode pre = null;

  public void flattenRecurse(TreeNode root) {
    if (root == null) return;
    flattenRecurse(root.right);
    flattenRecurse(root.left);
    root.right = pre;
    root.left = null;
    pre = root;
  }
}
