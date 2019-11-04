package com.interview.leetcode.linkedin.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * ===Note: Be careful with num1 and num2... Issue will happen for / and - operation====
 *  Ex: "5","10", "/"
 *  Here num2 is 10 and num1 is 5. First pop will give num2 and then second pop will give num1
 */
public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    Set<String> operator = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    for (String token : tokens) {
      if (operator.contains(token)) {
        int num2 = stack.pop();
        int num1 = stack.pop();
        stack.push(doOperation(token, num1, num2));
      } else {
        stack.push(Integer.valueOf(token));
      }
    }
    return stack.pop();
  }

  private int doOperation(String operator, int num1, int num2) {
    switch (operator) {
      case "+":
        return num1 + num2;
      case "-":
        return num1 - num2;
      case "*":
        return num1 * num2;
      case "/":
        return num1 / num2;
      default:
        return -1;
    }
  }
}
