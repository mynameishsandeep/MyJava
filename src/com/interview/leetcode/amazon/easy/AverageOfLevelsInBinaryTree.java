package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsInBinaryTree {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      Double average = 0.0d;
      for (int i = 0; i < size; i++) {
        TreeNode temp = q.poll();
        average += temp.val;
        if (null != temp.left) {
          q.offer(temp.left);
        }
        if (null != temp.right) {
          q.offer(temp.right);
        }
      }
      result.add(average / size);
    }
    return result;
  }
}
