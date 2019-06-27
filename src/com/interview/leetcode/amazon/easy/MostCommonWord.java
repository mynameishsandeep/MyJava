package com.interview.leetcode.amazon.easy;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/most-common-word/
 */
public class MostCommonWord {
  public String mostCommonWord(String paragraph, String[] banned) {
    String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
    HashMap<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    for (String word : banned) {
      if (map.containsKey(word)) {
        map.remove(word);
      }
    }
    String res = null;
    for (String word : map.keySet()) {
      if (res == null || map.get(word) > map.get(res)) {
        res = word;
      }
    }
    return res;
  }
}
