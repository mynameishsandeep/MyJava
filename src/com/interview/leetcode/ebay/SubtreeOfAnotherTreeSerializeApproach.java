package com.interview.leetcode.ebay;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/subtree-of-another-tree/description/
Given two non-empty binary trees s and t, check whether tree t has exactly the
same structure and node values with a subtree of s.

Solution: Save source and target in String. Compare for contains
Need to add seperator for between every node and end of node.... , and ,#

=======# is needed for below case for end of node====
[1,2,3]
[2,3]

,1,2##,3##
,2,3###

,1,2,3
,2,3
========= , is needed for below case for between 2 nodes=======

[12]
[2]

,12##
,2##

12##
2##
==============================

 *
 */
public class SubtreeOfAnotherTreeSerializeApproach {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    return serialize(s)
        .contains(serialize(t)); // Java uses a naive contains algorithm so to ensure linear time,
    // replace with KMP algorithm
  }

  public String serialize(TreeNode root) {
    StringBuilder res = new StringBuilder();
    serialize(root, res);
    System.out.println(res);
    return res.toString();
  }

  private void serialize(TreeNode cur, StringBuilder res) {
    if (cur == null) {
      res.append("#");
      return;
    }
    res.append("," + cur.val);
    serialize(cur.left, res);
    serialize(cur.right, res);
  }
}
