package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Given a string containing just the characters '(' and ')', find the length of the
 * longest valid (well-formed) parentheses substring.
 *
 * ")()())" --> 4
 * "()(()()" --> 4---------Important-------
 * "()(())" --> 6
 *
 * ============From Interview point of explain 2 case () and (()===========
 * Reason for Adding -1 in the beginning.
 * Ex: input: ()
 * For '('... index will be added in stack. so stack will have 2 element
 * For ')'... index will be removed.so stack will have 1 element i.e -1
 *  maxans = Math.max(0, 1 - (-1)); -->2
 *
 * Ex: input:(()
 * For '('... index will be added in stack. so stack will have 2 element (-1,0)
 * For '('... index will be added in stack. so stack will have 3 element (-1,0,1)
 * For ')'... top will be removed.so stack will have 2 element i.e -1,0
 *  maxans = Math.max(0, 2 - 0); -->2
 *
 *
 * ==================
 */
public class LongestValidParentheses {

  public int longestValidParentheses(String s) {
    int maxans = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          maxans = Math.max(maxans, i - stack.peek());
        }
      }
    }
    return maxans;
  }
}
