package com.interview.leetcode.amazon.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {


	public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for(Character c : s.toCharArray()) {
            if(set.contains(c)) {
                set.remove(c);
                result= result+2;
            } else {
                set.add(c);
            }
        }
        return set.isEmpty()?result: result+1;
    }
	
	public int longestPalindromeUsingMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int singleMax = 0;
    int result = 0;
    for (Integer i : map.values()) {
      if (i % 2 == 1) {
        result += i - 1;
        singleMax = 1;
      } else {
        result += i;
      }
    }
    return result + singleMax;
  }
}
