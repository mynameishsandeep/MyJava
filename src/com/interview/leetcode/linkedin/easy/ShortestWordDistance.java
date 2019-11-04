package com.interview.leetcode.linkedin.easy;

/*
 * https://leetcode.com/problems/shortest-word-distance/description/
 *
 * 1) Iterate word by word, update the wordIndex with latest index.
 * 2) subtract the index and update shortest path
 */
public class ShortestWordDistance {

  public int shortestDistance(String[] words, String word1, String word2) {
    int result = Integer.MAX_VALUE;
    int w1I = -1;
    int w2I = -1;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        w1I = i;
        if (-1 != w2I) {
          result = Math.min(result, i - w2I);
        }
      } else if (words[i].equals(word2)) {
        w2I = i;
        if (-1 != w1I) {
          result = Math.min(result, i - w1I);
        }
      }
    }
    return result;
  }
}
