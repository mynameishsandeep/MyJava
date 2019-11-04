package com.sample.datastructure.tree;

import com.interview.leetcode.TreeNode;

/*
*https://leetcode.com/problems/invert-binary-tree/description/
=======================Solution=======================
1) Do swap in Pre-Order or Post-Order traversal
2) Performace point : Leaf node don't need swap. So add condition in swap if (parent.left != null || parent.right != null)
* ============================
* Ex: 3,2,4,1
			     3
			   /   \
			  2     4
			 / \   / \
			1   n n   n

	1st swap:
			     3
			   /   \
			  2     4
			 / \   / \
			n   1 n   n

	2nd swap:
			     3
			   /   \
			  4     2
			 / \   / \
			n   n n   1
*  Recursion go all the way to left which is 1.  1 is not having left & right, so no swap.
*  Then back track to 2. 2(parent of 1) comes. Goes to Swap method. 1 changed from left to right.
*  Then back track to 4. Goes to Swap method. 4 is not having left & right, so no swap.
*  Then back track to 3. 3(parent of 2 and 4) comes. Goes to Swap method. 2 and 4 are swapped.
*
*  So total of 2 swap operation.
*  ================================
*  ==== For a 7 node(balanced)...
*  Swap will be called 3 times, skipping 4 leaf nodes.==========
*/
public class InvertBinaryTreeOrMirrorOfTree {
  /*
  1) Swap is possible if there left or right or both.
  2) Swap is not possible only when both left and right are null.
  */
  public TreeNode invertTree(TreeNode parent) {
    if (parent != null) {
      invertTree(parent.left);
      invertTree(parent.right);
      if (parent.left != null || parent.right != null) swap(parent); // For Performance if condition
    }
    return parent;
  }

  private void swap(TreeNode root) {
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
  }
}
