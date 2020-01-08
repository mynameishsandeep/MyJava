package com.interview.leetcode.graph;

import java.util.List;

public class Node {
  public final int val;
  public final List<Node> neighbors;

  public Node(final int val, final List<Node> neighbors) {
    this.val = val;
    this.neighbors = neighbors;
  }
}
