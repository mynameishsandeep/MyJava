package com.sample.datastructure.Graph;

import java.util.ArrayList;
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
 * 1) DFS in Graph is same as tree Traversal(InOrder/PreOrder/PostOrder), only difference is tree has left and right whereas graph
 * has n nodes. So instead of left and right traversal, we will will traverse in loop.
 *
 * Refer /Users/chandrasekhar/projects/MyJava/resources/Graph1.jpg
 */
public class Graph_DepthFirstSearch {
  public static void updateAdjMatrixMap(
      Map<Integer, List<Integer>> adjMatrixMap, int nodeFrom, int nodeTo) {
    if (adjMatrixMap.containsKey(nodeFrom)) {
      List<Integer> nodeToList = adjMatrixMap.get(nodeFrom);
      nodeToList.add(nodeTo);
      adjMatrixMap.put(nodeFrom, nodeToList);
    } else {
      List<Integer> nodeToList = new ArrayList<>();
      nodeToList.add(nodeTo);
      adjMatrixMap.put(nodeFrom, nodeToList);
    }
  }

  public static void main(String args[]) throws Exception {
    Scanner s = new Scanner(System.in);
    String[] nodeEdgeCount = s.nextLine().split(" ");
    int nodeCount = Integer.valueOf(nodeEdgeCount[0]);
    int edgeCount = Integer.valueOf(nodeEdgeCount[1]);
    Map<Integer, List<Integer>> adjMatrixMap = new HashMap<>();
    for (int i = 0; i < edgeCount; i++) {
      String[] nodeFromTo = s.nextLine().split(" ");
      int nodeFrom = Integer.valueOf(nodeFromTo[0]);
      int nodeTo = Integer.valueOf(nodeFromTo[1]);
      updateAdjMatrixMap(adjMatrixMap, nodeFrom, nodeTo);
      updateAdjMatrixMap(adjMatrixMap, nodeTo, nodeFrom);
    }
    int rootNode = Integer.valueOf(s.nextLine());
    boolean isVisited[] = new boolean[nodeCount + 1];
    doDFS(adjMatrixMap, rootNode, isVisited);
    int unVisitedNode = 0;
    for (int i = 1; i <= nodeCount; i++) {
      if (!isVisited[i]) {
        unVisitedNode++;
      }
    }
    System.out.println(unVisitedNode);
  }

  public static void doDFS(
      Map<Integer, List<Integer>> adjMatrixMap, int rootNode, boolean isVisited[]) {
    List<Integer> toNodeList = adjMatrixMap.get(rootNode);
    for (Integer nodeTo : toNodeList) {
      if (!isVisited[nodeTo]) {
        isVisited[nodeTo] = true;
        doDFS(adjMatrixMap, nodeTo, isVisited);
      }
    }
  }
}
