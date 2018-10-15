package com.interview.leetcode.linkedin.easy;

import java.util.List;

import com.interview.leetcode.linkedin.medium.FlattenNestedListIterator.NestedInteger;

/*
 * https://leetcode.com/problems/nested-list-weight-sum/description/
 */
public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1);
	}

	public int depthSum(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		System.out.println(nestedList.size());
		for (NestedInteger nested : nestedList) {
			System.out.println("nested.isInteger() " + nested.isInteger() + " nested.getInteger() "
					+ nested.getInteger() + " depth " + depth);
			if (nested.isInteger()) {
				sum += nested.getInteger() * depth;
			} else {
				sum += depthSum(nested.getList(), depth + 1);
			}
		}
		return sum;
	}
}
