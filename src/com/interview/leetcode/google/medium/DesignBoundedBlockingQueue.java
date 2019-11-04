package com.interview.leetcode.google.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DesignBoundedBlockingQueue {

  private Queue<Integer> queue = null;
  private int capacity = 0;
  private ReentrantLock lock = new ReentrantLock();
  private Condition enqueueThread = lock.newCondition();
  private Condition dequeueThread = lock.newCondition();

  public DesignBoundedBlockingQueue(int capacity) {
    this.capacity = capacity;
    queue = new LinkedList<>();
  }

  public void enqueue(int element) throws InterruptedException {
    lock.lock();
    try {
      while (size() == capacity) { // To avoid spurious wakeup using while instead of if
        enqueueThread.await();
      }
      queue.offer(element);
      dequeueThread.signalAll();
    } finally {
      lock.unlock();
    }
  }

  public int dequeue() throws InterruptedException {
    lock.lock();
    try {
      while (size() == 0) { // To avoid spurious wakeup using while instead of if
        dequeueThread.await();
      }
      int elem = queue.poll();
      enqueueThread.signalAll();
      return elem;
    } finally {
      lock.unlock();
    }
  }

  public int size() {
    return queue.size();
  }
}
