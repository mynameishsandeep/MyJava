package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/

https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/346137/Java-Prim's-Algorithm-with-Priority-Queue

=======Solution Approach using Prims(Greedy) Algorithm =======
1) Find the lowest cost of all. Note the nodes which if forming lowest cost. Lets say A & B
2) From A and B. Find lowest next connected node. Lets say A & C.
3) From B and C. Find lowest next connected node.
4) Follow approach till N-1 times for unvisited nodes.

Prims algorithm in 1 line : Randomly pick a node. Then from there always select connected smallest cost node.

See picture "MinimumCost.png"
5
[[2,1,1],[1,4,3],[1,3,2],[3,4,4]]
Expected : 6

https://www.youtube.com/watch?v=4ZlRH0eK-qQ
Above youtube video says pick the smallest code node first and then proceed.
But we can randomly pick any node and mark it as visited and cost with 0. Then we can proceed.
==============Solution Approach============

1) To Implement Prim's Algorithm we use a Priority Queue to get the edge with least cost,
 and a visited set to keep nodes that are added to the MST(MinimumCostSpanningTree).

1) Build the graph based on the edges.
2) Randomly pick a node to start with(in this case, pick node with id 1).
3) Pop the edge(source, destination with cost) with least cost:
if the "destination node" does NOT exist in the visited, then process it, add its cost to total cost and
add new edges starting from the end node to the queue. mark it as visited.
4) Do step3 till queue empty

======================How the priority queue processes elements========
Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6

[1, 1, 0] --->dummy with 0. processed. node 1 marked as visited.
[1, 2, 5] --> processed. node 2 marked as visited.
[2, 3, 1] --> processed. node 3 marked as visited.
[3, 2, 1] --> visited already so skipped
[2, 1, 5] --> visited already so skipped
[3, 1, 6] --> visited already so skipped
[1, 3, 6] --> visited already so skipped

==============
 */
public class ConnectingCitiesWithMinimumCost {
  public int minimumCost(int N, int[][] connections) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    Set<Integer> visited = new HashSet<>();
    int costs = 0;

    for (int[] conn : connections) {
      int n1 = conn[0], n2 = conn[1], cost = conn[2];

      graph.computeIfAbsent(n1, (k) -> new ArrayList<>());
      graph.computeIfAbsent(n2, (k) -> new ArrayList<>());
      graph.get(n1).add(new int[] {n2, cost});
      graph.get(n2).add(new int[] {n1, cost});
    }

    heap.add(new int[] {1, 1, 0});
    while (!heap.isEmpty()) {
      int[] conn = heap.poll();
      int destinationNode = conn[1], cost = conn[2];

      if (!visited.contains(destinationNode)) {
        costs += cost;
        visited.add(destinationNode);
        for (int[] next : graph.get(destinationNode)) {
          heap.add(new int[] {destinationNode, next[0], next[1]}); // if(!visited.contains(next[0]))
        }
      }
    }

    return visited.size() == N ? costs : -1;
  }
}
