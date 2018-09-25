package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.UndirectedGraphNode;

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
 * 
 * The key part is what to return if 
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return clone(node, new HashMap<>());
	}

	public UndirectedGraphNode clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap) {
		if (node == null) {
			return null;
		}
		if (cloneMap.containsKey(node)) {
			return cloneMap.get(node);
		}
		UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
		cloneMap.put(node, cloneNode);

		for (int i = 0; i < node.neighbors.size(); i++) {
			UndirectedGraphNode clonedNodeResult = clone(node.neighbors.get(i), cloneMap);
			cloneNode.neighbors.add(clonedNodeResult);
		}
		return cloneNode;
	}
}
