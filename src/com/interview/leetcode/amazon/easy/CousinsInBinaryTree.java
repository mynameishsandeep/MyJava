package com.interview.leetcode.amazon.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/cousins-in-binary-tree/

			     6
			   /   \
			  3     5
			 / \   / \
			7   8 1   3
Say two node be 7 and 1, result is TRUE.
Say two nodes are 3 and 5, result is FALSE.
Say two nodes are 7 and 5, result is FALSE.

===============Solution Approach==========
1) Traverse in level order.
2) Save each node data and its parent in a map.
3) At each level of parsing, verify if both keys are present.
	If YES check both parent are different.
==================================	
 */
public class CousinsInBinaryTree {

  public boolean isCousins(TreeNode r, int x, int y) {
    LinkedList<TreeNode> Q = new LinkedList<>();
    Q.add(r);
    while (!Q.isEmpty()) {
      int s = Q.size();
      Map<Integer, TreeNode> M = new HashMap<>();
      for (int i = 0; i < s; ++i) {
        TreeNode n = Q.remove();
        if (n.left != null) {
          M.put(n.left.val, n);
          Q.add(n.left);
        }
        if (n.right != null) {
          M.put(n.right.val, n);
          Q.add(n.right);
        }
      }
      if (M.containsKey(x) && M.containsKey(y)) {
        return M.get(x) != M.get(y);
      }
    }
    return false;
  }
}
