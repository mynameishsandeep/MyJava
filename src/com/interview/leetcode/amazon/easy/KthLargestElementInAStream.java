package com.interview.leetcode.amazon.easy;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInAStream {

  Queue<Integer> pQ = new PriorityQueue<>();
  int max = 0;

  public KthLargestElementInAStream(int k, int[] nums) {
    max = k;
    for (int num : nums) {
      if (pQ.size() == k && num < pQ.peek()) continue; // Avoiding unnecessary adding of new data.
      pQ.offer(num);
      if (pQ.size() > k) {
        pQ.poll();
      }
    }
  }

  public int add(int val) {
    pQ.offer(val);
    if (pQ.size() > max) {
      pQ.poll();
    }
    return pQ.peek();
  }
}
