package com.interview.leetcode.linkedin.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.interview.leetcode.NestedInteger;
/*
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
  private Queue<Integer> q;

  public FlattenNestedListIterator(List<NestedInteger> nestedList) {
    q = new LinkedList<>();
    flatten(nestedList);
  }

  private void flatten(List<NestedInteger> nestedList) {
    for (NestedInteger nested : nestedList) {
      if (nested.isInteger()) {
        q.add(nested.getInteger());
      } else {
        flatten(nested.getList());
      }
    }
  }

  @Override
  public Integer next() {
    return q.poll();
  }

  @Override
  public boolean hasNext() {
    return !q.isEmpty();
  }
}
