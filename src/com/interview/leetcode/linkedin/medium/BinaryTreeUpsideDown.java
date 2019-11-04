package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-upside-down/description/
 *
 * Solution2:
 * https://leetcode.com/problems/binary-tree-upside-down/discuss/160896/Java-using-stack-AC
 *
 *Requirement:
 * 1) Left goes Root.
 * 2) Right goes Left
 * 3) Root goes Right.
 *
 *=======Implementation=====
 *1) Since left goes to root. Pass root.left recursively.
 *2)  
 * =================INPUT===========
 * 					1
 * 				2	    3
 * ================OUTPUT===========
 * 					2
 * 				3       1
 */
public class BinaryTreeUpsideDown {

  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null) return null; // Corner Case. If root null return null;
    return upsideDownBinaryTreeRecur(root);
  }

  public TreeNode upsideDownBinaryTreeRecur(TreeNode root) {
    if (root.left != null) {
      TreeNode newRoot = upsideDownBinaryTreeRecur(root.left); // 2, newRoot is 2
      root.left.left = root.right; // root is 1.. 1s left is 2... on 2s left, right(3) is assigned.
      root.left.right = root; // root is 1.. 1s left is 2... on 2s right, root(1) is assigned.
      root.left = root.right = null; // root is 1... set null on both left and right
      return newRoot;
    }
    return root;
  }
}
