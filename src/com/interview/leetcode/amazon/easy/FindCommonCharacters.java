package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-common-characters/
 *
 * 1) Count number of occurrence of char in string1.
 * 2) Count number of occurrence of char in string2.
 * 3) Compare each index and minimum is the answer between string1 and string2.
 * 4) Take above as source and compare with string2.
 *
 *  (String4 vs (String3 vs (String1 vs String2)))
 *
 */
public class FindCommonCharacters {
  public List<String> commonChars(String[] input) {
    int[] count1 = new int[26];
    int[] count2 = new int[26];
    for (Character c : input[0].toCharArray()) {
      int index = c - 'a';
      count1[index] += 1;
    }
    for (int i = 1; i < input.length; i++) {
      for (Character c : input[i].toCharArray()) {
        int index = c - 'a';
        count2[index] += 1;
      }
      for (int j = 0; j < 26; j++) {
        count1[j] = Math.min(count1[j], count2[j]);
      }
      count2 = new int[26];
    }
    List<String> result = new ArrayList<>();
    int i = 0;
    for (int c : count1) {
      while (c-- > 0) result.add("" + (char) (i + 'a'));
      i++;
    }
    return result;
  }
}
