package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

					      3
					   /     \
					  5       1
					 / \     / \
					6   2   0   8
				       / \
				      7   4
		target=6, K=2 Answer: 3,2
		target=7, K=2 Answer: 4,5
		target=7, K=3 Answer: 6,3

//1. build a undirected graph using treenodes as vertices, and the parent-child relation as edges
//2. do BFS with source vertice (target) to find all vertices with distance K to it.


[3,5,1,6,2,0,8,null,null,7,4]

dataMap = {0=[1], 1=[3, 0, 8], 2=[5, 7, 4], 3=[5, 1], 4=[2], 5=[3, 6, 2], 6=[5], 7=[2], 8=[1]}
dataMap is to understand the graph structure(parent-child relationship).

 */
public class AllNodesDistanceKInBinaryTree {
  Map<TreeNode, List<TreeNode>> map = new HashMap<>();
  Map<Integer, List<Integer>> dataMap = new HashMap<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    List<Integer> res = new ArrayList<>();
    if (root == null || K < 0) return res;
    buildMap(root, null);
    System.out.println(dataMap);
    if (!map.containsKey(target)) return res;
    Set<TreeNode> visited = new HashSet<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(target);
    visited.add(target);
    while (!q.isEmpty()) {
      int size = q.size();
      if (K == 0) {
        for (int i = 0; i < size; i++) res.add(q.poll().val);
        return res;
      }
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        for (TreeNode next : map.get(node)) {
          if (visited.contains(next)) continue;
          visited.add(next);
          q.add(next);
        }
      }
      K--;
    }
    return res;
  }

  private void buildMap(TreeNode node, TreeNode parent) {
    if (node == null) return;
    if (!map.containsKey(node)) {
      map.put(node, new ArrayList<TreeNode>());
      dataMap.put(node.val, new ArrayList<Integer>());
      if (parent != null) {
        map.get(node).add(parent);
        map.get(parent).add(node);
        dataMap.get(node.val).add(parent.val);
        dataMap.get(parent.val).add(node.val);
      }
      buildMap(node.left, node);
      buildMap(node.right, node);
    }
  }
}
