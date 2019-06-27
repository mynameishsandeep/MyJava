package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/clone-graph/description/
 *
 * The 2 difference between Clone Graph against Clone Tree(CloneTree.java) is
 * 1) Tree has only left and right. Recursive call will happen for left and right. whereas
 * 	  Graph has List of adjacency nodes. So for loop for all the list of nodes.
 * 2) Tree cannot have loops.
 *    But Graph can have loops.
 * Ex: A -> B and B -> C and C -> A.
 * To Handle Loop, Save Each original node in the hashmap with corresponding cloned node, which is the key.
 * So "A" node should not be cloned again, during recursive call with C as root. Cloned "A" will be returned to "C" node.
 *
 */
public class CloneGraph {
  public Node cloneGraph(Node node) {
    return clone(node, new HashMap<>());
  }

  public Node clone(Node sourceNode, Map<Node, Node> cloneMap) {
    if (sourceNode == null) {
      return null;
    }
    if (cloneMap.containsKey(sourceNode)) {
      return cloneMap.get(sourceNode);
    }
    Node cloneNode = new Node(sourceNode.val, new ArrayList<>());
    cloneMap.put(sourceNode, cloneNode);

    for (int i = 0; i < sourceNode.neighbors.size(); i++) {
      Node sourceNeighbors = clone(sourceNode.neighbors.get(i), cloneMap);
      cloneNode.neighbors.add(sourceNeighbors);
    }
    return cloneNode;
  }

  static class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
