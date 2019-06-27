package com.interview.leetcode.facebook.easy;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/verifying-an-alien-dictionary/
*
*  1) In first difference of character between 2 word,
   first should be lower and second should be greater

   2) for 3 words. compare 1 &2, then 2&3
*/
public class VerifyingAnAlienDictionary {

  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
      map.put(order.charAt(i), i);
    }
    for (int i = 1; i < words.length; i++) {
      String first = words[i - 1];
      String second = words[i];
      for (int j = 0; j < first.length(); j++) {
        int firstCharPosition = map.get(first.charAt(j));
        if (j == second.length()) return false;
        int secondCharPosition = map.get(second.charAt(j));
        if (firstCharPosition == secondCharPosition) continue;
        if (firstCharPosition < secondCharPosition) {
          break; // success. Go for next 2 word compare
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isAlienSortedAvoidMap(String[] words, String order) {
    for (int i = 1; i < words.length; i++) {
      String first = words[i - 1];
      String second = words[i];
      for (int j = 0; j < first.length(); j++) {
        int firstCharPosition = order.indexOf(first.charAt(j));
        if (j == second.length()) return false;
        int secondCharPosition = order.indexOf(second.charAt(j));
        if (firstCharPosition == secondCharPosition) continue;
        if (firstCharPosition < secondCharPosition) {
          break; // success. Go for next 2 word compare
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
