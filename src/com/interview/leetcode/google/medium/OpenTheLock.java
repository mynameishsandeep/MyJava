package com.interview.leetcode.google.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/open-the-lock/
 */
public class OpenTheLock {
  private boolean[] visited = new boolean[10000];
  private Queue<Integer> queue = new LinkedList<>();

  public int openLock(String[] deadends, String target) {
    int count = 0;
    for (String s : deadends) visited[Integer.parseInt(s)] = true;

    if (visited[0]) return -1;

    visited[0] = true;
    queue.offer(0);

    int targetNum = Integer.parseInt(target);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        if (cur == targetNum) return count;

        int pos = 1; // 10^0
        for (int j = 0; j < 4; j++) {
          addValidElementInQueue(cur, pos, 1); // turn incrementing
          addValidElementInQueue(cur, pos, -1); // turn decrementing

          pos = (pos << 3) + (pos << 1);
        }
      }
      count++;
    }
    return -1;
  }

  private void addValidElementInQueue(int curNum, int pos, int dir) {
    int positionToBeAltered = (curNum / pos) % 10;
    int edge = 1;
    if (positionToBeAltered + dir >= 10 || positionToBeAltered + dir < 0) {
      // if turn incrementing (+1) >= 10, it will be 0, and we shoud subtract.
      // or turn decrementing(-1) < 0, it will be 9, and we should add.
      dir = -dir;
      edge = 9;
    }
    int next = curNum + edge * pos * dir;

    if (!visited[next]) {
      visited[next] = true;
      queue.offer(next);
    }
  }
}
