package com.interview.leetcode.facebook.hard;

import java.util.stream.Stream;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/

				1
			2		6
		  4   5

For above answer is 14 and the path is 5 2 1 6
Initial MaxValue : 4
Then MaxValue    : 5
Then MaxValue    : 11
Then MaxValue    : 11
Final MaxValue   : 14

==========Note=========
1) When getting the max, it should be max of
 	a) left + root
 	b) right + root
 	c) root alone
 	d) left + root + right
2) When returning path, it should be max of
	a) left + root
	b) right + root or
	c) root alone.
The reason is path can grow long from either one side only.

 */
public class BinaryTreeMaximumPathSum {

  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    this.postorder(root);
    return max;
  }

  private int postorder(TreeNode root) {
    if (root == null) return 0;
    int left = postorder(root.left);
    int right = postorder(root.right);
    int currentMax =
        Stream.of(left + root.val, right + root.val, root.val, left + right + root.val)
            .max(Integer::compareTo)
            .get();
    max = Math.max(currentMax, max);
    return Stream.of(left + root.val, right + root.val, root.val).max(Integer::compareTo).get();
  }
}
