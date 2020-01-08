package com.sample.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockWithConditionSample<Integer> {

  Queue<Integer> queue;
  int capacity;
  Lock lock = new ReentrantLock();
  Condition full = lock.newCondition();
  Condition empty = lock.newCondition();

  public LockWithConditionSample(int size) {
    this.capacity = size;
    queue = new LinkedList<Integer>();
  }

  public void insert(Integer element) {

    try {
      lock.lock();
      if (capacity == queue.size()) {
        full.await();
      }
      full.signal();
      queue.add(element);
      notifyAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public Integer fetchAndRemove() {

    try {
      lock.lock();
      if (0 == capacity) {
        empty.await();
      }
      Integer element = queue.remove();
      empty.signal();
      return element;
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
    return null;
  }
}
