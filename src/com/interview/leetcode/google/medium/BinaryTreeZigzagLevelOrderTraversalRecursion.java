package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * 1) A tree has 3 points in traversing if I do left and right recursively.
 * 2) Point b4 left. where root is processed.
 * 3) Point after left or Point b4 right. where left is processed.
 * 4) Point after right. where right is processed
 * 5) Here in this problem, I will take the Point b4 left i.e root processing. Or PreOrder Traversal.
 *
 * ========
 * Refer Problem "FindLeavesOfBinaryTree_BottomUpRecurse.java"
 *
 */
public class BinaryTreeZigzagLevelOrderTraversalRecursion {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    recur(res, 0, root);
    return res;
  }

  private void recur(List<List<Integer>> res, int level, TreeNode cur) {
    if (cur == null) return;
    if (res.size() == level) res.add(new ArrayList<Integer>());

    if (level % 2 == 0) res.get(level).add(cur.val);
    else res.get(level).add(0, cur.val);

    recur(res, level + 1, cur.left);
    recur(res, level + 1, cur.right);
  }
}
