package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/tree-diameter/
 *
1) build AdjacentList. Map is not needed, because node starts from 0 and ends at n.
2) do dfs from node 0.
2a) if child is visited already skip it.
2b) There can be more than 2 maxDepth for a node.
2c) But diameter is about maxDepth1 and maxDepth2 for a node. Result is maxDepth1+maxDepth1.
2d) Look DiameterOfBinaryTreeOrLongestPath. It is similar logic.
In this problem tree can have more than 2 leaf, that is the only difference.

input = [[0,1],[1,2],[2,3],[1,4],[4,5]]

AdjacentList =[[1], [0, 2, 4], [1, 3], [2], [1, 5], [4]]

parent= 0 child= 1 Skipping Child false
parent= 1 child= 0 Skipping Child true
parent= 1 child= 2 Skipping Child false
parent= 2 child= 1 Skipping Child true
parent= 2 child= 3 Skipping Child false
parent= 3 child= 2 Skipping Child true
parent= 1 child= 4 Skipping Child false
parent= 4 child= 1 Skipping Child true
parent= 4 child= 5 Skipping Child false
parent= 5 child= 4 Skipping Child true


 */
public class TreeDiameter {
  private int diameter = 0;
  private List<List<Integer>> adjacentList = new ArrayList<>();
  private Set<Integer> visited = new HashSet<>();

  public int treeDiameter(int[][] edges) {
    buildAdjMatrix(edges);
    dfs(0, adjacentList);
    return diameter;
  }

  private void buildAdjMatrix(int[][] edges) {
    for (int i = 0; i <= edges.length; ++i) adjacentList.add(new ArrayList<>());
    for (int[] edge : edges) {
      adjacentList.get(edge[0]).add(edge[1]);
      adjacentList.get(edge[1]).add(edge[0]);
    }
  }

  private int dfs(int node, List<List<Integer>> adjacentList) {
    int maxDepth1st = 0, maxDepth2nd = 0;
    visited.add(node);
    for (int child : adjacentList.get(node)) {
      // Only one way from root node to child node, don't allow child node go to root node again!
      if (!visited.contains(child)) {
        int childPath = dfs(child, adjacentList);
        if (childPath > maxDepth1st) {
          maxDepth2nd = maxDepth1st;
          maxDepth1st = childPath;
        } else if (childPath > maxDepth2nd) maxDepth2nd = childPath;
      }
    }
    // Sum of the top 2 highest depths is the longest path through this root
    int longestPathThroughRoot = maxDepth1st + maxDepth2nd;
    diameter = Math.max(diameter, longestPathThroughRoot);
    return maxDepth1st + 1;
  }
}
