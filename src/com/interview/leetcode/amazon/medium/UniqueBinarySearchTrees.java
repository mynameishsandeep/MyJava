package com.interview.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/unique-binary-search-trees
 *
 * https://www.youtube.com/watch?v=YDf982Lb84o&feature=youtu.be&t=339
 *
When n = 0, ans=1 --> For multiplication to succeed.
When n = 1, ans=1
When n = 2, ans=2
When n = 3, ans=5
When n = 4, ans=14

==========Solution: Derived from Tushar video. Watch it must ========
1) The problem solution goes more of "summing" the subset value.
2) When n=4, solve for 2 first save in map.
then solve 3 save in map and then solve 4 save and save in map.
3) At each time save value into map. So that it will be used in next step. DP.
==========================

Ex: n = 2
  input = {1,2}
  =========================
  For the above input, logical reasoning when i=1
  i is pointing to 1. On left of i there is nothing so 0. On right of i 1 value.
  i is pointing to 2. On left of i 1 value. On right of i there is nothing so 0.
  ======================
  i = 1, left = 0, right = 1; --> 1*1 = 1
  i = 2, left = 1, right = 0; --> 1*1 = 1 +
  									========
  										2
  									========

Ex: n = 3
  input = {1,2,3}

  i = 1, left = 0, right = 2; --> 1*2 = 2
  i = 2, left = 1, right = 1; --> 1*1 = 1 +
  i = 3, left = 2, right = 1; --> 1*2 = 2 +
  									========
  										5
  									========

Ex: n = 4
  input = {1,2,3,4}

  i = 1, left = 0, right = 3; --> 1*5 = 5
  i = 2, left = 1, right = 2; --> 1*2 = 2 +
  i = 3, left = 2, right = 1; --> 2*1 = 2 +
  i = 4, left = 3, right = 0; --> 5*1 = 5 +
  									========
  									    14
  									========

Ex: n = 5
  input = {1,2,3,4,5}

  i = 1, left = 0, right = 4; --> 1*14 = 14
  i = 2, left = 1, right = 3; --> 1*5  =  5 +
  i = 3, left = 2, right = 2; --> 2*2  =  4 +
  i = 4, left = 3, right = 1; --> 5*1  =  5 +
  i = 5, left = 4, right = 0; --> 14*1 = 14 +
  									  ========
  									     42
  									  ========
 */
public class UniqueBinarySearchTrees {
  public int numTrees(int nTotal) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    map.put(1, 1);

    for (int n = 2; n <= nTotal; n++) {
      int sum = 0;
      for (int i = 1; i <= n; i++) {
        int left = map.get(i - 1);
        int right = map.get(n - i);
        sum = sum + (left * right);
      }
      map.put(n, sum);
    }
    return map.get(nTotal);
  }
}
