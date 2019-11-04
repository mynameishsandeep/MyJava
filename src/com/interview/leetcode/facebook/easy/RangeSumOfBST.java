package com.interview.leetcode.facebook.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/range-sum-of-bst/

==========Solution - using BST property======
1) If I traverse BST in InOrder, I will get sorted data.
2) Now solution is simple as in a sorted array, find element between L & R
3) check method recurSimple
===========Solution - using BST property - Optimized=======================
0) Along with above solution.
1) I can skip left half if root.val>L
2) I can skip right half if root.val<R
3) check method recurOptimized
=============Thinking========================
Sorting of data is not needed. So I can do any of InOrder/PreOrder/PostOrder Traversal.
=======================
Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
   				  10
			5			15
		  3   7        n   18

Output: 10+15+7=32

 */
public class RangeSumOfBST {

  int sum = 0;

  public int rangeSumBST(TreeNode root, int L, int R) {
    recurOptimized(root, L, R);
    return sum;
  }

  // Visits all nodes.
  public void recurSimple(TreeNode root, int L, int R) {
    if (root.left != null) recurSimple(root.left, L, R);
    if (root.val >= L && root.val <= R) sum += root.val;
    if (root.right != null) recurSimple(root.right, L, R);
  }

  // Below 3 lines can swapped in any order
  public void recurOptimized(TreeNode root, int L, int R) {
    if (root.val >= L && root.val <= R) sum += root.val;
    if (root.left != null && root.val > L) recurOptimized(root.left, L, R);
    if (root.right != null && root.val < R) recurOptimized(root.right, L, R);
  }

  public int rangeSumBSTBFS(TreeNode root, int L, int R) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      root = q.poll();
      if (root.val >= L && root.val <= R) sum += root.val;
      if (root.left != null && root.val > L) q.offer(root.left);
      if (root.right != null && root.val < R) q.offer(root.right);
    }
    return sum;
  }
}
