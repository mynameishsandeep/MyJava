package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */
public class FlattenNestedListIterator2 {
	List<Integer> result = new ArrayList<>();
	int size;

	public FlattenNestedListIterator2(List<NestedInteger> nestedList) {
		recur(nestedList);
	}

	public void recur(List<NestedInteger> nestedList) {
		for (NestedInteger n : nestedList) {
			recur(n.getList());
			if (n.isInteger()) {
				result.add(n.getInteger());
			}
		}
	}

	public Integer next() {
		return result.get(size++);

	}

	public boolean hasNext() {
		return result.size() > size;
	}

	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

}
