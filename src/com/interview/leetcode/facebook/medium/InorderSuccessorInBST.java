package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.TreeNode;

/*
 * Ex: If input is [1,2,3,4,5,6].
 * data = 5
 * successor of 5 is 6.
 * data = 6
 * success of 6 is null
 *
 * ======naive solution=======
 * A naive solution of this problem would be doing an in-order traversal of the BST.
 * Once d is found, it returns the previous node in the traversal. The runtime of this approach is linear.
 * Runtime Complexity : O(n)
 * ======logical solution====
 * 1) We can use the property of BST.
 * 2a) root value < search value. Go right
 * 2b) root value > search value. Save successor. Go left.
 * 2c) root value == search value. if right is not null. Go one step right and all the way left.
 * Update successor in each step. 2c can be ignored and 2a can act as 2c.
 *
 */
public class InorderSuccessorInBST {

  /*
   * Runtime Complexity : Logarithmic, O(log n).
   * Memory Complexity : Constant, O(1).
   */
  public TreeNode inorderSuccessor(TreeNode root, TreeNode dd) {
    TreeNode successor = null;
    while (root != null) {
      if (root.val < dd.val) {
        root = root.right;
      } else if (root.val > dd.val) {
        successor = root;
        root = root.left;
      } else { // match found
        if (root.right != null) {
          successor = root.right;
          while (successor.left != null) {
            successor = successor.left;
          }
        }
        return successor;
      }
    }
    return successor;
  }

  public TreeNode inorderSuccessorSimple(TreeNode root, TreeNode dd) {
    TreeNode successor = null;
    while (root != null) {
      if (root.val <= dd.val) {
        root = root.right;
      } else if (root.val > dd.val) {
        successor = root;
        root = root.left;
      }
    }
    return successor;
  }
}
