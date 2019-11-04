package com.sample.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class FutureTaskSample {

  static class MyAttribute {
    private int value;

    public MyAttribute(final int value) {
      this.value = value;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    FutureTaskSample s = new FutureTaskSample();
    s.myMain();
  }

  public void myMain() throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    List<String> failed = Collections.synchronizedList(new ArrayList<>());
    List<String> updated = Collections.synchronizedList(new ArrayList<>());
    for (int i = 0; i < 50; i++) {
      MyAttribute attribute = new MyAttribute(i);
      CompletableFuture<Pair<String, Boolean>> updateInventoryFuture =
          CompletableFuture.supplyAsync(() -> myTask(attribute), executor);
      updateInventoryFuture.thenAccept(
          (Pair<String, Boolean> e) -> {
            if (e.getRight()) {
              updated.add(e.getLeft());
            } else {
              failed.add(e.getLeft());
            }
          });
    }
    executor.shutdown();
  }

  public Pair<String, Boolean> myTask(final MyAttribute threadId) {
    try {

      System.out.println("======Thread Running =========== " + threadId.value);
      Thread.sleep(1000);
      return ImmutablePair.of("Success", true);
    } catch (Exception e) {
      return null;
    } finally {
      System.out.println("Thread Exiting " + threadId.value);
    }
  }
}
