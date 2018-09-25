package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;
/*
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */
public class FlattenNestedListIterator {
	List<Integer> result = new ArrayList<>();
	List<Integer> reverseResult = new ArrayList<>();

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		recur(nestedList);
		for (int i = result.size() - 1; i >= 0; i--) {
			reverseResult.add(result.get(i));
		}

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
		return reverseResult.remove(reverseResult.size() - 1);

	}

	public boolean hasNext() {
		return reverseResult.size() > 0;
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
