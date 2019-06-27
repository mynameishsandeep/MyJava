package com.interview.leetcode.google.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MazeII_Queue {
  int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    int m = maze.length, n = maze[0].length, res = Integer.MAX_VALUE;
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited = new boolean[m][n];
    int[][] minDistance = new int[m][n];
    visited[start[0]][start[1]] = true;
    q.offer(start);
    while (!q.isEmpty()) {
      int len = q.size();
      while (len-- > 0) {
        int[] curr = q.poll();
        if (curr[0] == destination[0] && curr[1] == destination[1])
          res = Math.min(res, minDistance[curr[0]][curr[1]]);
        for (int[] dir : dirs) {
          int x = curr[0];
          int y = curr[1];
          int dis = -1;
          while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0) {
            x += dir[0];
            y += dir[1];
            dis++;
          }
          if (!visited[x - dir[0]][y - dir[1]]
              || minDistance[x - dir[0]][y - dir[1]] > minDistance[curr[0]][curr[1]] + dis) {
        	  
            visited[x - dir[0]][y - dir[1]] = true;
            minDistance[x - dir[0]][y - dir[1]] = minDistance[curr[0]][curr[1]] + dis;
            q.offer(new int[] {x - dir[0], y - dir[1]});
          }
        }
      }
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}
