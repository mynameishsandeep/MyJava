package com.sample.performance;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * How Parallel Stream works.
 * 0) Lets say I have 4 processor in my mac.
 * 1) For the 1 stream, by default it spawns threads equal to n core. So 4 threads.
 * 2) For the 2 stream, it takes 1 + 4. So total of 5 threads.
 * 3) For the 3 stream, it takes 2 + 4. So total of 6 threads.
 */
public class ParallelStreamBlockingAnotherParallelStream {
  public static void main(String[] args) {
    System.out.println(
        "Number of Processor in My Machine " + Runtime.getRuntime().availableProcessors());
    ParallelStreamBlockingAnotherParallelStream p =
        new ParallelStreamBlockingAnotherParallelStream();

    p.createThread();
  }

  public void createThread() {
    ExecutorService exec = Executors.newFixedThreadPool(3);

    CompletableFuture.runAsync(this::testParallelStream1, exec);
    CompletableFuture.runAsync(this::testParallelStream2, exec);
    CompletableFuture.runAsync(this::testParallelStream3, exec);
    exec.shutdown();
  }

  public void testParallelStream1() {
    System.out.println("Parallel Stream1 Initiated...");
    List<String> alpha2 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
    alpha2.parallelStream().forEach(this::printStale1);
    System.out.println("Parallel Stream1 Completed...");
  }

  public void testParallelStream2() {
    System.out.println("Parallel Stream2 Initiated...");
    List<String> alpha2 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
    alpha2.parallelStream().forEach(this::printStale2);
    System.out.println("Parallel Stream2 Completed...");
  }

  private void printStale1(String s) {
    System.out.println("Parallel Stream1 " + s + " " + Thread.currentThread().getName());
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {

    }
  }

  private void printStale2(String s) {
    System.out.println("Parallel Stream2 " + s + " " + Thread.currentThread().getName());
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {

    }
  }

  public void testParallelStream3() {
    System.out.println("Parallel Stream3 Initiated...");
    List<String> alpha2 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
    alpha2.parallelStream().forEach(this::printStale3);
    System.out.println("Parallel Stream3 Completed...");
  }

  private void printStale3(String s) {
    System.out.println("Parallel Stream3 " + s + " " + Thread.currentThread().getName());
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {

    }
  }
}
