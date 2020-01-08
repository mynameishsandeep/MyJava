package com.interview.leetcode.facebook.easy;

/*
 * https://leetcode.com/problems/remove-outermost-parentheses/
 *
 * 1) On analyzing the result. Solution is, if open and close are matching then pick the value between them.
 */
public class RemoveOutermostParentheses {
  public String removeOuterParentheses(String str) {
    StringBuilder result = new StringBuilder();
    int start = 0, open = 0, close = 0;
    int i = 0;
    for (Character c : str.toCharArray()) {
      if (c == '(') open++;
      else close++;
      if (open == close) {
        result.append(str.substring(start + 1, i));
        start = i + 1;
      }
      i++;
    }
    return result.toString();
  }
}
