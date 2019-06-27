package com.interview.leetcode.uber.medium;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounterSimple {
	Queue<Integer> q = null;

	public DesignHitCounterSimple() {
		q = new LinkedList<Integer>();
	}

	public void hit(int timestamp) {
		q.offer(timestamp);
	}

	public int getHits(int timestamp) {
		while (!q.isEmpty() && timestamp - q.peek() >= 300) {
			q.poll();
		}
		return q.size();
	}
}
