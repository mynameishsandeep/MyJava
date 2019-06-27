package com.interview.leetcode.facebook.hard;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 *
 *
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.

=============================SolutionNote:==========================
1) Iterate through each cell
2) Stop at each building(1) to measure its distance to each empty land reachable from that building
3) Maintain a 2D matrix to store cumulative distance from 1 to 0.
4) Some 0s may surrounded by 2, which cannot access 1. So note down "accessTobuildingCount" for each 0.
5) Maintain the total number of buildings seen so far

// Finally, the time complexity appears to be:
// Iteration through the full grid:  O(rows*cols)
// For each building, we touch all accessible empty lands. Worst case where there are
// no obstacles, this could be the full grid, so O(rows*cols) again
// As the searching happens inside the first iteration, it is O(rows*cols  * rows*cols)
// so O(rows^2 * cols^2)

 */
public class ShortestDistanceFromAllBuildings {

  class Point {
    int r;
    int c;

    public Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  public int shortestDistance(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return -1;

    final int maxRows = grid.length;
    final int maxCols = grid[0].length;
    int buildingCount = 0; //
    int[][] distanceFromOto1 = new int[maxRows][maxCols];
    // Each item in access matrix gives how many buildings are accessible from this point
    // Again, we care only about the cells that have empty land.
    int[][] accessToBuildingCount = new int[maxRows][maxCols];

    for (int r = 0; r < maxRows; r++) {
      for (int c = 0; c < maxCols; c++) {
        if (grid[r][c] != 1) continue;
        int distanceCount = 0;
        buildingCount++;
        Queue<Point> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[maxRows][maxCols];
        q.offer(new Point(r, c)); // Store tuple of row,col
        while (!q.isEmpty()) {
          final int qsize = q.size();
          for (int i = 0; i < qsize; i++) {
            final Point p = q.poll();
            if (isVisited[p.r][p.c]) continue;
            if (grid[p.r][p.c] == 0) {
              distanceFromOto1[p.r][p.c] += distanceCount;
              accessToBuildingCount[p.r][p.c]++;
              isVisited[p.r][p.c] = true;
            }
            // Check neighborhood of this node for any empty lands
            // Same row, right side col
            if (p.c + 1 < maxCols && grid[p.r][p.c + 1] == 0 && !isVisited[p.r][p.c + 1]) {
              q.offer(new Point(p.r, p.c + 1));
            }
            // Same row, left side col
            if (p.c - 1 >= 0 && grid[p.r][p.c - 1] == 0 && !isVisited[p.r][p.c - 1]) {
              q.offer(new Point(p.r, p.c - 1));
            }
            // One row below, same col
            if (p.r + 1 < maxRows && grid[p.r + 1][p.c] == 0 && !isVisited[p.r + 1][p.c]) {
              q.offer(new Point(p.r + 1, p.c));
            }
            // One row up, same col
            if (p.r - 1 >= 0 && grid[p.r - 1][p.c] == 0 && !isVisited[p.r - 1][p.c]) {
              q.offer(new Point(p.r - 1, p.c));
            }
          }
          distanceCount++;
        }
      }
    }

    // Now that the distance and accessibility are updated, go through the grid
    // and find the shortest distance on an empty plot that also reaches all buildings
    int min = Integer.MAX_VALUE;
    for (int r = 0; r < maxRows; r++) {
      for (int c = 0; c < maxCols; c++) {
        if (grid[r][c] != 0 || accessToBuildingCount[r][c] != buildingCount) continue;
        min = Math.min(min, distanceFromOto1[r][c]);
      }
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }
}
