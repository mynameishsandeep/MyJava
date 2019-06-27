package com.interview.leetcode.amazon.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/peeking-iterator/description/
 * 
 * Note: 
 * This solution might not be accepted in interview, as we are iterating the iterator once and putting in q, 
 * which makes the solution reading twice from the data structure. 
 * But still accepted solution.
 */
class PeekingIterator_UsingQ implements Iterator<Integer> {
	Queue<Integer> q = new LinkedList<>();

	public PeekingIterator_UsingQ(Iterator<Integer> iterator) {
		while (iterator.hasNext()) {
			q.add(iterator.next());
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return q.peek();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		return q.poll();
	}

	@Override
	public boolean hasNext() {
		return q.size() > 0;
	}
}