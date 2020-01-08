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
1) Go For Left only if root.val>L
2) Go For Right only if root.val<R
3) check method recurOptimized
=============Thinking========================
1) Sorting of data is not needed. So I can do any of InOrder/PreOrder/PostOrder Traversal.
2) Think about only one data at a time i.e root.
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
  // Below 3 lines can swapped in any order
  public void recurSimple(TreeNode root, int L, int R) {
    if (root == null) return;
    if (root.val >= L && root.val <= R) sum += root.val;
    recurSimple(root.left, L, R);
    recurSimple(root.right, L, R);
  }

  // Below 3 lines can swapped in any order
  public void recurOptimized(TreeNode root, int L, int R) {
    if (root == null) return;
    if (root.val >= L && root.val <= R) sum += root.val;
    if (root.val > L) recurOptimized(root.left, L, R);
    if (root.val < R) recurOptimized(root.right, L, R);
  }

  public int rangeSumBSTBFS(TreeNode root, int L, int R) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      root = q.poll();
      if (root == null) continue;
      if (root.val >= L && root.val <= R) sum += root.val;
      if (root.val > L) q.offer(root.left);
      if (root.val < R) q.offer(root.right);
    }
    return sum;
  }
}
