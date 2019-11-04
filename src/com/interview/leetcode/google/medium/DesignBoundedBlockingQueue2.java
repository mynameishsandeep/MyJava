package com.interview.leetcode.google.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/design-bounded-blocking-queue/
 *
 * 1) Only one operation can happen at a time either offer or poll.
 */
public class DesignBoundedBlockingQueue2 {

  private Queue<Integer> queue;
  private int capacity;

  public DesignBoundedBlockingQueue2(int capacity) {
    this.queue = new LinkedList<>();
    this.capacity = capacity;
  }

  public synchronized void enqueue(int element) throws InterruptedException {
    while (queue.size() == capacity) {
      wait();
    }

    queue.offer(element);
    notifyAll();
  }

  public synchronized int dequeue() throws InterruptedException {
    while (queue.isEmpty()) {
      wait();
    }
    int val = queue.poll();
    notifyAll();
    return val;
  }

  public int size() {
    return queue.size();
  }
}
