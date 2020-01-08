package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.interview.leetcode.graph.Node;

/*
 * https://leetcode.com/problems/clone-graph/description/
 *
 * The 2 difference between Clone Graph against Clone Tree(CloneTree.java) is
 * 1) Tree has only left and right. Recursive call will happen for left and right, whereas
 * 	  Graph has List of adjacency nodes. So for loop for all the list of nodes.
 * 2) Tree cannot have loops. But Graph can have loops.
 * Ex: A -> B and B -> C and C -> A.
 * A => [B,C]
 * B => [C,A]
 * C => [B,A]
 * To Handle Loop, Save Each original node in the hashmap with corresponding cloned node, which is the key.
 * So "A" node should not be cloned again, during recursive call with C as root. Cloned "A" will be returned to "C" node.
 *
 * ========================Step by Step clone================
 * 1) A created.
 * 2) A's neighbor B called in clone.
 * 3) B created.
 * 4) B's neighbor C called in clone.
 * 5) C created.
 * 6) C's neighbor B called in clone.
 * 7) B is created already. So cache returns B. C's neighbor list will be filled with B.
 * 8) C's neighbor A called in clone.
 * 9) A is created already. So cache returns A. C's neighbor list will be filled with A.
 * 10) C neighbor LOOP ends.
 * 11) C returned to B's neighbor LOOP. B's neighbor list will be filled with C.
 * 12) B's neighbor A called in clone.
 * 13) A is created already. So cache returns A. B's neighbor list will be filled with A.
 * 14) B neighbor LOOP ends.
 * 15) B returned to A's neighbor LOOP. A's neighbor list will be filled with B.
 * 16) A's neighbor C called in clone.
 * 17) C is created already. So cache returns C. A's neighbor list will be filled with C.
 *====================================================================
 */
public class CloneGraph {
  private Map<Node, Node> cloneMap = new HashMap<>();

  // As per requirement, The number of nodes will be between 1 and 100. So null not possible
  public Node cloneGraph(Node fromNode) {
    if (cloneMap.containsKey(fromNode)) return cloneMap.get(fromNode);
    Node cloneNode = new Node(fromNode.val, new ArrayList<>());
    cloneMap.put(fromNode, cloneNode);
    for (Node neighbor : fromNode.neighbors) {
      Node clonedNeighbor = cloneGraph(neighbor);
      cloneNode.neighbors.add(clonedNeighbor);
    }
    return cloneNode;
  }
}
