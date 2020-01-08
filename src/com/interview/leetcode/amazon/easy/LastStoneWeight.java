package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
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

  public int lastStoneWeight1(int[] stones) {
    return lastStoneWeight(stones, stones.length);
  }

  public int lastStoneWeight(int[] stones, int end) {
    if (end == 0) return 0;
    if (end == 1) return stones[0];
    Arrays.sort(stones, 0, end);
    int a = stones[end - 1] - stones[end - 2];
    stones[end - 2] = a;
    return lastStoneWeight(stones, end - 1);
  }
}
