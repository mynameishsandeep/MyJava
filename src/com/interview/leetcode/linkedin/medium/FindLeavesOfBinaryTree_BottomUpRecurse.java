package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/find-leaves-of-binary-tree/description/
 *
 * Tree diagram is under US Problems/ "FindLeavesOfBinaryTree.jpg"
 * https://www.programcreek.com/2014/07/leetcode-find-leaves-of-binary-tree-java/
 *
 * =======Logic is same as getting "Height of Tree" with saving the node data=========
 *
 *  There are 2 points to note here.
 * 1) Finding the index of leaf node from bottom to top, which is achieved by backtracking (Height Of Tree Logic)
 * 2) Create ArrayList "only one time" for each level from bottom and Saving the node data to specific level index.
 *
 *   == Note: Don't think of List<Integer> tempResult ========
 *
 *
 */
public class FindLeavesOfBinaryTree_BottomUpRecurse {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    treeHeight(root, result);
    return result;
  }

  // traverse the tree bottom-up recursively
  public int treeHeight(TreeNode root, List<List<Integer>> result) {
    if (root == null) return -1;
    int height = 1 + Math.max(treeHeight(root.left, result), treeHeight(root.right, result));
    if (result.size() == height) result.add(new ArrayList<>());
    result.get(height).add(root.val);
    return height;
  }
}
