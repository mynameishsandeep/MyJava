package com.sample.datastructure.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
**   1. Graph representation
 *   2. DFS/BFS
 *   3. isConnected - given 2 vertices see if they are connected
 *   4. detect_cycle in a directed graph
 *   5. Topological sorting - DAGs only (same dfs, store the result in the stack after the recursive call)
 *   6. Shortest path in an undirected graph
 */
public class GraphAll {
	public class Vertex {
		int key;
		boolean visited;

		Vertex(int value) {
			key = value;
			visited = false;
		}
	}

	private boolean directedFlag = true;
	private Map<Vertex, Set<Vertex>> adjList;

	GraphAll() {
		adjList = new HashMap<Vertex, Set<Vertex>>();
	}

	private Vertex addVertex(int a) {
		Vertex v1 = new Vertex(a);
		adjList.put(v1, new HashSet<Vertex>());
		return v1;
	}

	private void addEdge(Vertex v1, Vertex v2) {
		Set<Vertex> set = adjList.get(v1);
		set.add(v2);
		if (!directedFlag) {
			if (adjList.containsKey(v2)) {
				set = adjList.get(v2);
				set.add(v1);
			}
		}
	}

	public void bfsGraph(Vertex v) {
		if (v == null)
			return;
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(v);
		v.visited = true;
		System.out.println("BFS");
		while (!queue.isEmpty()) {
			Vertex nextVertex = queue.poll();
			System.out.print(nextVertex.key + " -> ");
			for (Vertex neighbor : adjList.get(nextVertex)) {
				if (!neighbor.visited) {
					neighbor.visited = true;
					queue.add(neighbor);
				}
			}
		}
	}

	public void dfsGraph(Vertex v) {
		System.out.print(v.key + " -> ");
		v.visited = true;
		for (Vertex neighbor : adjList.get(v)) {
			if (!neighbor.visited) {
				dfsGraph(neighbor);
			}
		}
	}

	public boolean isConnected(Vertex v1, Vertex v2) {
		System.out.print(v1.key + " -> ");
		if (v1 == v2)
			return true;
		v1.visited = true;
		for (Vertex neighbor : adjList.get(v1)) {
			if (!neighbor.visited) {
				return isConnected(neighbor, v2);
			}
		}
		return false;
	}

	public boolean detect_cycle(Vertex v) {
		Set<Vertex> visited = new HashSet<Vertex>();
		Set<Vertex> path = new HashSet<Vertex>();
		return detect_cycle(v, visited, path);
	}

	private boolean detect_cycle(Vertex v, Set<Vertex> visited, Set<Vertex> path) {
		if (path.contains(v))
			return true;
		if (visited.contains(v))
			return false;
		visited.add(v);
		path.add(v);
		for (Vertex neighbor : adjList.get(v)) {
			if (detect_cycle(neighbor, visited, path)) {
				return true;
			}
		}
		path.remove(v);
		return false;
	}

	private void printGraph(Vertex v1) {
		for (Vertex v : adjList.keySet()) {
			System.out.print("Vertex : " + v.key + " connected to : ");
			for (Vertex child : adjList.get(v)) {
				System.out.print(child.key + " , ");
			}
			System.out.println();
		}
	}

	public List<Vertex> shortestPath(Vertex v1, Vertex v2) {
		Map<Vertex, Vertex> paths = new HashMap<Vertex, Vertex>();
		Vertex dummy = new Vertex(0);
		paths.put(v1, dummy);
		Set<Vertex> visitedSet = new HashSet<Vertex>();
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(v1);
		visitedSet.add(v1);
		boolean flag = false;
		while (!queue.isEmpty()) {
			Vertex dest = queue.poll();
			for (Vertex neighbor : adjList.get(dest)) {
				if (!visitedSet.contains(neighbor)) {
					visitedSet.add(neighbor);
					queue.add(neighbor);
					paths.put(neighbor, dest);
				}
				if (neighbor == v2) {
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}
		List<Vertex> path = new ArrayList<Vertex>();

		if (!paths.containsKey(v2)) {
			return null; //no path
		} else {
			Vertex curr = v2;
			while (curr != dummy) {
				path.add(curr);
				curr = paths.get(curr);
			}
		}
		return path;
	}

	private void topologicalSort(Vertex v, Set<Vertex> visited, Stack<Vertex> stack) {
		if (visited.contains(v))
			return;
		visited.add(v);

		for (Vertex neighbor : adjList.get(v)) {
			topologicalSort(neighbor, visited, stack);
		}
		stack.push(v);
	}

	public void topologicalSort(Vertex v) {
		Set<Vertex> visited = new HashSet<Vertex>();
		Stack<Vertex> stack = new Stack<Vertex>();
		topologicalSort(v, visited, stack);
		System.out.print("Topological Sort : ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().key + " ->");
		}
	}

	private static void testBench() {
		// write all unit test cases
		GraphAll test1 = new GraphAll();
		Vertex v1 = test1.addVertex(1);
		Vertex v2 = test1.addVertex(2);
		Vertex v3 = test1.addVertex(3);
		Vertex v4 = test1.addVertex(4);
		Vertex v5 = test1.addVertex(5);
		Vertex v6 = test1.addVertex(6);
		Vertex v7 = test1.addVertex(7);

		test1.addEdge(v1, v2);
		test1.addEdge(v1, v4);
		test1.addEdge(v2, v3);
		test1.addEdge(v3, v7);
		test1.addEdge(v4, v5);
		test1.addEdge(v5, v6);
		test1.addEdge(v6, v7);

		test1.printGraph(v1);
		//System.out.print("DFS : ");
		test1.dfsGraph(v1);
		System.out.println();
		//test1.bfsGraph(v1);
		//boolean result = test1.isConnected(v1, v4);
		//System.out.println(result);
		for (Vertex p : test1.shortestPath(v1, v7))
			System.out.print(p.key + " -> ");
		System.out.println();
		boolean res = test1.detect_cycle(v1);
		System.out.println(res);
		test1.topologicalSort(v1);
	}

	public static void main(String args[]) {
		testBench();
	}
}