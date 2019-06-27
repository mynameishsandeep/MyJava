package com.interview.leetcode.facebook.easy;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/moving-average-from-data-stream/discuss/81505/Java-easy-to-understand-solution
 */
public class FindMean_MovingAverageFromDataStream {
	Queue<Integer> q;
	int capacity;
	int currSum;

	/** Initialize your data structure here. */
    public FindMean_MovingAverageFromDataStream(int size) {
        q = new LinkedList<Integer>();
        capacity = size;
        currSum = 0;
    }

	public double next(int val) {
		currSum += val;
		q.offer(val);

		if (q.size() > capacity) {
			currSum -= q.poll();
		}

		return currSum * 1.0 / q.size();
	}
}
