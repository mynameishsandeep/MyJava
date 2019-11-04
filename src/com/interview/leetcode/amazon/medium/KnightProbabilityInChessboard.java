package com.interview.leetcode.amazon.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 * https://www.youtube.com/watch?v=IV-KgAGIcxk
 *
 * N represents matrix.. ex: 3 is 3*3 matrix
 * K is number of steps
===============Maths Probability. How logically works======
 Ex: In a 7*7 matrix. If Knight sits in 3*3... Then input is 7,k,3,3
 Initially set the start position as 1, to say probability is 100%
 1) If k=0, answer is 1 because it can travel in any ie. 100%
 2) If k=1, answer is 1. There are total 8 possible move. Each point reduces, previous value by 8.
 Summing all the points 1/8+1/8+1/8+1/8+1/8+1/8+1/8+1/8=1
 2) If k=2, answer is .75. There are total of 48(6 possible moves from 8 point) possible move. 
 Each point reduces, previous value by 8.
 Summing all the points (1/8)/8 * 48 = .75
====================================== 				

Ex: Input: 3, 2, 0, 0
=====When K=1======
[0.0, 0.0, 0.0]
[0.0, 0.0, 0.125]
[0.0, 0.125, 0.0]

[0.0, 0.0, 0.0]
[0.0, 0.0, 0.125]
[0.0, 0.125, 0.0]

[0.0, 0.0, 0.0]
[0.0, 0.0, 0.125]
[0.0, 0.125, 0.0]
=====When K=2======
[0.0, 0.0, 0.0]
[0.0, 0.0, 0.0]
[0.0, 0.0, 0.0]

[0.015625, 0.0, 0.0]
[0.0, 0.0, 0.0]
[0.015625, 0.0, 0.0]

[0.03125, 0.0, 0.015625]
[0.0, 0.0, 0.0]
[0.015625, 0.0, 0.0]
======================
=======================Coding============


 */
public class KnightProbabilityInChessboard {
  int[][] direction =
      new int[][] {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

  public double knightProbability(int N, int K, int r, int c) {
    double[][] dp1 = new double[N][N];
    dp1[r][c] = 1;
    double res = 0;
    for (int k = 1; k <= K; ++k) {
      double[][] dp2 = new double[N][N];
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          // If the value at point is 0.0, then move is not possible
          if (dp1[i][j] == 0.0) continue;
          for (int[] dir : direction) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row >= 0 && col >= 0 && row < N && col < N) {
              dp2[row][col] += (dp1[i][j] / 8.0);
            }
          }
        }
      }
      dp1 = dp2;
    }
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        res += dp1[i][j];
      }
    }
    return res;
  }

  /*
   * reducing 2 dp array by 1.
   * This will TLE because. Queue will grow exponentially.
   * Ex: 2 different points will point to same point. So queue will be doubled.
   */
  public double knightProbabilityQueueApproach(int N, int K, int r, int c) {
    double[][] dp = new double[N][N];
    dp[r][c] = 1;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {r, c});
    double res = 0;
    for (int k = 1; k <= K; ++k) {
      int size = q.size();
      while (size > 0) {
        int[] curr = q.poll();
        int i = curr[0];
        int j = curr[1];
        for (int[] dir : direction) {
          int row = i + dir[0];
          int col = j + dir[1];
          if (row >= 0 && col >= 0 && row < N && col < N) {
            dp[row][col] += (dp[i][j] / 8.0);
            q.offer(new int[] {row, col});
          }
        }
        // Reset the value as we found move value for 8 directions.
        dp[i][j] = 0.0;
        size--;
      }
    }
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        res += dp[i][j];
      }
    }
    return res;
  }

  /*
   * This solves TLE in BFS
   */
  public double knightProbabilityQueueApproachWithIsVisited(int N, int K, int r, int c) {
    double[][] dp = new double[N][N];
    dp[r][c] = 1;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {r, c});
    double res = 0;
    for (int k = 1; k <= K; ++k) {
      int size = q.size();
      boolean isVisited[][] = new boolean[N][N];
      while (size > 0) {
        int[] curr = q.poll();
        int i = curr[0];
        int j = curr[1];
        for (int[] dir : direction) {
          int row = i + dir[0];
          int col = j + dir[1];
          if (row >= 0 && col >= 0 && row < N && col < N) {
            dp[row][col] += (dp[i][j] / 8.0);
            if (!isVisited[row][col]) {
              q.offer(new int[] {row, col});
              isVisited[row][col] = true;
            }
          }
        }
        // Reset the value as we found move value for 8 directions.
        dp[i][j] = 0.0;
        size--;
      }
    }
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        res += dp[i][j];
      }
    }
    return res;
  }
}
