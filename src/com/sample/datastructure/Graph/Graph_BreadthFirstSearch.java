package com.sample.datastructure.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/tutorial/
 *
 * A graph can contain cycles, which may bring you to the same node again while traversing the graph.
 * To avoid processing of same node again, use isVisited array flag.
 *
 * Challenge is to creating the adjacency matrix.
 *
 * Ex:
 * input : [1,2] [2,3] [4,1]
 * map key and value should be below
 * 1 - [2,4] // Even direct relation is not given, when adding 4 as key and 1 as value... 4 as value should be added to 1 as key
 * 2 - [3,1]
 * 3 - [2]
 * 4 - [1]
 *======================Regarding below problem=======
 * 1) Level Order Traversal in Graph is same as tree Level Order Traversal, only difference is tree has left and right whereas graph
 * has n nodes. So inside for loop another for loop will come.
 * 2) Below problem expects to create graph structure and go to the specific level and print the count of nodes in that level.
 * 3) isVisited check is needed in 2 places. which is a trick
 *
 * Refer /Users/chandrasekhar/projects/MyJava/resources/Graph1.jpg
 */
public class Graph_BreadthFirstSearch {

  public static void main(String args[]) throws Exception {
    Scanner s = new Scanner(System.in);
    int total = Integer.parseInt(s.nextLine());
    Map<String, List<String>> adjMatrix = new HashMap<>();
    for (int i = 1; i < total; i++) {
      String[] data = s.nextLine().split(" ");
      if (adjMatrix.containsKey(data[0])) adjMatrix.get(data[0]).add(data[1]);
      else adjMatrix.put(data[0], new ArrayList<>(Arrays.asList(data[1])));

      if (adjMatrix.containsKey(data[1])) adjMatrix.get(data[1]).add(data[0]);
      else adjMatrix.put(data[1], new ArrayList<>(Arrays.asList(data[0])));
    }

    int targetLevel = Integer.parseInt(s.nextLine());

    Deque<String> q = new ArrayDeque<>();
    q.offer("1");
    boolean[] isVisited = new boolean[adjMatrix.size() + 1];
    while (targetLevel-- > 1) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String current = q.poll();
        if (!isVisited[Integer.valueOf(current)]) {
          isVisited[Integer.valueOf(current)] = true;
          List<String> list = adjMatrix.get(current);
          for (String next : list) {
            if (!isVisited[Integer.valueOf(next)]) {
              q.offer(next);
            }
          }
        }
      }
    }
    System.out.println(q.size());
  }
}
