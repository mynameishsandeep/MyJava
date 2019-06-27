package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/fruit-into-baskets/description/
 *
 * Problem Understanding: At any-time I can choose any 2 tree, fill 2 basket
 * So fill fruits in each specific basket and count max of fruit.
 * When encountering a new fruit. Throw away previous fruit and start fill next fruit.
 * Ex: [banana, banana, banana, apple, apple, cherry, cherry]...
 * fill basket1 with banana,banana,banana.
 * fill basket2 with apple, apple.
 * Throw away banana.. fill cherry cherry
 *
 * This problem is same as "LongestSubstringWithAtMostKDistinctCharacters_SlidingWindow.java" with K=2
 */
public class FruitIntoBaskets {

  public int totalFruit(int[] tree) {
    int windowStart = 0, maxLength = 0;
    Map<Integer, Integer> fruitFrequencyMap = new HashMap<>();
    for (int windowEnd = 0; windowEnd < tree.length; windowEnd++) {
      fruitFrequencyMap.put(
          tree[windowEnd], fruitFrequencyMap.getOrDefault(tree[windowEnd], 0) + 1);
      // shrink the sliding window, until we are left with '2' fruits in the frequency map
      while (fruitFrequencyMap.size() > 2) {
        int startWindowFruit = tree[windowStart];
        fruitFrequencyMap.put(startWindowFruit, fruitFrequencyMap.get(startWindowFruit) - 1);
        if (fruitFrequencyMap.get(startWindowFruit) == 0) {
          fruitFrequencyMap.remove(startWindowFruit);
        }
        windowStart++; // shrink the window
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }

  public static void main(String[] args) {
    FruitIntoBaskets f = new FruitIntoBaskets();
    // System.out.println(f.totalFruit(new int[] { 3, 3, 3, 1, 1, 2, 1, 1, 2, 3, 3, 4 }));
    System.out.println(f.totalFruit(new int[] {3, 3, 3, 1, 1, 2, 3, 3, 3, 3}));
  }
}
