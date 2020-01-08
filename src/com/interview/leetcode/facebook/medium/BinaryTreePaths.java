package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * 					1
 * 				2		3
 *
 * Explain with the simple approach.
 *
 */
public class BinaryTreePaths {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root != null) recur(root, "", result);

    return result;
  }

  public void recur(TreeNode root, String currResult, List<String> result) {
    if (root.left == null && root.right == null) result.add(currResult + root.val);
    else {
      if (root.left != null) recur(root.left, currResult + root.val + "->", result);
      if (root.right != null) recur(root.right, currResult + root.val + "->", result);
    }
  }
}
