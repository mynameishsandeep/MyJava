package com.sample.datastructure.Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/tutorial/
 * 
 * A graph can contain cycles, which may bring you to the same node again while traversing the graph. 
 * To avoid processing of same node again, use isVisited array flag.
 * 
 * Challenge is to creating the adjacency matrix. 
 * Ex: 
 * input : [1,2] [2,3] [4,1]
 * map key and value should be below
 * 1 - [2,4] // Even direct relation is not given, when adding 4 as key and 1 as value... 4 as value should be added to 1 as key
 * 2 - [3,1] 
 * 3 - [2]
 * 4 - [1]
 * 
 * Level Order Traversal in Graph is same as tree Level Order Traversal, only difference is tree has left and right whereas graph has n nodes.
 * So inside for loop another for loop will come.  
 *  
 * Refer /Users/chandrasekhar/projects/MyJava/resources/Graph1.jpg
 */
public class Graph_BreadthFirstSearch {

	public static void updateAdjMatrixMap(Map<Integer, Set<Integer>> adjMatrixMap, Integer nodeFrom, Integer nodeTo) {
		if (adjMatrixMap.containsKey(nodeTo)) {
			Set<Integer> nodeToListFromValue = adjMatrixMap.get(nodeTo);
			nodeToListFromValue.add(nodeFrom);
			adjMatrixMap.put(nodeTo, nodeToListFromValue);
		} else {
			Set<Integer> s1 = new HashSet<>();
			s1.add(nodeFrom);
			adjMatrixMap.put(nodeTo, s1);
		}
	}

	public static void doBFS(Map<Integer, Set<Integer>> adjMatrixMap, int targetLevel, int nodeSize) {
		Deque<Integer> queue = new ArrayDeque<>();
		Set<Integer> rootNode = adjMatrixMap.get(1);
		for (Integer rootChildNode : rootNode) {
			queue.offer(rootChildNode);
		}

		boolean isVisited[] = new boolean[nodeSize + 1];
		// 0th index not used, for simplification of code
		isVisited[1] = true;
		int size = 0;
		while (targetLevel-- > 1) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				int node = queue.poll();
				// In Tree Traversal, below for loop is not needed, as tree has left and right node only
				if (!isVisited[node]) {
					isVisited[node] = true;
					Set<Integer> childNodes = adjMatrixMap.get(node);
					for (Integer childNode : childNodes) {
						if (!isVisited[childNode]) {
							queue.offer(childNode);
						}
					}

				}
			}
		}
		System.out.print(size);
	}

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int nodeSize = Integer.valueOf(s.nextLine());

		Map<Integer, Set<Integer>> adjMatrixMap = new HashMap<>();
		for (int i = 0; i < nodeSize - 1; i++) {
			String[] edge = s.nextLine().split(" ");
			int nodeFrom = Integer.valueOf(edge[0]);
			int nodeTo = Integer.valueOf(edge[1]);
			updateAdjMatrixMap(adjMatrixMap, nodeTo, nodeFrom);
			updateAdjMatrixMap(adjMatrixMap, nodeFrom, nodeTo);
		}
		int targetLevel = Integer.valueOf(s.nextLine());
		doBFS(adjMatrixMap, targetLevel, nodeSize);

	}
}
