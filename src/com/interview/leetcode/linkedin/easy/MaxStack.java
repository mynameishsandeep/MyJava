package com.interview.leetcode.linkedin.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/max-stack/description/
 *
Design a max stack that supports push, pop, top, peekMax and popMax.

1) push(x) -- Push element x onto stack.
2) pop() -- Remove the element on top of the stack and return it.
3) top() -- Get the element on the top.
4) peekMax() -- Retrieve the maximum element in the stack.
5) popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.

Solution Note: Using 1 stack and max variable.
 	0) A regular stack already supports the first 3 operations.
	1) During pop() operation, max will change, so recursion has to be done for all the element, to get the new max.
	2) During popMax(), even after finding max, recursion has to be done for all the element.

 *
 *
 */
class MaxStack {

  Deque<Integer> stack;
  int max = Integer.MIN_VALUE;

  public MaxStack() {
    stack = new ArrayDeque<>();
  }

  public void push(int x) {
    stack.push(x);
    if (x > max) {
      max = x;
    }
  }

  public int pop() {
    int x = stack.pop();
    max = Integer.MIN_VALUE;
    pop1();
    return x;
  }

  public void pop1() {
    if (!stack.isEmpty()) {
      int x = stack.pop();
      if (x > max) {
        max = x;
      }
      pop1();
      stack.push(x);
    }
  }

  public int top() {
    return stack.peek();
  }

  public int peekMax() {
    return max;
  }

  public int popMax() {
    int currMax = max;
    popMaxRecur(false);
    // System.out.println("stack.size" + stack.size());
    return currMax;
  }

  public void popMaxRecur(boolean matchFound) {
    System.out.println("stack.size" + stack.size());
    if (!stack.isEmpty()) {
      System.out.println("max " + max);
      int x = stack.pop();
      if (x == max && !matchFound) {
        matchFound = true;
        max = Integer.MIN_VALUE;
        popMaxRecur(matchFound);
      } else {
        popMaxRecur(matchFound);
        if (x > max) {
          max = x;
        }
        stack.push(x);
      }
    }
  }

  public static void main(String[] args) {
    MaxStack m = new MaxStack();
    m.push(5);
    m.push(1);
    m.popMax();
    m.peekMax();
  }
}
