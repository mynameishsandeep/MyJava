package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/tree-diameter/
 *
 */
public class TreeDiameter_Faster {
  private int diameter = 0;
  private List<List<Integer>> adjacentList = new ArrayList<>();

  public int treeDiameter(int[][] edges) {
    buildAdjMatrix(edges);
    dfs(0, -1, adjacentList);
    return diameter;
  }

  private void buildAdjMatrix(int[][] edges) {
    for (int i = 0; i <= edges.length; ++i) adjacentList.add(new ArrayList<>());
    for (int[] edge : edges) {
      adjacentList.get(edge[0]).add(edge[1]);
      adjacentList.get(edge[1]).add(edge[0]);
    }
  }

  private int dfs(int vertex, int parent, List<List<Integer>> adjacentList) {
    int maxDepth1st = 0, maxDepth2nd = 0;
    for (int child : adjacentList.get(vertex)) {
      // Only one way from root node to child node, don't allow child node go to root node again!
      if (child != parent) {
        int childPath = dfs(child, vertex, adjacentList);
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
