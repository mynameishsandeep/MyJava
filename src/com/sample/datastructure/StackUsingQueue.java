package com.sample.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/implement-stack-using-queues/discuss/62516/Concise-1-Queue-Java-C++-Python
 * 
 * 1) Can be done with single queue instead of 2 queues.
 * 2) Whenever insert happens. Insert data. Then move n-1 data again.
 * 3) Rest of the APIs are same.
 */
public class StackUsingQueue {
	Queue<Integer> q;

	public StackUsingQueue() {
		q = new LinkedList<>();
	}

	public void push(int x) {
		q.offer(x);
		int length = q.size() - 1;
		for (int i = 0; i < length; i++) {
			q.offer(q.poll());
		}
	}

	public int pop() {
		return q.poll();
	}

	public int top() {
		return q.peek();
	}

	public boolean empty() {
		return q.isEmpty();
	}

}
