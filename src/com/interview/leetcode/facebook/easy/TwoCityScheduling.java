package com.interview.leetcode.facebook.easy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/two-city-scheduling/
 *
https://leetcode.com/problems/two-city-scheduling/discuss/279648/Simplest-solution-O(n)-using-priority-queue
*/

public class TwoCityScheduling {
  public int twoCitySchedCost(int[][] costs) {
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int len = costs.length;
    int sumX = 0;

    // Send all the people to city A, (or B)
    for (int[] cost : costs) {
      sumX += cost[0];
      pq.add(cost[0] - cost[1]); // costs to be added if they have to go to B instead of A
    }

    // remove
    for (int i = 0; i < len / 2; i++) {
      sumX = sumX - pq.poll(); // remove minimum n costs
    }

    return sumX;
  }
}
