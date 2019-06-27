package com.sample.datastructure.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * ====
 * Fibonacci series can be said as Topological Series.
 * Because to get f(n), pre-requisites are f(n-1) and f(n-2).
 * to get f(n-1), pre-requisites are f(n-2) and f(n-3).
 * =======
 * 1) It is on directed graph
 * 2) Can be done only on Acyclic(no cycle) graph.
 * 3) There can be more than one answer can come for the sorting. See picture "Topological Sort.png".
 * Answer can be 12345 or 12354
 * 4) Applications are 1) Pre-Requisite problem(CourseSchedule.java),2) Task Scheduling
 * 5) indegree field is about number of incoming edges for a node.
 *
 *  Ex: [1,2] [1,3] [2,4][3,4]
 *  				1
 *  			2		3
 *  				4
 *  Here 4 cannot come before 3 and 2... So possible output is 1234 or 1324.
 *  The above example is not a cycle. 
 */
public class TopologicalSort {
  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();
    if (vertices <= 0) return sortedOrder;

    // a. Initialize the graph. // count of incoming edges for every vertex
    HashMap<Integer, Integer> inDegree = new HashMap<>();
    HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
    for (int i = 0; i < vertices; i++) {
      inDegree.put(i, 0);
      graph.put(i, new ArrayList<Integer>());
    }

    // b. Build the graph
    for (int i = 0; i < edges.length; i++) {
      int parent = edges[i][0], child = edges[i][1];
      graph.get(parent).add(child); // put the child into it's parent's list
      inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
    }

    // c. Find all sources i.e., all vertices with 0 in-degrees
    Queue<Integer> sources = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) sources.add(entry.getKey());
    }

    // d. For each source, add it to the sortedOrder and subtract one from all of its children's
    // in-degrees
    // if a child's in-degree becomes zero, add it to the sources queue
    while (!sources.isEmpty()) {
      int vertex = sources.poll();
      sortedOrder.add(vertex);
      List<Integer> children =
          graph.get(vertex); // get the node's children to decrement their in-degrees
      for (int child : children) {
        inDegree.put(child, inDegree.get(child) - 1);
        if (inDegree.get(child) == 0) sources.add(child);
      }
    }

    if (sortedOrder.size() != vertices) // topological sort is not possible as the graph has a cycle
    return new ArrayList<>();

    return sortedOrder;
  }

  public static void main(String[] args) {
    List<Integer> result =
        TopologicalSort.sort(
            4,
            new int[][] {new int[] {3, 2}, new int[] {3, 0}, new int[] {2, 0}, new int[] {2, 1}});
    System.out.println(result);

    result =
        TopologicalSort.sort(
            5,
            new int[][] {
              new int[] {4, 2},
              new int[] {4, 3},
              new int[] {2, 0},
              new int[] {2, 1},
              new int[] {3, 1}
            });
    System.out.println(result);

    result =
        TopologicalSort.sort(
            7,
            new int[][] {
              new int[] {6, 4},
              new int[] {6, 2},
              new int[] {5, 3},
              new int[] {5, 4},
              new int[] {3, 0},
              new int[] {3, 1},
              new int[] {3, 2},
              new int[] {4, 1}
            });
    System.out.println(result);
  }
}
