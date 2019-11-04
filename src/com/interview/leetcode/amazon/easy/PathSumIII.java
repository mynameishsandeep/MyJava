package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/path-sum-iii/
 *
 * This problem is similar to "SubarraySumEqualsK". But in Tree.
 * 1) For each node add value through left and through right.
 * 2) Note it is a simple "forward recursion" to check currentSum reaches sum.
 * 3) No back-tracking logic is needed i.e from leaf reduce/increase.
			        1
			     /    \
			    2      3
			   / \    / \
			  4   5  6   7
	 sum from 1+2+4
	 sum from 1+2+5
 	 sum from 1+3+6
	 sum from 1+3+7

	 sum from 2+4
	 sum from 2+5

	 sum from 3+6
	 sum from 3+7

 *
====================BruteForce======O(n^2)======================================================================
1) Simple sliding window. Begin with "left" from 0 and "right" 1.
2) Move right till n. Find all sums.
3) Reason why we go all the way end is at any point if a negative number found it can get a result.
4) Increase left by 1 and right=left+1. Do step2.
=================================
 */
public class PathSumIII {

  int resultCount = 0;

  public int pathSum(TreeNode root, int sum) {
    if (root != null) recur(root, sum);
    return resultCount;
  }

  /*
   * It is a simple forward recursion.
   * Traversal can be any of inOrder/postOrder/preOrder
   */
  public void recur(TreeNode root, int sum) {
    recurFindCountForANode(root, sum);
    if (root.left != null) recur(root.left, sum);
    if (root.right != null) recur(root.right, sum);
  }

  /*
   * It is a simple forward recursion.
   * Traversal can be any of inOrder/postOrder/preOrder
   */
  public void recurFindCountForANode(TreeNode root, int sum) {
    if (sum - root.val == 0) resultCount += 1;
    if (root.left != null) recurFindCountForANode(root.left, sum - root.val);
    if (root.right != null) recurFindCountForANode(root.right, sum - root.val);
  }
}
