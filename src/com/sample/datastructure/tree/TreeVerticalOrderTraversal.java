package com.sample.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
 
 		left  = X-1 Y-1
 		right = X+1 Y-1 
 		Input: 1,2,3,4,5,6,7
 						1
 			  		2		3
 				  4	  5	  6   7
====================Positions ============================================ 						
 						0,0
 				-1,-1		   1,-1
 			-2,-2   0,-2    0,-2   2,-2
=====================Index================================================
 						 0
 					-1       1
 				 -2    0  0     2
================================================================== 				 		
 		So 5 and 6 are falling in same group.
 		So the node value of 5 comes first before 6.
 		Output: [[4],[2],[1,5,6],[3],[7]]	
 		
{-2={-3=[4]}, -1={-2=[2]}, 0={-1=[1], -3=[5, 6]}, 1={-2=[3]}, 2={-3=[7]}} 			 	
 				
 */
public class TreeVerticalOrderTraversal {
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
    dfs(root, 0, -1, map);
    List<List<Integer>> list = new ArrayList<>();
    for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
      list.add(new ArrayList<>());
      for (PriorityQueue<Integer> nodes : ys.values()) {
        while (!nodes.isEmpty()) {
          list.get(list.size() - 1).add(nodes.poll());
        }
      }
    }
    return list;
  }

  private void dfs(
      TreeNode root,
      int level,
      int data,
      TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
    if (root == null) return;

    if (!map.containsKey(level)) map.put(level, new TreeMap<>());

    if (!map.get(level).containsKey(data)) {
      map.get(level).put(data, new PriorityQueue<>());
    }
    map.get(level).get(data).offer(root.val);
    dfs(root.left, level - 1, data + 1, map);
    dfs(root.right, level + 1, data + 1, map);
  }
}
