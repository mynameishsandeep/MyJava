package com.interview.leetcode.linkedin.unlocked;

import java.util.Arrays;

/*
* https://leetcode.com/problems/paint-house/description/
* =========Note====================================================================================
* This problem takes time about understanding the requirement and input structure. Solution is simple.
* Take house structure as ladder.Ex: Below has 3 house and u can color red, blue or green on each row.
* current and previous row cannot have same color painted.
* 				===
* 				| |
*  				===
*  				| |
*  				===
*  				| |
*  				===
*
* =================================================================================================
1) Row represents number of houses and column represents colors.
2) Color(column) is fixed (Red, Green, Blue) and houses count (row) can change.
3) There can be output like Red, Blue, Red. So point is adjacent house can't be same color.
4) If there is only one row. Then result is minimum of all columns. For loop will not run
5) Logic starts from 1 row meaning 0th row is minimum of 3 colors.
6) Data is corrupted or at each time we update the value of input(Apart from row0) itself.

======Implementation====
1) Start from 1st row.
2) 2nd row first column filled based on 1st row 2nd column and 3rd column
3) costs[red] = Math.min( costs[blue], costs[green]) + cost[red] --- left side is current row, right side is previous row
4) costs[green] = Math.min( costs[blue], costs[red]) + cost[green] --- left side is current row, right side is previous row
5) costs[blue] = Math.min( costs[red], costs[green]) + cost[blue] --- left side is current row, right side is previous row

==============
Input:
[17,2,18]
[16,15,5]
[14,3,19]

Ignore Row 0.
Update Row 1
[17,2,17]
[18,32,7] --> Math.min(2,18) + 16 --> Math.min(17,17) + 16 --> Math.min(17,2) + 5
[14,3,19]

Update Row 2
[17,2,17]
[33,33,7]
[21,10,37] --> Math.min(33,7) + 14 --> Math.min(18,7) + 3 --> Math.min(18,33) + 19

Result is minimum cost of last Row. If there is only one row result is minimum 1st row itself.
*/
public class PaintHouse {
  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    for (int i = 1; i < costs.length; i++) {
      costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
      costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
      costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
    }
    for (int[] cost : costs) {
      System.out.println(Arrays.toString(cost));
    }
    int n = costs.length - 1;
    return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
  }

  public static void main(String[] args) {
    PaintHouse p = new PaintHouse();
    p.minCost(new int[][] {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}});
  }
}
