package com.sample.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/*
 * Semaphore is useless with fixedThreadPool.
 * FixedThreadPool itself cannot accept/run more than fixed size of threads.
 * Threads whatever applied more than the size of FixedThreadPool will be in waiting queue.
 */
public class SemaphoreTestWithCompletableFuture {

  static class MyAttribute {
    private int value;

    public MyAttribute(final int value) {
      this.value = value;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    SemaphoreTestWithCompletableFuture s = new SemaphoreTestWithCompletableFuture();
    s.myMain();
  }

  public void myMain() throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    Semaphore semaphore = new Semaphore(10);
    List<String> failed = Collections.synchronizedList(new ArrayList<>());
    List<String> updated = Collections.synchronizedList(new ArrayList<>());
    for (int i = 0; i < 50; i++) {

      // semaphore.acquire();
      MyAttribute attribute = new MyAttribute(i);
      CompletableFuture<Pair<String, Boolean>> updateInventoryFuture =
          CompletableFuture.supplyAsync(() -> myTask(semaphore, attribute), executor);
      updateInventoryFuture.thenAccept(
          (Pair<String, Boolean> e) -> {
            if (e.getRight()) {
              updated.add(e.getLeft());
            } else {
              failed.add(e.getLeft());
            }
          });
    }
    System.out.println("For Loop Completed");
    executor.shutdown();
  }

  public Pair<String, Boolean> myTask(final Semaphore semaphore, final MyAttribute threadId) {
    try {

      System.out.println("======Thread Running =========== " + threadId.value);
      Thread.sleep(1000);
      return ImmutablePair.of("Success", true);
    } catch (Exception e) {
      return null;
    } finally {
      System.out.println("Thread Exiting " + threadId.value);
      semaphore.release();
    }
  }
}
