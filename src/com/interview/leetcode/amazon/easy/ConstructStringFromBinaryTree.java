package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class ConstructStringFromBinaryTree {
  public String tree2str(TreeNode t) {
    if (t == null) return s.toString();
    recur(t);
    return s.toString();
  }

  StringBuilder s = new StringBuilder();

  public void recur(TreeNode t) {

    s.append(t.val);
    if (t.left != null) {
      s.append("(");
      recur(t.left);
      s.append(")");
    }
    if (t.right != null) {
      if (t.left == null) s.append("()");
      s.append("(");
      recur(t.right);
      s.append(")");
    }
  }
}
