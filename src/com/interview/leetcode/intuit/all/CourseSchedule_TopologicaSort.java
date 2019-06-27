package com.interview.leetcode.intuit.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 *
3
[[0,1],[0,2],[1,2]] --- valid with cycle
 *
 * https://leetcode.com/problems/course-schedule/
 * https://www.educative.io/collection/page/5668639101419520/5671464854355968/6010387461832704
 * 0) create adjMatrix. create inDegree map.
 * 1) inDegree stores the count of incoming.
 * 2) identify source from inDegree.
 * 3) Do BFS on source.
 * 4) poll the source and add it to sortedOrderOfNode.
 * 5) reduce inDegree, if adjMatrix contains source.
 * 6) If the inDegree is zero. Then it can act as a source. So add this is queue.
 * 7) Go to Step 4.
 *


 */
public class CourseSchedule_TopologicaSort {

  public boolean canFinish(int n, int[][] pre) {
    Map<Integer, List<Integer>> adjMatrix = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();

    for (int i = 0; i < pre.length; i++) {
      if (adjMatrix.containsKey(pre[i][1])) {
        adjMatrix.get(pre[i][1]).add(pre[i][0]);
      } else {
        adjMatrix.put(pre[i][1], new ArrayList<>(Arrays.asList(pre[i][0])));
      }
      if (inDegree.containsKey(pre[i][0])) {
        inDegree.put(pre[i][0], inDegree.get(pre[i][0]) + 1);
      } else {
        inDegree.put(pre[i][0], 1);
      }
    }

    List<Integer> source = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!inDegree.containsKey(i)) {
        source.add(i);
      }
    }
    if (source.isEmpty()) return false;
    Queue<Integer> q = new LinkedList<>();
    q.addAll(source);
    List<Integer> sortedOrder = new ArrayList<>();
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int curr = q.poll();
        sortedOrder.add(curr);
        if (adjMatrix.get(curr) != null) {
          List<Integer> list = adjMatrix.get(curr);
          for (Integer l : list) {
            if (inDegree.containsKey(l)) {
              inDegree.put(l, inDegree.get(l) - 1);
            }
            if (inDegree.get(l) == 0) {
              q.offer(l);
            }
          }
        }
      }
    }
    return (sortedOrder.size() == n);
  }
}
