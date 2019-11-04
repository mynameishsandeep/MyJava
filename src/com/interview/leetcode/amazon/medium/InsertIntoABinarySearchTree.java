package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree,
 * insert the value into the BST
 * =====Idea=========
 * 1) The insertion will happen at right hand or left hand leaf only.
 * 2) So traverse (left or right by comparing)all the way down.
 * When we find null, that is the point we need to insert data.
 * ===========Solution Approach1 Simple Iteration=========
 * When we find null at leaf "left or right", insert data and return.
 * ===========Solution Approach2 Forward Recursion=========
 * When we find null at leaf "left or right", insert data and return.
 * ===========Solution Approach3 Recursion BackTrack=========
 * 1) BackTrack is tricky and simple programming
 * 2) When we find null return new node with the value. Assign values back to it till root.
 *						10
 *					  n    25
 * 1)If I want to insert 5.
 * 2) 5 is less than 10. So root.left = recur(null).
 * 3) On seeing null base condition satisfied and will return node(5)
 * 4) root.left = node(5).
 * 5) root 10 will be returned.
 */
public class InsertIntoABinarySearchTree {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    TreeNode result = root;
    TreeNode node = new TreeNode(val);
    while (root != null) {
      if (root.val > val) {
        if (root.left == null) {
          root.left = node;
          return result;
        }
        root = root.left;
      } else {
        if (root.right == null) {
          root.right = node;
          return result;
        }
        root = root.right;
      }
    }
    return result;
  }

  public TreeNode insertIntoBSTRecursion(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    if (root.val > val) root.left = insertIntoBST(root.left, val);
    else root.right = insertIntoBST(root.right, val);
    return root;
  }

  public TreeNode insertIntoBSTForwardRecursion(TreeNode root, int val) {
    TreeNode node = new TreeNode(val);
    recur(root, node);
    return root;
  }

  public void recur(TreeNode root, TreeNode node) {
    if (root.val > node.val) {
      if (root.left == null) {
        root.left = node;
        return;
      }
      recur(root.left, node);
    } else {
      if (root.right == null) {
        root.right = node;
        return;
      }
      recur(root.right, node);
    }
  }
}
