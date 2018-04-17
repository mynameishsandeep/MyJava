package com.interview.leetcode.amazon.easy;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
	class SData {
		int data;
		int min;

		public SData(int data, int min) {
			this.data = data;
			this.min = min;
		}
	}

	Deque<SData> stack = new ArrayDeque<>();

	public void push(int x) {
		SData s = new SData(x, getMin(x));
		stack.push(s);
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek().data;
	}

	public int getMin(int x) {
		if (stack.size() > 0 && stack.peek().min < x) {
			return stack.peek().min;
		}
		return x;
	}

	public int getMin() {
		if (stack.size() > 0) {
			return stack.peek().min;
		}
		return Integer.MAX_VALUE;
	}
}
