package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-word-in-dictionary/
 * 
 * 1) Always word should start from 1 character.
 * 2) 
 */
public class LongestWordInDictionary {

  public String longestWord(String[] words) {
    Arrays.sort(words);
    Set<String> set = new HashSet<String>();
    String res = "";
    for (String w : words) {
      if (w.length() == 1 || set.contains(w.substring(0, w.length() - 1))) {
        res = w.length() > res.length() ? w : res; // First sorted string will be saved
        set.add(w);
      }
    }
    return res;
  }
}
