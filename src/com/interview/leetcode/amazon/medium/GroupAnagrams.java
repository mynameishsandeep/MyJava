package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

 * Challenges:
 * 1) Convert the String to char[]. Then sort with Arrays.sort.
 * Then create new String with sorted char[].
 * Save it in map with key as sorted and value as original.
 * 2) Return original
 */
public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String input : strs) {
      char[] c = input.toCharArray();
      Arrays.sort(c);
      String sortedString = new String(c);
      if (map.containsKey(sortedString)) {
        List<String> old = map.get(sortedString);
        old.add(input);
        map.put(sortedString, old);
      } else {
        List<String> newS = new ArrayList<>();
        newS.add(input);
        map.put(sortedString, newS);
      }
    }
    return new ArrayList<>(map.values());
  }
}
