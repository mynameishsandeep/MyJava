package com.interview.leetcode.amazon.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/number-of-boomerangs/
 *
 * 1) Find all the distance for a point to all other points.
 * 2) choose 2 items out of collection of n items permutation. Because pairwise distinct.
Permutation
take 2 from n elements, there are total P(2, n) = n! / (n-2)! = n * (n-1) possible solutions
 */
public class NumberOfBoomerangs {
  public int numberOfBoomerangs(int[][] points) {
    int res = 0;

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points.length; j++) {
        if (i == j) {
          continue;
        }

        int d = getDistance(points[i], points[j]);
        map.put(d, map.getOrDefault(d, 0) + 1);
      }
      //Convert 3 points to 2 points
      // https://leetcode.com/problems/number-of-boomerangs/discuss/126604/For-people-who-don't-know-why-we-need-this-line%3A-res-%2B-val-*-(val-1)
      for (int val : map.values()) {
        res += val * (val - 1);
      }
      map.clear();
    }

    return res;
  }

  private int getDistance(int[] a, int[] b) {
    int dx = a[0] - b[0];
    int dy = a[1] - b[1];

    return dx * dx + dy * dy;
  }
}
