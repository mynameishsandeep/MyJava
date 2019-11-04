package com.sample.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class CompletableFutureWithoutSemaphoreTest {

  static class MyAttribute {
    private int value;

    public MyAttribute(final int value) {
      this.value = value;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    CompletableFutureWithoutSemaphoreTest s = new CompletableFutureWithoutSemaphoreTest();
    s.myMain();
  }

  public void myMain() throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 50; i++) {
      MyAttribute attribute = new MyAttribute(i);
      final FutureTask<Pair<String, Boolean>> dynamoTask = myTask(attribute);
      executor.execute(dynamoTask);
    }
    executor.shutdown();
  }

  private FutureTask<Pair<String, Boolean>> myTask(final MyAttribute threadId) {
    return new FutureTask<>(
        new Callable<Pair<String, Boolean>>() {
          @Override
          public Pair<String, Boolean> call() {
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
        });
  }
}
