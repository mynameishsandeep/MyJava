package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {
  // Input: [2,7,4,1,8,1]
  // [8,7,4,2,1,1]
  // [4,2,1,1,1]
  // [2,1,1,1]
  // [1,1,1]
  // [1]
  public int lastStoneWeight(int[] stones) {
    Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    for (int stone : stones) q.offer(stone);
    while (q.size() > 1) {
      Integer num1 = q.poll();
      Integer num2 = q.poll();
      if (num1.equals(num2)) q.offer(num1 - num2);
    }
    return !q.isEmpty() ? q.poll() : 0;
  }

  /*
   * Below logic keeps the whole data. But moves the compare index from n to 1.
   */
  public int lastStoneWeight1(int[] stones) {
    int end = stones.length;
    while (end > 1) {
      Arrays.sort(stones);
      int a = stones[end - 1] - stones[end - 2];
      stones[end - 2] = a;
      end--;
    }
    return stones[0];
  }
}
