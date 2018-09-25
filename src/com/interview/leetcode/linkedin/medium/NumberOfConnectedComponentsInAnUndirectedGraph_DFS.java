package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77655/Clean-Java-Code-Union-Find
 * 
 Input: n = 4, edges = [[2,3],[1,2],[1,3]] , Output: 2... Input is connected all the way and forming only 1 connection. 
 But 1 node is hanging which is not given in edges relation. So output= connectedCount + n-nodesWithVisitedFlag.size();
 * 
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph_DFS {

	/*
	 * Since the node is always from 1 to n so below logic will work. 
	 */
	public void updateAdjMatrixMap(Map<Integer, List<Integer>> adjMatrixMap, int nodeFrom, int nodeTo) {
		adjMatrixMap.get(nodeFrom).add(nodeTo);
	}

	/*
	 * Since the node is always from 1 to n so below logic will work. 
	 */
	public void updateAdjMatrixMapDefault(Map<Integer, List<Integer>> adjMatrixMap, int n) {
		for (int i = 1; i <= n; i++) {
			adjMatrixMap.put(i, new ArrayList<>());
		}
	}

	public int countComponents(int n, int[][] edges) {
		Map<Integer, List<Integer>> adjMatrixMap = new HashMap<>();
		updateAdjMatrixMapDefault(adjMatrixMap, n);
		for (int i = 0; i < edges.length; i++) {
			updateAdjMatrixMap(adjMatrixMap, edges[i][0], edges[i][1]);
			updateAdjMatrixMap(adjMatrixMap, edges[i][0], edges[i][1]);
		}
		Set<Integer> isVisited = new HashSet<>();
		int connectedCount = 0;
		for (int i = 1; i <= n; i++) {
			if (isVisited.add(i)) {
				connectedCount++;
				doDFS(adjMatrixMap, i, isVisited);
			}
		}
		//return connectedCount; // Hanging nodes with no connections should be added in result. which is done by below line.
		return connectedCount + n - isVisited.size();

	}

	public void doDFS(Map<Integer, List<Integer>> adjMatrixMap, int parentNode, Set<Integer> isVisited) {
		for (Integer childNode : adjMatrixMap.get(parentNode)) {
			if (isVisited.add(childNode)) {
				doDFS(adjMatrixMap, childNode, isVisited);
			}

		}
	}
}
