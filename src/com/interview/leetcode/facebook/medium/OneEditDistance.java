package com.interview.leetcode.facebook.medium;

/*
 * https://leetcode.com/problems/one-edit-distance/
 *
Given two strings s and t, determine if they are both one edit distance apart.

Note:

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t

 ============= Solution Node: Key point============
 * 1) For insert code, maintain 2 index, 1 for input string and 1 for search string.
 * 2) insert or delete code can be used alternatively.
 * Ex: For insert operation --> insert a char to input or delete a char from search string, both are same.
 * 		vice versa.
 * 3) in case of replace. if search string == input string then false. because nothing to replace.
 * 	  Ex: abc==abc--> false	
 *
 *  Example cases:
 *  "" "A" or "ab" "abc" --> these 2 cases are similar
 *  "ab" "acb"
 *
 */
public class OneEditDistance {

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

  private boolean insert(String input, String search) {
    boolean oneTimeInserted = false;
    for (int i = 0, j = 0; i < search.length() && j < input.length(); i++, j++) {
      if (input.charAt(j) != search.charAt(i)) {
        if (oneTimeInserted) {
          return false;
        }
        j--;
        oneTimeInserted = true;
      }
    }
    return true;
  }

  private boolean replace(String input, String search) {
    if (input.equals(search)) return false; // Nothing to replace
    boolean oneTimeReplaced = false;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) != search.charAt(i)) {
        if (oneTimeReplaced) {
          return false;
        }
        oneTimeReplaced = true;
      }
    }
    return true;
  }
}
