package com.sample.datastructure;

import java.util.Deque;
import java.util.LinkedList;

/*
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * 1) Trick is,Whenever u add a element, u need it at bottom. That is end of queue line.
 * =======PUSH Operation========Implemented with 1 Stack and 1 Recursion============
 * 2) Recursively pop element and keep it in temp.
 * 3) If the Bottom is reached (base condition met --> stack.size()==0 ),
 * then insert the element.
 * 4) push the temp element back to Stack.
 *
 * Note::::::: Similar to InOrder(Ex:a+b) Traversal
 */
public class QueueUsingStack {

  Deque<Integer> stack;

  public QueueUsingStack() {
    stack = new LinkedList<>();
  }

  public void push(int x) {
    if (stack.isEmpty()) {
      stack.push(x);
      return;
    }
    if (!stack.isEmpty()) {
      int prev = stack.pop();
      push(x);
      stack.push(prev);
    }
  }

  public int pop() {
    return stack.pop();
  }

  public int peek() {
    return stack.iterator().next();
  }

  public boolean empty() {
    return stack.isEmpty();
  }
}
