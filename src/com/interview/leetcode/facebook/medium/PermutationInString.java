package com.interview.leetcode.facebook.medium;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

  public boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : s1.toCharArray()) {
      Integer count = map.getOrDefault(c, 0);
      map.put(c, count);
    }
    Map<Character, Integer> mapSource = new HashMap<>();
    mapSource.putAll(map);
    for (int right = 0; right < s2.length(); right++) {
      Character c = s2.charAt(right);
      if (map.containsKey(c)) {
        if (map.get(c) == 1) {
          map.remove(c);
          if (map.isEmpty()) {
            return true;
          }
        } else {
          map.put(c, map.get(c) - 1);
        }
      } else {
        map.clear();
        map.putAll(mapSource);
      }
    }
    return false;
  }

  public boolean checkInclusionBest(String s1, String s2) {
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : s1.toCharArray()) {
      Integer count = map.getOrDefault(c, 0);
      map.put(c, count + 1);
    }
    Map<Character, Integer> mapSource = new HashMap<>();
    mapSource.putAll(map);
    for (int left = 0, right = 0; right < s2.length(); right++) {
      Character c = s2.charAt(right);
      if (map.containsKey(c)) {
        if (map.get(c) == 0) {
          // Move left till finding same c
          while (s2.charAt(left) != c) {
            Character leftChar = s2.charAt(left++);
            map.put(leftChar, map.get(leftChar) + 1);
          }
          left++;
        } else if (map.get(c) == 1 && right - left + 1 == s1.length()) {
          return true;
        } else {
          map.put(c, map.get(c) - 1);
        }
      } else {
        while (s2.charAt(left) != c) {
          Character leftChar = s2.charAt(left++);
          map.put(leftChar, map.get(leftChar) + 1);
        }
        left++;
      }
    }
    return false;
  }
}
