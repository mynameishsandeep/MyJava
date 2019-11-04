package com.interview.leetcode.uber.medium;

import java.util.Arrays;
import java.util.Random;

/*
 * https://leetcode.com/problems/random-pick-with-weight/description/
 *
 *Use binarySearch to search the key
====================================
 */
public class RandomPickWithWeightApproach3 {
  int[] wSums;
  Random random = new Random();

  public RandomPickWithWeightApproach3(int[] w) {
    for (int i = 1; i < w.length; ++i) w[i] += w[i - 1];
    this.wSums = w;
  }

  public int pickIndex() {
    int len = wSums.length;
    int idx = random.nextInt(wSums[len - 1]) + 1;
    int i = Arrays.binarySearch(wSums, idx);
    return i >= 0 ? i : -i - 1;
  }
}
