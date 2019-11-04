package com.interview.leetcode.uber.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * https://leetcode.com/problems/random-pick-with-weight/description/
 *
This one throws TimeLimitException due to large number of data. Use RandomPickWithWeight.java
====================================
 */
public class RandomPickWithWeightDeNormalized {
  Map<Integer, Integer> map = new HashMap<>();
  Random rnd = new Random();
  int count = 0;

  public RandomPickWithWeightDeNormalized(int[] w) {

    int number = 0;
    for (int i = 0; i < w.length; i++) {
      for (int j = 0; j < w[i]; j++) {
        map.put(++count, number);
      }
      number++;
    }
  }

  public int pickIndex() {
    int random = rnd.nextInt(count) + 1;
    return map.get(random);
  }
}
