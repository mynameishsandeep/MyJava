package com.interview.leetcode.google.medium;

import java.util.LinkedList;
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
 *
 * ========
 * Refer Problem "FindLeavesOfBinaryTree_BottomUpRecurse.java"
 * =========
 * 1) This solution approach does in O(n).
 * 2) BinaryTreeZigzagLevelOrderTraversalRecursion problem uses ArrayList which
 * adds element at 0. which moves element exists that is another O(n) operation for each odd row.
 *
 */
public class BinaryTreeZigzagLevelOrderTraversalRecursionBest {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    List<LinkedList<Integer>> tempResult = new LinkedList<>();
    recur(root, tempResult, 0);
    for (LinkedList<Integer> temp : tempResult) result.add(temp);
    return result;
  }

  private void recur(TreeNode root, List<LinkedList<Integer>> result, int level) {
    if (root == null) return;
    if (result.size() == level) result.add(new LinkedList<Integer>());
    if (0 == level % 2) result.get(level).addLast(root.val);
    else result.get(level).addFirst(root.val);
    recur(root.left, result, level + 1);
    recur(root.right, result, level + 1);
  }
}
