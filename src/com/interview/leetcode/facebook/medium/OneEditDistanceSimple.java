package com.interview.leetcode.facebook.medium;

/*
 * https://leetcode.com/problems/one-edit-distance/
 *
Given two strings s and t, determine if they are both one edit distance apart.
There are 3 possibilities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t

 ============= Solution Node: Key point============
 * From the index where it differs. take substring of remaining and compare.
 */
public class OneEditDistanceSimple {

  public boolean isOneEditDistance(String input, String search) {
    if (input.length() == search.length()) {
      return replace(input, search);
    } else if (input.length() + 1 == search.length()) {
      return insert(input, search);
    } else if (input.length() - 1 == search.length()) {
      return insert(search, input);
    }
    return false;
  }

  // input size is small...
  private boolean insert(String input, String search) {
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) != search.charAt(i)) {
        String searchRemaining = search.substring(i + 1);
        String inputRemaining = input.substring(i);
        return inputRemaining.equals(searchRemaining);
      }
    }
    return true;
  }

  private boolean replace(String input, String search) {
    if (input.equals(search)) return false; // Nothing to replace
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) != search.charAt(i)) {
        String searchRemaining = search.substring(i + 1);
        String inputRemaining = input.substring(i + 1);
        return inputRemaining.equals(searchRemaining);
      }
    }
    return true;
  }
}
