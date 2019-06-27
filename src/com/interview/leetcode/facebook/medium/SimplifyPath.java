package com.interview.leetcode.facebook.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {
  public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    for (String token : path.split("/")) {
      if (token.length() == 0 || token.equals(".")) continue;
      if (token.equals("..")) {
        if (stack.size() > 0) stack.pop();
      } else {
        stack.push(token);
      }
    }

    StringBuilder builder = new StringBuilder();
    builder.append("/");
    while (stack.size() > 0) {
      builder.append(stack.removeLast());
      if (stack.size() > 0) builder.append("/");
    }
    return builder.toString();
  }
}
