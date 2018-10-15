package com.interview.leetcode.linkedin.easy;

import java.util.Deque;
import java.util.LinkedList;

/*
 * https://leetcode.com/problems/max-stack/description/
 */
public class MaxStack_UsingPair {
	public class Pair {
		public int data;
		public int max;

		public Pair(int data, int max) {
			this.data = data;
			this.max = max;
		}

		public String toString() {
			return data + " " + max;
		}
	}

	Deque<Pair> stack;

	public MaxStack_UsingPair() {
		stack = new LinkedList<>();
	}

	public void push(int x) {
		if (stack.size() == 0) {
			stack.push(new Pair(x, x));
		} else {
			if (stack.peek().max > x) {
				stack.push(new Pair(x, stack.peek().max));
			} else {
				stack.push(new Pair(x, x));
			}
		}
	}

	public int pop() {
		return stack.pop().data;
	}

	public int top() {
		return stack.peek().data;
	}

	public int peekMax() {
		return stack.peek().max;
	}

	public int popMax() {
		int max = stack.peek().max;
		popMax1(max);
		return max;
	}

	public void popMax1(int dataToPop) {
		Pair p = stack.pop();
		if (p.data == dataToPop) {
			return;
		} else {
			popMax1(dataToPop);
		}
		push(p.data);
	}

}
