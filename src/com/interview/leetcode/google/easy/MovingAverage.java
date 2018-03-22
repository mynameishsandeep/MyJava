package com.interview.leetcode.google.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
https://leetcode.com/problems/moving-average-from-data-stream/discuss/81505/Java-easy-to-understand-solution

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

 *
 */
class MovingAverage {

	Queue<Integer> queue;
	Integer size = 0;
	Double total = 0.0;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		queue = new LinkedList<Integer>();
        this.size = size;
	}

	public double next(int val) {
		queue.offer(val);
		total = total + val;
		int dataToDelete = 0;
		if (queue.size() > size) {
			dataToDelete = queue.poll();
			total = total - dataToDelete;
		}
		return total / queue.size();
	}
	
	public static void main(String[] args) {
		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));
		
	}
}
