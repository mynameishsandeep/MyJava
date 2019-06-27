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

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;

    while (true) {
      if (curr.left != null) {
        if (curr.right != null) {
          stack.push(curr.right);
        }
        curr.right = curr.left;
        curr.left = null;
      }

      if (curr.right != null) {
        curr = curr.right;
      } else {
        if (!stack.isEmpty()) {
          curr.right = stack.pop();
        } else {
          break;
        }
      }
    }
  }

  TreeNode pre = null;

  public void flattenRecurse(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.right);
    flatten(root.left);
    root.right = pre;
    root.left = null;
    pre = root;
  }
}
