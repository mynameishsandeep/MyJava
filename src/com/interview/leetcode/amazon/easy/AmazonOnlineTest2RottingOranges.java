package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/rotting-oranges/

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
====================================Solution Approach================
1) It is not DFS. It is BFS.
2) Each level is each minute.
3) Count total number of rottenFruits and freshFruits.
4) Push the rottenFruits into Queue.
5) For Each Minute, poll all the rottenFruits and offer corresponding freshFruits.
 */
import java.util.LinkedList;
import java.util.Queue;

public class AmazonOnlineTest2RottingOranges {
  int freshFruits = 0;

  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    Queue<int[]> rottenQ = new LinkedList<>();
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (grid[row][col] == 2) rottenQ.offer(new int[] {row, col});
        if (grid[row][col] == 1) freshFruits++;
      }
    }
    if (freshFruits == 0) return 0;
    int minute = 0;
    while (!rottenQ.isEmpty()) {
      int size = rottenQ.size();
      for (int i = 0; i < size; i++) {
        int[] rottenFruit = rottenQ.poll();
        int row = rottenFruit[0];
        int col = rottenFruit[1];
        update(row + 1, m, col, n, grid, rottenQ);
        update(row - 1, m, col, n, grid, rottenQ);
        update(row, m, col + 1, n, grid, rottenQ);
        update(row, m, col - 1, n, grid, rottenQ);
      }
      minute++;
    }
    return freshFruits == 0 ? minute - 1 : -1;
  }

  private void update(
      int row, int maxRow, int col, int maxCol, int[][] grid, Queue<int[]> rottenQ) {
    if (row >= 0 && row < maxRow && col >= 0 && col < maxCol && grid[row][col] == 1) {
      grid[row][col] = 2;
      rottenQ.offer(new int[] {row, col});
      freshFruits--;
    }
  }
}
