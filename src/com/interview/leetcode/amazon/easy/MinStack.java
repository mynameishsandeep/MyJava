package com.interview.leetcode.amazon.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 1) 2 Stack is used. 
 * 2) 1 to store value and 2nd to store minimum at that point.
 * Note: Storing min value for each value is costlier operation. So this is better approach than custom class with value and min-value
 * 
 * Ex: push 1,2,3,4,5... minValueStack will have 1 only.
 * 
 */
class MinStack {
	Deque<Integer> valueStack = new ArrayDeque<>();
	Deque<Integer> minValueStack = new ArrayDeque<>();

	public void push(int x) {
		valueStack.push(x);
		if ((minValueStack.size() == 0) || (minValueStack.peek() >= x)) {
			minValueStack.push(x);
		}
	}

	public void pop() {
		int x = valueStack.pop();
		if (minValueStack.peek() == x) {
			minValueStack.pop();
		}
	}

	public int top() {
		return valueStack.peek();
	}

	public int getMin() {
		return minValueStack.peek();
	}
	
	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(1);
		m.push(2);
		m.push(3);
		m.push(4);
		m.push(5);
		System.out.println(m.minValueStack);
		
	}
}
