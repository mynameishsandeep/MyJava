package com.sample.performance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

import org.apache.commons.lang3.tuple.Pair;

public class ParallelStreamAsyncThreadIssue {
  private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

  public static void main(String[] args) throws InterruptedException {
    ParallelStreamAsyncThreadIssue p = new ParallelStreamAsyncThreadIssue();
    p.parallelStream();
  }

  /*
   * DynamoDb can accept only 25 request in a batch. But it supports 40000 writes in a second
   * 1) So I can send 40000 unique requests or
   * 2) I can send 40000/25 batches in a second
   * Since multiple user needs to access the same table.
   * We send 100 request or 4 batches of 25. Lets say it takes 100ms.
   * Then we sleep for another 100 ms. So 500 requests can be fired in a second for a user.
   *
   */
  public void parallelStream() throws InterruptedException {
    System.out.println("==========Parallel Stream Totaly Wrong=============....");
    List<Integer> success = new ArrayList<>();
    List<Integer> failure = new ArrayList<>();
    final int SOURCE_SIZE = 289;
    final int MAX_REQUEST_IN_A_BATCH = 25;
    List<CompletableFuture<Void>> futureArray = new ArrayList<>();
    final int BATCH_SIZE = 4;
    int currentBatch = 0;
    int totalBatch =
        (SOURCE_SIZE % MAX_REQUEST_IN_A_BATCH == 0)
            ? (SOURCE_SIZE / MAX_REQUEST_IN_A_BATCH)
            : (SOURCE_SIZE / MAX_REQUEST_IN_A_BATCH + 1);
    System.out.println("totalBatch " + totalBatch);

    for (int i = 1; i <= SOURCE_SIZE; i++) {
      final int value = i;
      if (i % MAX_REQUEST_IN_A_BATCH == 0 || i == SOURCE_SIZE) {
        int start =
            i == SOURCE_SIZE
                ? (currentBatch * MAX_REQUEST_IN_A_BATCH) + 1
                : value - MAX_REQUEST_IN_A_BATCH + 1;
        futureArray.add(
            CompletableFuture.supplyAsync(() -> fun(start, value), EXECUTOR)
                .thenAccept(
                    (List<Pair<Boolean, Integer>> response) -> {
                      response
                          .parallelStream()
                          .filter(Pair::getLeft)
                          .map(Pair::getRight)
                          .forEach(success::add);
                      response
                          .parallelStream()
                          .filter(Predicate.not(Pair::getLeft))
                          .map(Pair::getRight)
                          .forEach(failure::add);
                    }));
        currentBatch++;
        System.out.println("currentBatch " + currentBatch);
        if (currentBatch % BATCH_SIZE == 0 || currentBatch == totalBatch) {
          System.out.println("Waiting");
          CompletableFuture.allOf(futureArray.toArray(new CompletableFuture[futureArray.size()]))
              .join();
          System.out.println("Waiting Completed");
          // Sleep manually
          Thread.currentThread().sleep(500);
        }
      }
    }
    EXECUTOR.shutdown();
    System.out.println(SOURCE_SIZE + " " + success.size() + " " + failure.size());
  }

  private List<Pair<Boolean, Integer>> fun(int start, int end) {
    System.out.println(Thread.currentThread() + " started");
    List<Pair<Boolean, Integer>> result = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      if (i % 2 == 0) result.add(Pair.of(true, i));
      else result.add(Pair.of(false, i));
    }
    System.out.println(Thread.currentThread() + " ended ");
    return result;
  }
}
