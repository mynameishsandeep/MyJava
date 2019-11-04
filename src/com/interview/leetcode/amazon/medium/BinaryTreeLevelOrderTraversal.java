package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/binary-tree-level-order-traversal/description/
*
* 1) Traverse the Tree by Level Order.
* 2) Add a for loop inside level order traversal. That runs till the current size of queue.
* 3) The queue size determines 1 level of current level traversal.
* 4) When the for loop ends add the level result to main result, that would be result of 1 level
*
* 					1
* 				2		 3
* 			  4	  5    6   7
* 1) Initial size of inner for loop is 1(Based on current queue size). Then left and right is added to queue.
* 2) Now size of inner for loop is 2(because currently queue has 2 and 3.)
* 3) On iteration 3. size of inner for loop is 4(because currently queue has 4,5,6,7)

*/
public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null) q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> levelResult = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();
        levelResult.add(curr.val);
        if (curr.left != null) q.offer(curr.left);
        if (curr.right != null) q.offer(curr.right);
      }
      result.add(levelResult);
    }
    return result;
  }
}
