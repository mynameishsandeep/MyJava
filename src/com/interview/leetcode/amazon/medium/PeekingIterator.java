package com.interview.leetcode.amazon.medium;

import java.util.Iterator;

/*
 * https://leetcode.com/problems/peeking-iterator/description/
 * 
 * Note: 
 * To support the peek operation on Iterator. Cache the first element in iterator and hold it.
 */

class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iterator;
	private Integer cache;

	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
		if (iterator.hasNext()) {
			cache = iterator.next();
		}

	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer temp = cache;
		if (iterator.hasNext()) {
			cache = iterator.next();
		} else {
			cache = null;
		}
		return temp;
	}

	@Override
	public boolean hasNext() {
		return cache != null;
	}
}