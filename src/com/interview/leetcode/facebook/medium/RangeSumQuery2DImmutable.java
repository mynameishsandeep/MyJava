package com.interview.leetcode.facebook.medium;

/*
 * https://leetcode.com/problems/range-sum-query-2d-immutable
 * https://www.youtube.com/watch?v=PwDqpOMwg6U
 *
============input=======
[1,2,3],
[4,5,6],
[7,8,9]
===========dp array final ========
[0, 0, 0, 0]
[0, 1, 3, 6]
[0, 5, 12, 21]
[0, 12, 27, 45]
===========Step By Step How dp Array is formed===========

    x || y
    =======
    z || z

    z = value in matrix in that position + y + z - x

[0, 0, 0, 0]
[0, 1, 0, 0]  --->1
[0, 0, 0, 0]
[0, 0, 0, 0]

[0, 0, 0, 0]
[0, 1, 3, 0]  --->2
[0, 0, 0, 0]
[0, 0, 0, 0]

[0, 0, 0, 0]
[0, 1, 3, 6]  --->3
[0, 0, 0, 0]
[0, 0, 0, 0]

[0, 0, 0, 0]
[0, 1, 3, 6]
[0, 5, 0, 0]  --->4
[0, 0, 0, 0]

[0, 0, 0, 0]
[0, 1, 3, 6]
[0, 5, 12, 0]  --->5
[0, 0, 0, 0]

[0, 0, 0, 0]
[0, 1, 3, 6]
[0, 5, 12, 21]  --->6
[0, 0, 0, 0]

[0, 0, 0, 0]
[0, 1, 3, 6]
[0, 5, 12, 21]
[0, 12, 0, 0]  --->7

[0, 0, 0, 0]
[0, 1, 3, 6]
[0, 5, 12, 21]
[0, 12, 27, 0]  --->8

[0, 0, 0, 0]
[0, 1, 3, 6]
[0, 5, 12, 21]
[0, 12, 27, 45]  --->9

================ Pick value for sum region =======
input =
[1,2,3],
[4,5,6],
[7,8,9]

 dp =
[0, 0, 0, 0]
[0, 1, 3, 6]
[0, 5, 12, 21]
[0, 12, 27, 45]

For Input : 1,1 to 2,1
We look for 2,2 to 3,2 in dp
dp[3,2] = 27
dp[1,2] = 3  -
dp[3,1] = 12 -
dp[1,1] = 1  +
         ====
          13
         ====
  	To find region between A and B.
	[0, 0, 0, 0]
	[0, x, y, 0]
	[0, 0, A, 0]
	[0, z, B, 0]

	Answer = B-y-z+x

Addition is needed because "x" is there both row-wise and column-wise

 */
public class RangeSumQuery2DImmutable {
  private int dp[][];

  public RangeSumQuery2DImmutable(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return;
    dp = new int[matrix.length + 1][matrix[0].length + 1];
    for (int r = 0; r < matrix.length; r++) {
      for (int c = 0; c < matrix[0].length; c++) {
        dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
  }
}
